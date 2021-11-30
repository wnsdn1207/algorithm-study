package own.junn.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 8911 - 거북이
 */
public class p8911 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int T;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            int direction = 0;

            char[] commands = reader.readLine().toCharArray();
            Point start = new Point(0, 0);

            int maxX = 0, maxY = 0;
            int minX = 0, minY = 0;

            for (char c : commands) {
                if (c == 'F') {
                    start.x += dx[direction];
                    start.y += dy[direction];

                    maxX = Math.max(maxX, start.x);
                    maxY = Math.max(maxY, start.y);

                    minX = Math.min(minX, start.x);
                    minY = Math.min(minY, start.y);
                } else if (c == 'B') {
                    start.x -= dx[direction];
                    start.y -= dy[direction];

                    maxX = Math.max(maxX, start.x);
                    maxY = Math.max(maxY, start.y);

                    minX = Math.min(minX, start.x);
                    minY = Math.min(minY, start.y);
                } else if (c == 'L') {
                    direction -= 1;
                    if (direction < 0) {
                        direction = 3;
                    }
                } else {
                    direction += 1;
                    if (direction > 3) {
                        direction = 0;
                    }
                }
            }

            System.out.println((maxX-minX) * (maxY-minY));
        }

        reader.close();
    }
}
