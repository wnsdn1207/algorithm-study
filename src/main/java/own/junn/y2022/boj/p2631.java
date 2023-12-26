package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2631 - 줄세우기 (LIS)
 */
public class p2631 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] array;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        N = stoi(reader.readLine());
        array = new int[N+1];
        dp = new int[N+1];

        for (int i=1; i<N+1; i++) {
            array[i] = stoi(reader.readLine());
        }

        dp[1] = 1;
        int max = 0;
        for (int i=2; i<N+1; i++) {
            dp[i] = 1;

            for (int j=1; j<i; j++) {
                if (array[i] > array[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);

        reader.close();
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
