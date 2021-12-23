package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
    static int[][] map;
    static int[][] dp;

    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        dp = new int[N][M];

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");

            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0] = map[0].clone();

        for (int j=0; j<M; j++) {
            int[][] tmp = new int[N][M];
            tmp[0] = map[0].clone();

            for (int i=1; i<N; i++) {
                int add = map[i][j];
                int stan;
                if (j == 0) {
                    stan = tmp[i-1][j+1];
                    if (i%2 == 1) {
                        stan = Math.min(stan, tmp[i-1][j]);
                    }
                } else if (j == M-1) {
                    stan = tmp[i-1][j-1];
                    if (i%2 == 1) {
                        stan = Math.min(stan, tmp[i-1][j]);
                    }
                } else {
                    stan = Math.min(tmp[i-1][j-1], tmp[i-1][j+1]);
                    if (i%2 == 1) {
                        stan = Math.min(stan, tmp[i-1][j]);
                    }
                }

                tmp[i][j] = stan + add;
            }
            System.out.println("tmp : "+ Arrays.deepToString(tmp));

            // dp에 최소값 세팅
            for (int x=1; x<N; x++) {
                for (int y=0; y<M; y++) {
                    if (dp[x][y] == 0 || dp[x][y] > 0 && tmp[x][y] > 0) {
                        dp[x][y] = Math.min(dp[x][y], tmp[x][y]);
                    }
                }
            }
        }

        for (int i=1; i<N; i++) {
            for (int j=0; j<M; j++) {
                int add = map[i][j];
                int stan;
                if (j == 0) {
                    stan = dp[i-1][j+1];
                    if (i%2 == 1) {
                        stan = Math.min(stan, dp[i-1][j]);
                    }
                } else if (j == M-1) {
                    stan = dp[i-1][j-1];
                    if (i%2 == 1) {
                        stan = Math.min(stan, dp[i-1][j]);
                    }
                } else {
                    stan = Math.min(dp[i-1][j-1], dp[i-1][j+1]);
                    if (i%2 == 1) {
                        stan = Math.min(stan, dp[i-1][j]);
                    }
                }
                dp[i][j] = stan + add;
            }
        }

//        for (int i=0; i<M; i++) {
//            bfs(0, i);
//        }

        for (int[] arr : map) {
            System.out.println("mp : "+ Arrays.toString(arr));
        }
        System.out.println();
        for (int[] arr : dp) {
            System.out.println("dp : "+ Arrays.toString(arr));
        }
        int result = Integer.MAX_VALUE;
        for (int i : dp[N-1]) {
            result = Math.min(result, i);
        }

        System.out.println(result);

        reader.close();
    }

    static void bfs(int x, int y) {
        Queue<Direction> queue = new LinkedList<>();
        queue.add(new Direction(x, y, -1, map[x][y]));

        while (!queue.isEmpty()) {
            Direction node = queue.poll();
            if (node.x == N-1) {
                break;
            }

            for (int i=0; i<3; i++) {
                if (node.direction == i) {
                    continue;
                }

                int ax = node.x + 1;
                int ay = node.y + dy[i];

//                System.out.printf("ax : %d, ay : %d\n", ax, ay);

                if (validRange(ay)) {
                    if (dp[ax][ay] == 0) {
                        dp[ax][ay] = node.cnt + map[ax][ay];

                    } else {
                        int tmp = node.cnt + map[ax][ay];

                        // 기존에 존재하는 값이 신규 값보다 클 경우
                        if (dp[ax][ay] > tmp) {
                            dp[ax][ay] = tmp;
                        }
                    }
                    queue.add(new Direction(ax, ay, i, node.cnt + map[ax][ay]));
                }
            }
        }
    }

    static boolean validRange(int y) {
        return y >= 0 && y < M;
    }

    static class Direction {
        int x;
        int y;
        int direction;
        int cnt;

        public Direction(int x, int y, int direction, int cnt) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cnt = cnt;
        }
    }
}
