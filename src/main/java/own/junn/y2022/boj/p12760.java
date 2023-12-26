package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 12760 - 최후의 승자는 누구?
 */
public class p12760 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static int[][] map;
    static int[] winnerMap;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M];
        winnerMap = new int[N+1];

        for (int i=1; i<N+1; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(map[i]);
        }

        int maxWin = 0;
        for (int i=0; i<M; i++) {
            int max = Integer.MIN_VALUE;
            for (int j=N; j>=1; j--) {
                max = Math.max(max, map[j][i]);
            }
            for (int j=1; j<N+1; j++) {
                if (map[j][i]==max) {
                    winnerMap[j] += 1;
                    maxWin = Math.max(maxWin, winnerMap[j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<N+1; i++) {
            if (maxWin == winnerMap[i]) {
                sb.append(i).append(" ");
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);

        sb.setLength(0);
        reader.close();
    }
}
