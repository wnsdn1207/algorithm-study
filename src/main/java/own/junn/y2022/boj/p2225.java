package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2225 - 합분해
 *
 * N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)
 * 덧셈의 순서가 바뀐 경우는 다른 경우로 센다 (1+2와 2+1은 서로 다른 경우).
 * 또한 한 개의 수를 여러 번 쓸 수도 있다.
 *
 * 첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력
 *
 * 예제 입력 1
 * 20 2
 * 예제 출력 1
 * 21
 *
 * 예제 입력 2
 * 6 4
 * 예제 출력 2
 * 84
 */
public class p2225 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, K;
    static int[][] dp = new int[201][201];
    static final int DIVISION = 1000000000;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int j=0; j<201; j++) {
            dp[0][j] = 1;
        }

        for (int i=1; i<201; i++) {
            for (int j=1; j<201; j++) {
                for (int k=i; k>=0; k--) {
                    if (i == N && j == K) {
                        System.out.printf("N : %d, K : %d, x : %d, y : %d\n", N, K, k, j);
                    }
                    dp[i][j] += dp[k][j-1];
                    dp[i][j] %= DIVISION;
                }
            }
        }

        System.out.println(dp[N][K] % DIVISION);

        reader.close();
    }
}
