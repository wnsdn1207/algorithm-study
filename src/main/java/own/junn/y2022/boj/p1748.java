package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1748 - 수 이어쓰기 1
 */
public class p1748 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] standard = {0, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999};
    static int[] dp = new int[10];

    // 100000000
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        int result = 0;
        for (int i=1; i<standard.length; i++) {
            if (N > standard[i]) {
                dp[i] = (standard[i]-standard[i-1])*i + dp[i-1];
            } else {
                result += (N-standard[i-1])*i + dp[i-1];
                break;
            }
        }

        System.out.println(result);
        reader.close();
    }
}
