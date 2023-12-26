package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 5698 - Tautogram
 */
public class p5698 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String input;
        while (!(input = reader.readLine()).equalsIgnoreCase("*")) {
            String[] inputArr = input.split(" ");
            String first = "";

            boolean isTautogram = true;
            for (String s : inputArr) {
                if (first.isEmpty()) {
                    first = String.valueOf(s.charAt(0));
                }
                if (!s.substring(0, 1).equalsIgnoreCase(first)) {
                    isTautogram = false;
                }
            }

            if (isTautogram) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }

        reader.close();
    }
}
