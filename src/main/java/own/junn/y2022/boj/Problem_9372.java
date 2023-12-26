package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 9372 - 상근이의 여행
 */
public class Problem_9372 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(reader.readLine());

        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int j=0; j<M; j++) {
                reader.readLine();
            }

            System.out.println(N-1);
        }
    }
}
