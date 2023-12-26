package own.junn.y2022.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2178 - 미로 탐색
 */
public class Problem_2178 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static int[][] maze;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        maze = new int[N][M];

        for (int i=0; i<N; i++) {
            char[] row = reader.readLine().toCharArray();
            for (int j=0; j<M; j++) {
                maze[i][j] = row[j] == '0' ? 0 : 1;
            }
        }

        moving();
        System.out.println(maze[N-1][M-1]);
    }

    static void moving() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        while (queue.size() > 0) {
            Point pos = queue.poll();

            int ax, ay;
            for (int i=0; i<4; i++) {
                ax = pos.x + dx[i];
                ay = pos.y + dy[i];

                if (isValidRange(ax, ay) && maze[ax][ay] == 1) {
                    maze[ax][ay] = maze[pos.x][pos.y] + 1;
                    queue.add(new Point(ax, ay));
                }
            }
        }
    }

    static boolean isValidRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
