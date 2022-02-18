package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2292 - 벌집
 */
public class p2292 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }

        int sum = 1;
        int idx = 1;
        while (N > sum) {
            sum += 6*idx++;
        }
        System.out.println(idx);

        reader.close();
    }
}
