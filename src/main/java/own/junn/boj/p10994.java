package own.junn.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 10994 - 별 찍기 - 19
 */
public class p10994 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static boolean[][] stars;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        if (N == 1) {
            System.out.println("*");
            return;
        }

        int x = (N-1)*4 + 1;
        stars = new boolean[x][x];
        int standard = x/2;
        stars[standard][standard] = true;

        for (int n=2; n<N+1; n++) {
            int stan = 2*(n-1);
            Point point1 = new Point(standard-stan, standard-stan);
            Point point2 = new Point(standard-stan, standard+stan);
            Point point3 = new Point(standard+stan, standard-stan);
            Point point4 = new Point(standard+stan, standard+stan);

            for (int i=point1.y; i<point2.y+1; i++) {
                stars[point1.x][i] = true;
            }
            for (int i=point2.x; i<point3.x+1; i++) {
                stars[i][point2.y] = true;
            }
            for (int i=point3.y; i<point4.y+1; i++) {
                stars[point3.x][i] = true;
            }
            for (int i=point1.x; i<point4.x+1; i++) {
                stars[i][point1.y] = true;
            }
        }

        for (int i=0; i<stars.length; i++) {
            for (int j=0; j<stars[i].length; j++) {
                if (stars[i][j]) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
