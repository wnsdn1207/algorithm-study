package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1890 - 점프
 *
 * 반드시 오른쪽이나 아래쪽으로만 이동해야 한다
 *
 * N (4 ≤ N ≤ 100)
 * 칸에 적혀있는 수는 0보다 크거나 같고, 9보다 작거나 같은 정수
 * 가장 오른쪽 아래 칸에는 항상 0
 *
 * 예제 입력 1
 * 4
 * 2 3 3 1
 * 1 2 1 3
 * 1 2 3 1
 * 3 1 1 0
 * 예제 출력 1
 * 3
 */
public class p1890 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        map = new int[N][N];
        dp = new long[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        // 점화식
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                // 맨 마지막 좌표는 계산하지 않는다.
                if (i == N-1 && j == N-1) break;

                // dp값이 세팅되지 않은 지점은 도달할 수 없는 지점을 뜻한다.
                if (dp[i][j] != 0) {
                    // 각 지점별로 오른쪽 또는 아래쪽으로 이동할 수 있다.
                    // 이 때, 이동 거리는 해당 지점에 적힌 숫자를 사용해야 한다.
                    int stan = map[i][j];

                    // 아래쪽 이동
                    // 범위에 벗어난 값이 아니라면, 갈 수 있는 방법의 수를 추가한다.
                    if (validRange(i+stan)) {
                        dp[i+stan][j] += dp[i][j];
                    }
                    // 오른쪽 이동
                    // 범위에 벗어난 값이 아니라면, 갈 수 있는 방법의 수를 추가한다.
                    if (validRange(j+stan)) {
                        dp[i][j+stan] += dp[i][j];
                    }
                }
            }
        }

//        for (int[] arr : dp) {
//            System.out.println(Arrays.toString(arr));
//        }
        // 최종적으로, dp[N-1][N-1] 지점에는 갈 수 있는 모든 경우의 수가 출력된다.
        System.out.println(dp[N-1][N-1]);

        reader.close();
    }

    static boolean validRange(int x) {
        return x >= 0 && x < N;
    }
}
