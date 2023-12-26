package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10166 - 관중석
 */
public class p10166 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int D1;
    static int D2;

    static boolean[][] checked = new boolean[2001][2001];
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        D1 = Integer.parseInt(st.nextToken());
        D2 = Integer.parseInt(st.nextToken());

        for (int i=D1; i<=D2; i++) {
            for (int j=0; j<i; j++) {
                int n = gcd(i, j);
                checked[i/n][j/n] = true;
            }
        }

        int answer = 0;
        for (int i=0; i<2001; i++) {
            for (int j=0; j<2001; j++) {
                if (checked[i][j]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

        reader.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a%b);
    }
}
