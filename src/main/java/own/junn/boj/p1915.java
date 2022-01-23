package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1915 - 가장 큰 정사각형
 *
 * 예제 입력 1
 * 4 4
 * 0100
 * 0111
 * 1110
 * 0010
 * 예제 출력 1
 * 4
 */
public class p1915 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        int result = 0;
        for (int i=0; i<N; i++) {
            char[] tmp = reader.readLine().toCharArray();

            for (int j=0; j<M; j++) {
                map[i][j] = tmp[j] == '0' ? 0 : 1;

                if (i>0 && j>0 && map[i][j] == 1) {
                    map[i][j] = min(map[i-1][j], map[i][j-1], map[i-1][j-1]) + 1;
                    result = Math.max(result, map[i][j]);
                }
            }
        }

//        for (int i=0; i<N; i++) {
//            for (int j=0; j<M; j++) {
//                if (i>0 && j>0 && map[i][j] == 1) {
//                    map[i][j] = min(map[i-1][j], map[i][j-1], map[i-1][j-1]) + 1;
//                    result = Math.max(result, map[i][j]);
//                }
//            }
//        }

//        for (int[] arr : map) {
//            System.out.println(Arrays.toString(arr));
//        }
        System.out.println(result*result);

        reader.close();
    }

    static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
