package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 14495 - 피보나치 비스무리한 수열
 */
public class p14495 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static long[] dp;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        dp = new long[150];

        dp[0] = dp[1] = dp[2] = 1L;
        for (int i=3; i<dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-3];
        }

        System.out.println(dp[N-1]);
        System.out.println(dp[115]);

        reader.close();
    }
}
