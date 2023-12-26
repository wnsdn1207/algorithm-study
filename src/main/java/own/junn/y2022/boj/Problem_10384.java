package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 10384 - 팬그램
 */
public class Problem_10384 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int n;

    static String print = "Case %d: ";
    static String[] PANGRAMS = {"Not a pangram", "Pangram!", "Double pangram!!", "Triple pangram!!!"};
    static int[] hasAlphabet;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(reader.readLine());

        for (int i=1; i<n+1; i++) {
            char[] clause = reader.readLine().toLowerCase().toCharArray();
            hasAlphabet = new int[26];

            for (char c : clause) {
                for (int k = 97; k < 123; k++) {
                    if (c == k) {
                        hasAlphabet[k - 97] += 1;
                    }
                }
            }

            System.out.println(String.format(print, i) + PANGRAMS[evaluate(hasAlphabet)]);
        }
        reader.close();
    }

    static int evaluate(int[] arr) {
        int result = Integer.MAX_VALUE;
        for (int a : arr) {
            result = Math.min(result, a);
        }

        return result;
    }
}
