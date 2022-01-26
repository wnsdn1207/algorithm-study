package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 9507 - Generations of Tribbles
 *
 * t (0 < t < 69)
 * n (0 ≤ n ≤ 67)
 *
 * 예제 입력 1
 * 8
 * 0
 * 1
 * 2
 * 3
 * 4
 * 5
 * 30
 * 67
 * 예제 출력 1
 * 1
 * 1
 * 2
 * 4
 * 8
 * 15
 * 201061985
 * 7057305768232953720
 */
public class p9507 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;
    static long[] dp = new long[68];

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        dp[0] = dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 4L;

        for (int i=4; i<68; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3] + dp[i-4];
        }

        while (T-- > 0) {
            System.out.println(dp[Integer.parseInt(reader.readLine())]);
        }

        reader.close();
    }
}
