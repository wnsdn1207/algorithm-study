package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1010 - 다리놓기
 */
public class p1010 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;

    static int N;
    static int M;

    static double[] dp = new double[31];
    static int answer;
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        dp[0] = 1;
        dp[1] = 1;

        while (T-- > 0) {
            String[] s = reader.readLine().split(" ");

            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);

            for (int i=2; i<=M; i++) {
                dp[i] = dp[i-1] * i;
            }

//            System.out.println(Arrays.toString(dp));
            if (M == N) {
                System.out.println(1);
            } else {
                System.out.println((int) Math.round(dp[M] / (dp[M-N] * dp[N])));
            }
        }

        reader.close();
    }

    static void combination(boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            answer++;
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
