package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 16926 - 배열 돌리기 1
 */
public class p16926 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int R;

    static int[][] map;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println(Arrays.deepToString(map));
        int length = Math.min(N, M) / 2;
        for (int r=0; r<R; r++) {
            for (int i=0; i<length; i++) {
                rotate(i, i, N-i, M-i);
            }
        }
//        rotate(0, 0, map.length, map[0].length);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        reader.close();
    }

    static void rotate(int startX, int startY, int endX, int endY) {
        int tmp;
        int prevVal = map[startX][startY];
        int ax = startX, ay = startY;
        for (int i=0; i<4; i++) {
            while (true) {
                ax += dx[i];
                ay += dy[i];

                if (!isValidRange(ax, ay, startX, startY, endX, endY)) {
                    ax -= dx[i];
                    ay -= dy[i];

                    break;
                }

                tmp = map[ax][ay];
                map[ax][ay] = prevVal;
                prevVal = tmp;
            }
        }
    }

    static boolean isValidRange(int x, int y, int minX, int minY, int maxX, int maxY) {
        return x >= minX && x < maxX && y >= minY && y < maxY;
    }
}
