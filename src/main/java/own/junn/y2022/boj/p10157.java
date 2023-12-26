package own.junn.y2022.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10157 - 자리배정
 */
public class p10157 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int C;
    static int R;

    static int K;

    static Point answer;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[R][C];

        K = Integer.parseInt(reader.readLine());

        if (C*R < K) {
            System.out.println(0);
            return;
        }

        int x=0, y=1, stan=1;
        int idx = 0;
        while (true) {
            for (int i=0; i<R; i++) {
                x += stan;
                visited[x-1][y-1] = true;
                idx++;
                if (idx == K) {
                    System.out.println(y + " " + x);
                    return;
                }
            }

            C--;

            for (int i=0; i<C; i++) {
                y += stan;
                visited[x-1][y-1] = true;
                idx++;
                if (idx == K) {
                    System.out.println(y + " " + x);
                    return;
                }
            }

            R--;

            stan *= -1;
        }
    }
}
