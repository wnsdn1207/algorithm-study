package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 16395 - 파스칼의 삼각형
 */
public class p16395 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int K;

    static int[][] map;
    public static void main(String[] args) throws Exception {
        String[] input = reader.readLine().split(" ");

        map = new int[31][31];
        init();

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        for (int i=2; i<31; i++) {
            map[i][0] = 1;
            map[i][i] = 1;

            fill(i);
        }

        System.out.println(map[N-1][K-1]);

        reader.close();
    }

    static void fill(int idx) {
        for (int i=1; i<idx; i++) {
            map[idx][i] = map[idx-1][i-1] + map[idx-1][i];
        }
    }

    static void init() {
        map[0][0] = 1;
        map[1][0] = 1;
        map[1][1] = 1;
    }
}
