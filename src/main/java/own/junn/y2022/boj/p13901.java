package own.junn.y2022.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 13901 - 로봇
 *
 * R, C (3 ≤ R, C ≤ 1,000)
 * k (0 ≤ k ≤ 1,000)
 */
public class p13901 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[][] map;
    static int R;
    static int C;
    static int k;

    static Point startPoint;
    static Point currPoint;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] directions = new int[4];

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        k = Integer.parseInt(reader.readLine());

        for (int i=0; i<k; i++) {
            st = new StringTokenizer(reader.readLine(), " ");

            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
        }

        st = new StringTokenizer(reader.readLine(), " ");
        startPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(reader.readLine(), " ");
        int visitCount = 0;

        for (int i=0; i<4; i++) {
            directions[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        currPoint = new Point(startPoint.x, startPoint.y);
        while (true) {
            for (int i = 0; i < 4; i++) {
                while (true) {
                    int ax = currPoint.x + dx[directions[i]];
                    int ay = currPoint.y + dy[directions[i]];

                    if (!isValidRange(ax, ay) || hasObstacle(ax, ay) || isVisited(ax, ay)) {
                        break;
                    }

                    map[ax][ay] = ++visitCount;

                    currPoint.x = ax;
                    currPoint.y = ay;

                    if (isStuck(ax, ay)) {
//                        System.out.println(Arrays.deepToString(map));
                        System.out.println(currPoint.x + " " + currPoint.y);
                        reader.close();
                        System.exit(0);
                    }
                }
            }
        }
    }

    static boolean isValidRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    static boolean hasObstacle(int x, int y) {
        return map[x][y] == -1;
    }

    static boolean isVisited(int x, int y) {
        return (x == startPoint.x && y == startPoint.y) || map[x][y] > 0;
    }

    static boolean isStuck(int x, int y) {
        for (int i=0; i<4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            if (isValidRange(ax, ay) && !hasObstacle(ax, ay) && !isVisited(ax, ay)) {
                return false;
            }
        }

        return true;
    }
}
