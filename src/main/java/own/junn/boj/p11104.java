package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 11104 - Fridge of Your Dreams
 */
public class p11104 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(reader.readLine());

        for (int i=0; i<n; i++) {
            int binaryToDecimal = Integer.parseInt(reader.readLine(), 2);
            System.out.println(binaryToDecimal);
        }

        reader.close();
    }
}
