package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2096 - 내려가기
 */
public class p2096 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        map = new int[N][3];
        dp = new int[N][3];

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");

            for (int j=0; j<3; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
            }
        }

        dp[0] = map[0].clone();

        // Max 값 찾기
        for (int i=1; i<N; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + map[i][0];
            dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + map[i][1];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + map[i][2];
        }

        int max = 0;
        for (int i=0; i<3; i++) {
            max = Math.max(max, dp[N-1][i]);
        }

        dp = new int[N][3];
        dp[0] = map[0].clone();

        // Min 값 찾기
        for (int i=1; i<N; i++) {
            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][0];
            dp[i][1] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2])) + map[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][2];
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i<3; i++) {
            min = Math.min(min, dp[N-1][i]);
        }

        System.out.println(max + " " + min);

        reader.close();
    }
}
