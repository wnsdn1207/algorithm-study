package own.junn.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 15722 - 빙글빙글스네일
 */
public class Problem_15722 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(reader.readLine());

        Point pos = new Point(0, 0);

        int an = 1, count = 0;
        for (int i=1; i<n; i++) {
            for (int j=0; j<2*i; j++) {
                if (j < i) {
                    pos.y = pos.y+an;
                } else {
                    pos.x = pos.x+an;
                }
                if (++count == n) {
                    System.out.printf("%d %d\n", pos.x, pos.y);
                }
            }
            an *= -1;
        }
    }
}
