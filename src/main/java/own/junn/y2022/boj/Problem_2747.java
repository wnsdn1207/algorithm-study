package own.junn.y2022.boj;

import java.io.*;

/**
 * 2747 - 피보나치수
 */
public class Problem_2747 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[] SUM = new int[46];

    public static void main(String[] args) throws Exception {
        System.out.println(fibonacci(Integer.parseInt(reader.readLine())));
    }

    static int fibonacci(int n) {
        if (SUM[n] > 0) {
            return SUM[n];
        }
        if (n==0) {
            SUM[0] = 0;
            return SUM[0];
        }
        if (n==1) {
            SUM[1] = 1;
            return SUM[1];
        }

        SUM[n] = fibonacci(n-2) + fibonacci(n-1);
        return SUM[n];
    }
}
