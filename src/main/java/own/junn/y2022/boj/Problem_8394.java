package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 8394 - 악수
 */
public class Problem_8394 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[] dp;
    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(reader.readLine());

        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<n+1; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 10;
        }

        System.out.println(dp[n]);
        reader.close();
    }
}
