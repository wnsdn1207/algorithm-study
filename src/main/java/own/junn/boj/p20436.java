package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 20436 - ZOAC
 */
public class p20436 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static char[][] PAD = {
            {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
    };

    public static void main(String[] args) throws Exception {
        String[] inputs = reader.readLine().split(" ");

        char leftChar = inputs[0].charAt(0);
        char rightChar = inputs[1].charAt(0);

        int lhx = 0, lhy = 0, rhx = 0, rhy = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<PAD[i].length; j++) {
                if (PAD[i][j] == leftChar) {
                    lhx = i;
                    lhy = j;
                } else if (PAD[i][j] == rightChar) {
                    rhx = i;
                    rhy = j;
                }
            }
        }

        char[] target = reader.readLine().toCharArray();

        int movingElapsed = 0;
        for (char c : target) {
            movingElapsed++;
            for (int i=0; i<3; i++) {
                for (int j=0; j<PAD[i].length; j++) {
                    if (PAD[i][j] == c) {
                        if (isLeft(i, j)) {
                            movingElapsed += Math.abs(lhx - i) + Math.abs(lhy - j);
                            lhx = i;
                            lhy = j;
                        } else {
                            movingElapsed += Math.abs(rhx - i) + Math.abs(rhy - j);
                            rhx = i;
                            rhy = j;
                        }
                    }
                }
            }
        }
        System.out.println(movingElapsed);

        reader.close();
    }

    static boolean isLeft(int x, int y) {
        return (x < 2 && y < 5) || (x == 2 && y < 4);
    }
}
