package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 4307 - 개미
 */
public class p4307 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;

    static int L;
    static int C;

    static LinkedList<Integer> list = new LinkedList<>();
    static int[] sticks;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

            L = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            sticks = new int[L+1];
            list.clear();

            for (int i=0; i<C; i++) {
                int n = Integer.parseInt(reader.readLine());

                sticks[n] = 1;
                list.add(n);
            }

            System.out.println(MIN_VALUE() + " " + MAX_VALUE());
        }

        reader.close();
    }

    static int MAX_VALUE() {
        List<Integer> clonedList = new LinkedList<>(list);
        Collections.sort(clonedList);

        int maximum = clonedList.get(clonedList.size()-1);
        int minimum = clonedList.get(0);

        return Math.max(Math.max(maximum, Math.abs(maximum-L)), Math.max(minimum, Math.abs(minimum-L)));
    }

    static int MIN_VALUE() {
        int mid = L/2;

        int minDiff = Integer.MAX_VALUE, minDiffIdx = 0;
        for (int i=0; i<=L; i++) {
            if (sticks[i] > 0) {
                if (minDiff > Math.abs(i - mid)) {
                    minDiff = Math.abs(i - mid);
                    minDiffIdx = i;
                }
            }
        }

        return Math.min(minDiffIdx, Math.abs(minDiffIdx - L));
    }
}
