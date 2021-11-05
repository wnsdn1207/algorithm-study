package own.junn.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 9663 - N Queen
 */
public class Problem_9663 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

    static int answer;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        for (int n=0; n<N*N; n++) {
            visited = new boolean[N][N];

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        arrange(i, j);
                        count++;
                    }
                }
            }

            if (count == 8) {
                answer++;
            }
        }
        System.out.println(Arrays.deepToString(visited));

        reader.close();
    }

    static void arrange(int x, int y) {
        visited[x][y] = true;

        Point pos = new Point(x, y);

        int ax, ay;
        for (int i=0; i<8; i++) {
            int tx = pos.x, ty = pos.y;
            do {
                ax = tx + dx[i];
                ay = ty + dy[i];

                if (isValidRange(ax, ay) && !visited[ax][ay]) {
                    visited[ax][ay] = true;
                    tx = ax;
                    ty = ay;
                }
            } while (!isEndpoint(ax, ay));
        }
    }

    static boolean isValidRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static boolean isEndpoint(int x, int y) {
        return x == -1 || x == N || y == -1 || y == N;
    }
}
