package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1008 - A/B
 */
public class p1008 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] input = reader.readLine().split(" ");

        double answer = Double.parseDouble(input[0]) / Double.parseDouble(input[1]);
        System.out.println(answer);

        reader.close();
    }
}
