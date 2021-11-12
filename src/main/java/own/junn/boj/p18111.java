package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 18111 - 마인크래프트
 *
 * 1번 작업 (2s): 블록 제거, -1
 * 2번 작업 (1s): 블록 추가, +1
 *
 * 0 <= 땅의 높이 <= 256
 * (1 ≤ M, N ≤ 500, 0 ≤ B ≤ 6.4 × 107)
 */
public class p18111 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int B;

    static int[][] ground;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        ground = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j=0; j<M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(Arrays.deepToString(ground));

        reader.close();
    }
}
