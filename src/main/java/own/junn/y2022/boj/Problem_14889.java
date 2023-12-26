package own.junn.y2022.boj;

import java.io.*;
import java.util.*;

public class Problem_14889 {
    static int N;
    static int MIN = Integer.MAX_VALUE;
    static boolean[] isUsed;
    static int[][] stats;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        stats = new int[N][N];
        isUsed = new boolean[N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            for (int j=0; j<N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(MIN);
        reader.close();
    }

    static void dfs(int idx, int count) {
        if (count == N/2) {
            getDiff();
            return;
        }

        for (int i=idx; i<N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                dfs(i+1, count+1);
                isUsed[i] = false;
            }
        }
    }

    static void getDiff() {
        int startTeam = 0, linkTeam = 0;

        for (int i=0; i<N-1; i++) {
            for (int j=i+1; j<N; j++) {
                if (isUsed[i] && isUsed[j]) {
                    startTeam += stats[i][j] + stats[j][i];
                } else if (!isUsed[i] && !isUsed[j]) {
                    linkTeam += stats[i][j] + stats[j][i];
                }
            }
        }

        int diff = Math.abs(startTeam-linkTeam);

        if (diff == 0) {
            System.out.println(0);
            System.exit(0);
        }

        MIN = Math.min(MIN, diff);
    }
}
