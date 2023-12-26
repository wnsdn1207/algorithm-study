package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 5212 - 지구온난화
 */
public class p5212 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int R;
    static int C;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static char[][] chars;

    static boolean[][] changes;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[R][C];
        changes = new boolean[R][C];

        for (int i=0; i<R; i++) {
            chars[i] = reader.readLine().toCharArray();
        }

        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (chars[i][j] == 'X' && !isStuckByOcean(i, j)) {
                    changes[i][j] = true;

                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                }
            }
        }

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (chars[i][j] == 'X' && !changes[i][j]) {
                    chars[i][j] = '.';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=minX; i<=maxX; i++) {
            for (int j=minY; j<=maxY; j++) {
                sb.append(chars[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

        reader.close();
    }

    static boolean isStuckByOcean(int x, int y) {
        int count = 0;

        for (int i=0; i<4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            if ((isValidRange(ax, ay) && chars[ax][ay] == '.') || isOcean(ax, ay)) {
                count++;
            }
        }

        return count >= 3;
    }

    static boolean isValidRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    static boolean isOcean(int x, int y) {
        return x < 0 || x >= R || y < 0 || y >= C;
    }
}
