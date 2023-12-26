package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 4307 - 개미
 */
public class p4307_2 {
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

            int mid = L/2;

            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i=0; i<C; i++) {
                int n = Integer.parseInt(reader.readLine());
                int diff = n > mid ? L-n : n;

                if (max < diff) {
                    max = diff;
                }
                if (min > diff) {
                    min = diff;
                }
            }

            System.out.println(max + " " + (L - min));
        }

        reader.close();
    }
}
