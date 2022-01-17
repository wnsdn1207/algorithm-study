package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 9498 - 시험 성적
 */
public class p9498 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(reader.readLine());

        System.out.println(n >= 90 ? "A" : n >= 80 ? "B" : n >= 70 ? "C" : n >= 60 ? "D" : "F");

        reader.close();
    }
}
