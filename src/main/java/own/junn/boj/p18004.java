package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 18004 - From A to B
 *
 * 103 27
 * 4
 *
 * 3 8
 * 5
 *
 */
public class p18004 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int A;
    static int B;

    public static void main(String[] args) throws Exception {
        String[] input = reader.readLine().split(" ");

        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);

        int cnt = 0;
        while (A != B) {
            if (A > B && A % 2 == 0) {
                A /= 2;
            } else {
                A += 1;
            }
            cnt++;
        }

        System.out.println(cnt);
    }

}
