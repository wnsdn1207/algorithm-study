package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11048 - 이동하기
 */
public class Problem_11048 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};

    static int[][] maze;
    static int answer;

    public static void main(String[] args) throws Exception {
        String[] tmp = reader.readLine().split(" ");

        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);

        maze = new int[N+1][M+1];

        for (int i=1; i<N+1; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            for (int j=1; j<M+1; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        dfs(1, 1, maze[1][1]);
        for (int i=1; i<N+1; i++) {
            for (int j=1; j<M+1; j++) {
                maze[i][j] += Math.max(maze[i-1][j], Math.max(maze[i][j-1], maze[i-1][j-1]));
            }
        }

        System.out.println(maze[N][M]);
    }

    /**
     * 1 2 3 4
     * 0 0 0 5
     * 9 8 7 6
     */
    static void dfs(int x, int y, int sum) {
        if (x == N && y == M) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i=0; i<3; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            if (isValidRange(ax, ay)) {
                sum += maze[ax][ay];
                dfs(ax, ay, sum);
                sum -= maze[ax][ay];
            }
        }
    }

    static boolean isValidRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }
}
