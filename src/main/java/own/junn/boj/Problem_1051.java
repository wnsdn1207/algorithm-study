package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1051 - 숫자 정사각형
 */
public class Problem_1051 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static int[][] square;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        square = new int[N][M];

        for (int i=0; i<N; i++) {
            String[] tmp = reader.readLine().split("");
            for (int j=0; j<tmp.length; j++) {
                square[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int result = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int n=1; n<Math.min(N, M); n++) {
                    if (i+n < N && j+n < M) {
                        if (square[i][j] == square[i+n][j] &&
                                square[i+n][j] == square[i+n][j+n] &&
                                square[i+n][j+n] == square[i][j+n]) {
                            result = Math.max(result, (int) Math.pow(n+1, 2));
                        }
                    }

                }
            }
        }

        System.out.println(result);
        reader.close();
    }
}
