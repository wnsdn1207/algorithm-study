package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4796 - 캠핑장
 */
public class p4796 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int L;
    static int P;
    static int V;

    public static void main(String[] args) throws Exception {

        int index = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) {
                break;
            } else {
                int result = 0;
                while (V > P) {
                    V -= P;
                    result += L;
                }

                result += Math.min(V, L);

//                System.out.printf("L : %d, P : %d, V : %d\n", L, P, V);
//                System.out.printf("Result : %d\n", result);
                System.out.printf("Case %d: %d\n", index++, result);
            }
        }

        reader.close();
    }
}
