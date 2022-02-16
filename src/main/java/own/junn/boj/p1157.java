package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1157 - 단어공부
 */
public class p1157 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[] arr = new int[26];

    public static void main(String[] args) throws Exception {
        char[] input = reader.readLine().toCharArray();

        for (char c : input) {
            if (c >= 'a' && c <= 'z') {
                c -= ('a' - 'A');
            }

            arr[c - 'A'] += 1;
        }

        int max = Integer.MIN_VALUE;
        char c = 'A';
        boolean isDuplicated = false;

        for (int i=0; i<arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                c = (char) ('A' + i);
                isDuplicated = false;
            } else if (max == arr[i]) {
                isDuplicated = true;
            }
        }

        if (isDuplicated) {
            System.out.println("?");
        } else {
            System.out.println(c);
        }

        reader.close();
    }
}
