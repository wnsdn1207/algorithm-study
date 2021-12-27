package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 17485 - 진우의 달 여행 (Large)
 *
 * N, M (2 ≤ N, M ≤ 1000)
 * 각 행렬의 원소값은 100 이하의 자연수
 *
 * 예제 입력 1
 * 6 4
 * 5 8 5 1
 * 3 5 8 4
 * 9 77 65 5
 * 2 1 5 2
 * 5 98 1 5
 * 4 95 67 58
 *
 * 예제 출력 1
 * 29
 */
public class p17485 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    // 위치별 연료 소모량을 저장하는 배열
    static int[][] map;
    // 연료 소모량의 합을 각 방향별로 저장하는 3차원 배열
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        // 왼쪽아래, 아래, 오른쪽아래 총 3가지 방향이 있기 때문에 3으로 선언
        dp = new int[N][M][3];

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");

            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 배열의 0번쨰 배열의 값들을 초기화
        for (int i=0; i<M; i++) {
            dp[0][i][0] = map[0][i];
            dp[0][i][1] = map[0][i];
            dp[0][i][2] = map[0][i];
        }

        for (int i=0; i<N; i++) {
            // j==0인 경우, 왼쪽 대각선 방향으로부터 올 수 없음
            dp[i][0][0] = Integer.MAX_VALUE;
            // j==M-1인 경우, 오른쪽 대각선 방향으로부터 올 수 없음
            dp[i][M-1][2] = Integer.MAX_VALUE;
        }

        for (int i=1; i<N; i++) {
            for (int j=0; j<M; j++) {
                // 해당하는 자리의 값
                int add = map[i][j];

                if (j==0) {
                    // 왼쪽 끝인 경우, 아래 방향 또는 오른쪽 아래 방향으로 왔을 때만 가능
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + add;
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + add;
                } else if (j==M-1) {
                    // 오른쪽 끝인 경우, 아래 방향 또는 왼쪽 아래 방향으로 왔을 때만 가능
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + add;
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + add;
                } else {
                    // 그 외 경우, 왼쪽 아래, 오른쪽 아래, 아래 방향으로 왔을 때 모두 가능
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + add;
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + add;
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + add;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        // 각 열마다 3개의 방향에서 최소값을 찾음
        for (int j=0; j<M; j++) {
            for (int n=0; n<3; n++) {
                result = Math.min(result, dp[N-1][j][n]);
            }
        }

        System.out.println(result);

        reader.close();
    }
}
