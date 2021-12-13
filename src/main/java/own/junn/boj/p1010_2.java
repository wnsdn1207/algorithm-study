package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1010 - 다리놓기
 */
public class p1010_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        for (int i=0; i<31; i++) {
            for (int j=0; j<31; j++) {
                dp[i][0] = 1;
                dp[i][i] = 1;
            }
        }

        for (int i=2; i<31; i++) {
            for (int j=1; j<31; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(dp[n][r]);
        }

        reader.close();
    }
}
