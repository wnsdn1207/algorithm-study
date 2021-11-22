package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1713 - 후보 추천하기
 */
public class p1713 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int T;
    /**
     * 3
     * 9
     * 2 1 4 3 5 6 2 7 2
     */
    static int[] students = new int[101];
    static ArrayList<Students> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        T = Integer.parseInt(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        for (int i=0; i<T; i++) {
            int idx = Integer.parseInt(st.nextToken());

            if (students[idx] > 0) {
                students[idx] += 1;
                for (Students student : list) {
                    if (student.number == idx) {
                        student.recommendCnt += 1;
                        break;
                    }
                }
            } else {
                if (list.size() >= N) {
                    Collections.sort(list);
                    int num = list.get(0).number;
                    students[num] = 0;
                    list.remove(0);
                }
                list.add(new Students(idx, 1, i));
                students[idx] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<101; i++) {
            if (students[i] > 0) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);

        reader.close();
    }

    static class Students implements Comparable<Students> {
        private int number;
        private int recommendCnt;
        private int recommendTime;

        Students(int number, int recommendCnt, int recommendTime) {
            this.number = number;
            this.recommendCnt = recommendCnt;
            this.recommendTime = recommendTime;
        }

        @Override
        public int compareTo(Students o) {
            if (this.recommendCnt == o.recommendCnt) {
                return this.recommendTime - o.recommendTime;
            } else if (this.recommendCnt < o.recommendCnt) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
