package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 13301 - 타일 장식물
 */
public class p13301 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    static long[] dp = new long[81];
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        dp[0] = 0;
        dp[1] = 2;
        dp[2] = 4;

        long length = 4;

        for (int i=3; i<dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        for (int i=1; i<N; i++) {
            length += dp[i];
        }

        System.out.println(length);

        reader.close();
    }
}
