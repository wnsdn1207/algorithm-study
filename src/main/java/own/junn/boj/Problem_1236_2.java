package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1236 - 성지키기
 */
public class Problem_1236_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());   // 행
        int M = Integer.parseInt(st.nextToken());   // 열

        String[][] castle = new String[N][M];

        for (int i=0; i<N; i++) {
            castle[i] = reader.readLine().split("");
        }

        boolean[] X = new boolean[N];
        for (int i=0; i<N; i++) {
            boolean hasSecurity = false;
            for (int j=0; j<M; j++) {
                if (castle[i][j].equalsIgnoreCase("X")) {
                    hasSecurity = true;
                    break;
                }
            }

            if (!hasSecurity) {
                X[i] = true;
            }
        }

        boolean[] Y = new boolean[M];
        for (int i=0; i<M; i++) {
            boolean hasSecurity = false;
            for (int j=0; j<N; j++) {
                if (castle[j][i].equalsIgnoreCase("X")) {
                    hasSecurity = true;
                    break;
                }
            }

            if (!hasSecurity) {
                Y[i] = true;
            }
        }

        int xCount=0, yCount=0;

        for (boolean x : X) {
            if (x) {
                xCount++;
            }
        }
        for (boolean b : Y) {
            if (b) {
                yCount++;
            }
        }

        System.out.println(Math.max(xCount, yCount));
    }
}
