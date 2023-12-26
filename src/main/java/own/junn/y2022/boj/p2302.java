package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2302 - 극장좌석
 */
public class p2302 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static int[] seats = new int[41];
    static int[] dp;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());

        dp = new int[N+1];
        fillDP();

        for (int i=0; i<M; i++) {
            seats[Integer.parseInt(reader.readLine())] = -1;
        }

        int sum = 1;
        int count = 0;
        for (int i=1; i<=N; i++) {
            if (seats[i] == -1) {
                sum *= dp[count];
                count = 0;
                continue;
            }
            count++;
        }

        if (count > 0) {
            sum *= dp[count];
        }

        System.out.println(sum);

        reader.close();
    }

    static void fillDP() {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
    }
}
