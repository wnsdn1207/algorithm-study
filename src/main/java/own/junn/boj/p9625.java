package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 9625 - BABBA
 */
public class p9625 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] dp = new int[101];
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<N; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        if (N == 1) {
            System.out.println("0 1");
        } else {
            System.out.println(dp[N-2] + " " + dp[N-1]);
        }
        reader.close();
    }
}
