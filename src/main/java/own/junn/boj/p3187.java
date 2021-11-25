package own.junn.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 3187 - 양치기 꿍
 */
public class p3187 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int R;
    static int C;

    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int sheepCount;
    static int wolfCount;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i=0; i<R; i++) {
            map[i] = reader.readLine().toCharArray();
        }

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (isSheepOrWolf(i, j)) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheepCount + " " + wolfCount);

        reader.close();
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        int sheep = 0, wolf = 0;
        if (map[x][y] == 118) {
            wolf += 1;
        } else {
            sheep += 1;
        }

        while (!queue.isEmpty()) {
            Point pos = queue.poll();

            int ax, ay;
            for (int i=0; i<4; i++) {
                ax = pos.x + dx[i];
                ay = pos.y + dy[i];

                if (isValidRange(ax, ay) && !isWall(ax, ay) && !visited[ax][ay]) {
                    visited[ax][ay] = true;
                    queue.add(new Point(ax, ay));
                    char c = map[ax][ay];
                    if (c == 118) {
                        wolf += 1;
                    } else if (c == 107) {
                        sheep += 1;
                    }
                    map[ax][ay] = '.';
                }
            }
        }

        if (sheep > wolf) {
            sheepCount += sheep;
        } else {
            wolfCount += wolf;
        }
    }

    static boolean isSheepOrWolf(int x, int y) {
        return map[x][y] == 118 || map[x][y] == 107;
    }

    static boolean isWall(int x, int y) {
        return map[x][y] == 35;
    }

    static boolean isValidRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
