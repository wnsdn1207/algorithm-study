package own.junn.y2022.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 4963 - 섬의 개수
 */
public class Problem_4963 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int w;
    static int h;

    static int[] dx = {0, 0, -1, 1, 1, -1, 1, -1};
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};

    static boolean[][] land;
    static boolean[][] clonedLand;

    static int landCount;

    public static void main(String[] args) throws Exception {

        String input;
        while (!(input = reader.readLine()).equalsIgnoreCase("0 0")) {
            String[] inputArr = input.split(" ");
            w = Integer.parseInt(inputArr[0]);
            h = Integer.parseInt(inputArr[1]);

            land = new boolean[h][w];
            for (int i=0; i<h; i++) {
                inputArr = reader.readLine().split(" ");

                for (int j=0; j<w; j++) {
                    land[i][j] = inputArr[j].equalsIgnoreCase("1");
                }
            }

            landCount = 0;
            clonedLand = land.clone();

            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (clonedLand[i][j]) {
                        bfs(i, j);
                        landCount++;
                    }
                }
            }

            System.out.println(landCount);
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        clonedLand[x][y] = false;
        queue.add(new Point(x, y));

        while (queue.size() > 0) {
            Point point = queue.poll();

            int ax, ay;
            for (int i=0; i<8; i++) {
                ax = point.x + dx[i];
                ay = point.y + dy[i];

                if (isValidRange(ax, ay) && clonedLand[ax][ay]) {
                    clonedLand[ax][ay] = false;
                    queue.add(new Point(ax, ay));
                }
            }
        }
    }

    static boolean isValidRange(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }
}
