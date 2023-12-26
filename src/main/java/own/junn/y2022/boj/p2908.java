package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2908 - 상수
 */
public class p2908 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] input = reader.readLine().split(" ");

        StringBuilder sb = new StringBuilder();

        int A, B;

        sb.append(input[0]);
        A = Integer.parseInt(sb.reverse().toString());
        sb.setLength(0);

        sb.append(input[1]);
        B = Integer.parseInt(sb.reverse().toString());
        sb.setLength(1);

        System.out.println(Math.max(A, B));

        reader.close();
    }
}
