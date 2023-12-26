package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 12970 - AB
 */
public class p12970 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int K;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        for (int a=0; a<=N; ++a) {
            int b = N - a;

//            System.out.println(String.format("a : %d, b : %d", a, b));
            if (a * b < K) continue;

            int[] A = new int[b+1];
            for (int i=0; i<a; i++) {
                int idx = Math.min(K, b);
//                System.out.println(String.format("idx : %d", idx));

                A[idx] += 1;
                K -= idx;
            }

            for (int i=b; i>=0; --i) {
                for (int j=0; j<A[i]; ++j) {
                    sb.append("A");
                }

                if (i>0) sb.append("B");
            }
//            System.out.println(Arrays.toString(A));
            System.out.println(sb);
            return;
        }

        System.out.println(-1);

        reader.close();
    }
}
