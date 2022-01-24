package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 17086 - 아기상어
 *
 * N과 M(2 ≤ N, M ≤ 50)
 * 0은 빈 칸, 1은 아기 상어가 있는 칸
 *
 * 예제 입력 1
 * 5 4
 * 0 0 1 0
 * 0 0 0 0
 * 1 0 0 0
 * 0 0 0 0
 * 0 0 0 1
 * 예제 출력 1
 * 2
 *
 * 예제 입력 2
 * 7 4
 * 0 0 0 1
 * 0 1 0 0
 * 0 0 0 0
 * 0 0 0 1
 * 0 0 0 0
 * 0 1 0 0
 * 0 0 0 1
 * 예제 출력 2
 * 2
 */
public class p17086 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[][] distances;
    static boolean[][] check;

    // 8방향 이동
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distances = new int[N][M];
        check = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j=0; j<M; j++) {
                distances[i][j] = Integer.MAX_VALUE;
                if (st.nextToken().equalsIgnoreCase("1")) {
                    check[i][j] = true;
                    distances[i][j] = -1;
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (check[i][j]) {
                    bfs(i, j);
                }
            }
        }

//        Arrays.stream(distances).forEach(e -> System.out.println(Arrays.toString(e)));
        int result = Integer.MIN_VALUE;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                result = Math.max(result, distances[i][j]);
            }
        }

        System.out.println(result);

        reader.close();
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));

        while (!queue.isEmpty()) {
            Point node = queue.poll();

            for (int i=0; i<8; i++) {
                int ax = node.x + dx[i];
                int ay = node.y + dy[i];

                if (validRange(ax, ay)) {
                    if (distances[ax][ay] > node.dis+1) {
                        distances[ax][ay] = node.dis+1;
                        queue.add(new Point(ax, ay, node.dis+1));
                    }
                }
            }
        }
    }

    static boolean validRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static class Point {
        int x;
        int y;
        int dis;

        public Point(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
