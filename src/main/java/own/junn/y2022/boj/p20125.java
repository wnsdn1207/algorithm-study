package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 20125 - 쿠키의 신체 측정
 */
public class p20125 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static char[][] rectangle;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int hx, hy, wx, wy;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        rectangle = new char[N][N];

        for (int i=0; i<N; i++) {
            rectangle[i] = reader.readLine().toCharArray();
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (heart(i, j)) {
                    hx = i;
                    hy = j;
                }
            }
        }

        sb.append(hx+1).append(" ")
                .append(hy+1).append("\n")
                .append(leftArmLength(hx, hy)).append(" ")
                .append(rightArmLength(hx, hy)).append(" ")
                .append(waistLength(hx, hy)).append(" ")
                .append(leftLegLength(wx, wy)).append(" ")
                .append(rightLegLength(wx, wy));

        System.out.println(sb);

        reader.close();
    }

    static boolean heart(int x, int y) {
        for (int i=0; i<4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            if (!validRange(ax, ay) || rectangle[ax][ay] == '_') {
                return false;
            }
        }

        return true;
    }

    static int leftArmLength(int x, int y) {
        int ax = x + dx[2];
        int ay = y + dy[2];

        int length = 0;
        while (running(ax, ay)) {
            length++;

            ax += dx[2];
            ay += dy[2];
        }

        return length;
    }

    static int rightArmLength(int x, int y) {
        int ax = x + dx[3];
        int ay = y + dy[3];

        int length = 0;
        while (running(ax, ay)) {
            length++;

            ax += dx[3];
            ay += dy[3];
        }

        return length;
    }

    static int waistLength(int x, int y) {
        int ax = x + dx[1];
        int ay = y + dy[1];

        int length = 0;
        while (running(ax, ay)) {
            length++;

            ax += dx[1];
            ay += dy[1];
        }

        wx = ax;
        wy = ay;

        return length;
    }

    static int leftLegLength(int x, int y) {
        int ax = x + dx[2];
        int ay = y + dy[2];

        int length = 0;
        while (running(ax, ay)) {
            length++;

            ax += dx[1];
            ay += dy[1];
        }

        return length;
    }

    static int rightLegLength(int x, int y) {
        int ax = x + dx[3];
        int ay = y + dy[3];

        int length = 0;
        while (running(ax, ay)) {
            length++;

            ax += dx[1];
            ay += dy[1];
        }

        return length;
    }

    static boolean running(int x, int y) {
        return validRange(x, y) && rectangle[x][y] == '*';
    }

    static boolean validRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
