package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1931 - 회의실 배정
 *
 * N(1 ≤ N ≤ 100,000)
 * 시작 시간과 끝나는 시간은 2^31-1보다 작거나 같은 자연수 또는 0이다.
 *
 * 예제 입력 1
 * 11
 * 1 4
 * 3 5
 * 0 6
 * 5 7
 * 3 8
 * 5 9
 * 6 10
 * 8 11
 * 8 12
 * 2 13
 * 12 14
 *
 * 예제 출력 1
 * 4
 */
public class p1931 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static List<ReservedTime> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            list.add(new ReservedTime(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // ReservedTime 객체 내에 정의된 CompareTo()를 기준으로 정렬
        // 종료 시간이 빠른 것부터 정렬
        // 종료 시간이 같다면, 시작 시간이 빠른 것부터 정렬
        // (8,8), (4,8)이 나올 경우 (8,8)부터 선택되면 다음 (4,8)이 선택될 수 없다.
        Collections.sort(list);
        int count = 0;
        // 비교를 위한 prev 객체를 (0,0)으로 세팅하여 준다.
        ReservedTime prev = new ReservedTime(0, 0);
        for (int i=0; i<list.size(); i++) {
//            System.out.println(list.get(i));

            // 현재 회의 시작 시점이 이전 회의 시간이 끝난 시점보다 같거나 크다면 다음 회의를 시작할 수 있다.
            if (prev.end <= list.get(i).start) {
                count++;
                // 이전 회의를 갱신해준다.
                prev = list.get(i);
            }
        }

        System.out.println(count);

        reader.close();
    }

    static class ReservedTime implements Comparable<ReservedTime> {
        int start;
        int end;

        public ReservedTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(ReservedTime o) {
            if (this.end == o.end) {
                return this.start - o.end;
            }
            return this.end - o.end;
        }

        @Override
        public String toString() {
            return "ReservedTime{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
