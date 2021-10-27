package own.junn.boj;

import java.util.*;
import java.io.*;

/**
 * 2422 - 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
 */
public class Problem_2422 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] excepted;

    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        excepted = new boolean[N+1][N+1];

        for (int i=0; i<M; i++) {
            String[] tmp = reader.readLine().split(" ");

            int n = Integer.parseInt(tmp[0]);
            int m = Integer.parseInt(tmp[1]);

            excepted[n][m] = true;
            excepted[m][n] = true;
        }

        int caseCount = 0;

        for (int i=1; i<N+1; i++) {
            for (int j=i+1; j<N+1; j++) {
                for (int k=j+1; k<N+1; k++) {
                    if (excepted[i][j] || excepted[j][k] || excepted[k][i]) {
                        continue;
                    }

                    caseCount++;
                }
            }
        }

        System.out.println(caseCount);
        reader.close();
    }
}
