package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1520 - 내리막 길
 *
 * M과 N은 각각 500이하의 자연수
 * 각 지점의 높이는 10000이하의 자연수
 *
 * 예제 입력 1
 * 4 5
 * 50 45 37 32 30
 * 35 50 40 20 25
 * 30 30 25 17 28
 * 27 24 22 15 10
 *
 * 예제 출력 1
 * 3
 */
public class p1520 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 방문한 자리는 0으로 세팅해야 마지막 지점에 도달했을 때, 1로 반환할 수 있다.
                // 따라서, 초기값을 모두 -1로 초기화해준다.
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
//        for (int[] arr : dp) {
//            System.out.println(Arrays.toString(arr));
//        }

        reader.close();
    }

    static int dfs(int x, int y) {
        // 가장 우측 최하단 부분에 도착하면, 1 반환
        if (x == N-1 && y == M-1) return 1;
        // 방문한 지점이 초기 방문 지점이 아니라면, 기존에 방문한 내역을 가지고 옴
        if (dp[x][y] != -1) return dp[x][y];

        // 초기값이 -1이므로, 방문한 지점은 0으로 초기화 해줌
        dp[x][y] = 0;

        int ax, ay;
        for (int i=0; i<4; i++) {
            ax = x + dx[i];
            ay = y + dy[i];

            if (validRange(ax, ay) && map[x][y] > map[ax][ay]) {
                // 끝까지 방문한 곳이 있다면, 1씩 더해짐
                dp[x][y] = dp[x][y] + dfs(ax, ay);
            }
        }

        // 최종적으로 초기 호출할 때의 인자값에 해당하는 dp 배열의 값은 끝지점에 도달한 총 횟수가 됨
        return dp[x][y];
    }

    static boolean validRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
