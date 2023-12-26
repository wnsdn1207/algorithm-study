package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2839 - 설탕 배달
 */
public class p2839 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        int result = 0;
        while (true) {
            if (N % 5 > 0) {
                N -= 3;
            } else {
                N -= 5;
            }
            result++;

            if (N == 0) {
                break;
            } else if (N < 3) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(result);

        reader.close();
    }
}
