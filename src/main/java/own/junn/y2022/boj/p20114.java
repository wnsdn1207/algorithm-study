package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 20114 - 미아노트
 */
public class p20114 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static int H;
    static int W;

    static char[][] chars;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        chars = new char[H][N*W];

        for (int i=0; i<H; i++) {
            chars[i] = reader.readLine().toCharArray();
        }

        int offset = 0;
        int limit = W;
        do {
            char c = '?';

            for (int i = 0; i < H; i++) {
                for (int j = offset * limit; j < ((offset + 1) * limit); j++) {
                    System.out.printf("i : %d, j : %d, offset : %d\n", i, j, offset);
                    if (chars[i][j] != '?') {
                        c = chars[i][j];
                        break;
                    }
                }
                if (c != '?') {
                    break;
                }
            }

            sb.append(c);

        } while (++offset * limit != N * W);

        System.out.println(sb);

        reader.close();
    }
}
