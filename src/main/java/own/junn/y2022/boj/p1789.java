package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1789 - 수들의 합
 */
public class p1789 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static long N;

    public static void main(String[] args) throws Exception {
        N = Long.parseLong(reader.readLine());

        long idx = 0;
        while (N > 0) {
            N -= ++idx;
//            System.out.println(N);
            if (N <= idx) {
                break;
            }
        }

//        System.out.println("N : "+ N);
//        System.out.println("idx : " + idx);
        System.out.println(idx);

        reader.close();
    }
}
