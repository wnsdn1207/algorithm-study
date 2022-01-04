package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1309 - 동물원
 *
 * N(1≤N≤100,000)
 *
 * 예제 입력 1
 * 4
 * 예제 출력 1
 * 41
 */
public class p1309 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        dp = new int[N+1];

        dp[0] = 1;
        dp[1] = 3;

        /**
         * 점화식
         * (n-2)번째 값 + (n-1)번째 값*2
         *
         * N=1 => 3
         * N=2 => 7
         * N=3 => 12
         * N=4 => 29
         * N=5 => 70
         */
        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-2] + dp[i-1]*2;
            dp[i] %= 9901;
        }

        System.out.println(dp[N]);

        reader.close();
    }
}
