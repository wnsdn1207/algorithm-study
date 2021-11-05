package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11501 - 주식
 */
public class Problem_11501 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        long[] cases = new long[T];
        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(reader.readLine());

            long[] arr = new long[N];
            long max = 0;
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            for (int j=0; j<N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j=N-1; j>=0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                } else {
                    cases[i] += (max - arr[j]);
                }
            }
        }

        for (long i : cases) {
            System.out.println(i);
        }

        reader.close();
    }
}
