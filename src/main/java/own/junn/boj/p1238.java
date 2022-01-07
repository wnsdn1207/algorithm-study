package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1238 - 파티
 *
 * N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 10,000), X(1 ≤ X ≤ N), Ti(1 ≤ Ti ≤ 100)
 *
 * 예제 입력 1
 * 4 8 2
 * 1 2 4
 * 1 3 2
 * 1 4 7
 * 2 1 1
 * 2 3 5
 * 3 1 2
 * 3 4 4
 * 4 2 3
 *
 * 예제 출력 1
 * 10
 *
 */
public class p1238 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M, X;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(reader.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int elapsed = Integer.parseInt(st.nextToken());
        }

        reader.close();
    }
}
