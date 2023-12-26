package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 10870 - 피보나치수 5
 */
public class p10870 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[] dp;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(reader.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }

        dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<dp.length; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        System.out.println(dp[n]);
    }
}
