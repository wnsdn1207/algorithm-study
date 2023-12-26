package own.junn.y2022.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1531 - 투명
 */
public class p1531 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static int[][] map = new int[101][101];
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            Point fromPoint = new Point(STOI(st.nextToken()), STOI(st.nextToken()));
            Point toPoint = new Point(STOI(st.nextToken()), STOI(st.nextToken()));

            for (int j=fromPoint.x; j<=toPoint.x; j++) {
                for (int k=fromPoint.y; k<=toPoint.y; k++) {
                    map[j][k] += 1;
                }
            }
        }

        int count = 0;
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[i].length; j++) {
                if (map[i][j] > M) {
                    count++;
                }
            }
        }

        System.out.println(count);
        reader.close();
    }

    static int STOI(String s) {
        return Integer.parseInt(s);
    }
}
