package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 19939 - 박 터뜨리기
 */
public class p19939 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int K;

    static int[] dp;
    static int[] numbers;

    public static void main(String[] args) throws Exception {
        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        dp = new int[K+1];
        numbers = new int[K+1];

        dp[0] = 0;
        for (int i=1; i<=K; i++) {
            dp[i] = dp[i-1] + i;
            numbers[i] = dp[i] - dp[i-1];
        }

        if (dp[K] <= N) {
            int n = N - dp[K];
//            System.out.println("numbers : " + Arrays.toString(numbers));
//            System.out.println("n : " + n);

            while (n / K > 0) {
                for (int i=K; i>=1; i--) {
                    numbers[i] += 1;
                }
                n -= K;
            }

            for (int i=K; i>K-n; i--) {
                numbers[i] += 1;
            }

            System.out.println(numbers[K] - numbers[1]);

        } else {
            System.out.println(-1);
        }

        reader.close();
    }
}
