package own.junn.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2636 - 치즈
 */
public class p2636 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static int[][] map;
    static int[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static Queue<Point> nearbyCheese = new LinkedList<>();

    static int elapsed;
    static int finalSize;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j=0; j<M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if (map[i][j] == 1) {
                    visited[i][j] = -1;
                }
            }
        }

        defineAirState();
        checkNearbyCheese();

        while (!checkWhetherStateOfEmpty()) {
            meltCheese();
            finalSize = nearbyCheese.size();

            combineAir();
            elapsed++;
        }

        System.out.println(elapsed+"\n"+finalSize);

        reader.close();
    }

    static void defineAirState() {
        Queue<Point> queue = new LinkedList<>();
        visited[0][0] = 1;
        queue.add(new Point(0, 0));

        while (queue.size() > 0) {
            Point node = queue.poll();

            for (int i=0; i<4; i++) {
                int ax = node.x + dx[i];
                int ay = node.y + dy[i];

                if (validRange(ax, ay) && map[ax][ay] == 0 && visited[ax][ay] == 0) {
                    visited[ax][ay] = 1;
                    queue.add(new Point(ax, ay));
                }
            }
        }
    }

    static void checkNearbyCheese() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (visited[i][j] == 1) {
                    for (int k=0; k<4; k++) {
                        int ax = i+dx[k];
                        int ay = j+dy[k];

                        if (validRange(ax, ay) && map[ax][ay] == 1) {
                            nearbyCheese.add(new Point(i, j));
                            break;
                        }
                    }
                }
            }
        }
    }

    static void meltCheese() {
        Queue<Point> queue = nearbyCheese;
        nearbyCheese = new LinkedList<>();

        while (queue.size() > 0) {
            Point node = queue.poll();

            for (int i=0; i<4; i++) {
                int ax = node.x + dx[i];
                int ay = node.y + dy[i];

                if (validRange(ax, ay) && map[ax][ay] == 1) {
                    map[ax][ay] = 0;
                    nearbyCheese.add(new Point(ax, ay));
                }
            }
        }
    }

    static void combineAir() {
        Queue<Point> queue = new LinkedList<>(nearbyCheese);

        while (queue.size() > 0) {
            Point node = queue.poll();

            for (int i=0; i<4; i++) {
                int ax = node.x + dx[i];
                int ay = node.y + dy[i];

                if (validRange(ax, ay) && visited[ax][ay] == 0) {
                    visited[ax][ay] = 1;

                    Point newest = new Point(ax, ay);
                    queue.add(newest);
                    nearbyCheese.add(newest);
                }
            }
        }
    }

    static boolean checkWhetherStateOfEmpty() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean validRange(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}
