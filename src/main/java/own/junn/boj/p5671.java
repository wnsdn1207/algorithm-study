package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 5671 - 호텔 방 번호
 *
 * (1 ≤ N ≤ M ≤ 5000)
 */
public class p5671 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int A;
    static int B;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        StringTokenizer st;
        String input;
        while ((input = reader.readLine()) != null && !input.isEmpty()) {
            st = new StringTokenizer(input, " ");

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            int result = 0;
            for (int i=A; i<=B; i++) {
                int loopCnt;
                if (i < 10) {
                    loopCnt = 1;
                } else if (i < 100) {
                    loopCnt = 2;
                } else if (i < 1000) {
                    loopCnt = 3;
                } else {
                    loopCnt = 4;
                }

                int[] eachNumbers = new int[loopCnt];
                int stan = i;
                for (int j=0; j<loopCnt; j++) {
                    eachNumbers[j] = stan % 10;
                    stan /= 10;
                }

                if (!hasDuplicated(eachNumbers)) {
                    result++;
                }
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);

        reader.close();
    }

    static boolean hasDuplicated(int[] n) {
        for (int i=0; i<n.length; i++) {
            for (int j=i+1; j<n.length; j++) {
                if (n[i] == n[j]) return true;
            }
        }

        return false;
    }
}
