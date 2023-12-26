package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 5622 - 다이얼
 */
public class p5622 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static char[][] map = {
            {},
            {},
            {'A', 'B', 'C'},
            {'D', 'E', 'F'},
            {'G', 'H', 'I'},
            {'J', 'K', 'L'},
            {'M', 'N', 'O'},
            {'P', 'Q', 'R', 'S'},
            {'T', 'U', 'V'},
            {'W', 'X', 'Y', 'Z'}
    };

    public static void main(String[] args) throws Exception {
        char[] chars = reader.readLine().toCharArray();

        int elapsed = 0;
        for (char c : chars) {
            elapsed += find(c);
        }

        System.out.println(elapsed);

        reader.close();
    }

    static int find(char c) {
        for (int i=2; i<map.length; i++) {
            for (int j=0; j<map[i].length; j++) {
                if (c == map[i][j]) {
                    return i+1;
                }
            }
        }

        return 0;
    }
}
