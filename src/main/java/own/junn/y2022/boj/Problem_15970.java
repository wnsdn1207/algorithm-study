package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 15970 - 화살표그리기
 */
public class Problem_15970 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static boolean[][] dots;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        dots = new boolean[N+1][100001];

        int maxPos = Integer.MIN_VALUE, maxColors = Integer.MIN_VALUE;
        for (int i=0; i<N; i++) {
            String[] tmp = reader.readLine().split(" ");

            int n = Integer.parseInt(tmp[0]);
            int m = Integer.parseInt(tmp[1]);

            dots[m][n] = true;
            maxPos = Math.max(maxPos, n+1);
            maxColors = Math.max(maxColors, m+1);
        }

        int sum = 0;
        for (int i=1; i<maxColors; i++) {
            int prevPos = -1, prevLen = Integer.MAX_VALUE, currPos, currLen = 0;
            for (int j=0; j<maxPos; j++) {
                if (dots[i][j]) {
                    currPos = j;
                    if (prevPos > -1) {
                        currLen = currPos - prevPos;
                        sum += Math.min(currLen, prevLen);
                    }
                    prevPos = currPos;
                    if (currLen > 0) {
                        prevLen = currLen;
                    }
                }
            }

            sum += currLen;
        }

        System.out.println(sum);
    }
}
