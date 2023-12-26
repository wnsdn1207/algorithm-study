package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14696 - 딱지놀이
 */
public class p14696 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static int[] A = {0, 0, 0, 0};
    static int[] B = {0, 0, 0, 0};

    static final String WIN_A = "A";
    static final String WIN_B = "B";
    static final String DRAW = "D";

    public static void main(String[] args) throws Exception {
        N = stoi(reader.readLine());

        StringTokenizer st;
        int count;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(reader.readLine());
            count = stoi(st.nextToken());

            while (count-- > 0) {
                A[stoi(st.nextToken()) - 1] += 1;
            }

            st = new StringTokenizer(reader.readLine());
            count = stoi(st.nextToken());

            while (count-- > 0) {
                B[stoi(st.nextToken()) - 1] += 1;
            }

            for (int j=3; j>=0; j--) {
                if (A[j] > B[j]) {
                    System.out.println(WIN_A);
                    break;
                } else if (B[j] > A[j]) {
                    System.out.println(WIN_B);
                    break;
                } else if (A[j] == B[j] && j == 0) {
                    System.out.println(DRAW);
                    break;
                }
            }

            A = new int[4];
            B = new int[4];
        }

        reader.close();
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
