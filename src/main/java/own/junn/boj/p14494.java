package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14494 - What is dynamic
 *
 * 1 ≤ n, m ≤ 1,000
 * 경우의 수를 1,000,000,007(=109+7)로 나눈 나머지를 출력
 *
 * 예제 입력 1
 * 3 2
 * 예제 출력 1
 * 5
 *
 * 예제 입력 2
 * 4 5
 * 예제 출력 2
 * 129
 *
 * 예제 입력 3
 * 1000 1000
 * 예제 출력 3
 * 910657857
 */
public class p14494 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static long[][] dp = new long[1001][1001];

    static final long DIVISION = (long) (1e9+7);

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=1; i<1001; i++) {
            dp[i][1] = 1L;
        }
        for (int j=1; j<1001; j++) {
            dp[1][j] = 1L;
        }

        for (int i=2; i<1001; i++) {
            for (int j=2; j<1001; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= DIVISION;
            }
        }

//        for (int i=1; i<11; i++) {
//            for (int j=1; j<11; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[N][M] % DIVISION);

        reader.close();
    }
}
