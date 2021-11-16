package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1660 - 캡틴 이다솜
 */
public class p1660 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] fourFacesObj = new int[1000];
    static int[] dp;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        dp = new int[N+1];

        fourFacesObj[0] = 1;
        fourFacesObj[1] = 1 + 3;

        int stackN = 3;
        int n = 3;
        int maxIdx = 0;
        for (int i = 2; i< fourFacesObj.length; i++) {
            stackN += n++;
            fourFacesObj[i] = fourFacesObj[i-1] + stackN;
            if (fourFacesObj[i] > N) {
                maxIdx = i;
                break;
            }
        }

        int count = Integer.MAX_VALUE;
        for (int j=maxIdx; j>=0; j--) {
            int tmp = N;
            int idx = j;
            int unitCount = 0;
            while (true) {
                if (tmp >= fourFacesObj[idx]) {
                    tmp -= fourFacesObj[idx];
                    unitCount++;
                } else {
                    idx--;
                }

                if (tmp == 0) {
                    count = Math.min(count, unitCount);
                    break;
                }
            }
        }

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i=0; i<N+1; i++) {
            int j=0;
            while (fourFacesObj[j] <= i) {
                dp[i] = Math.min(dp[i], dp[i-fourFacesObj[j]] + 1);
                j++;
            }
        }

        System.out.println(dp[N]);

        reader.close();
    }
}
