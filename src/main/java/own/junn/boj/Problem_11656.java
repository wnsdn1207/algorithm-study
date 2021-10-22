package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 11656 - 접미사배열
 */
public class Problem_11656 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        int len = input.length();

        String[] inputArr = new String[len];
        for (int i=0; i<len; i++) {
            inputArr[i] = input.substring(i);
        }
        Arrays.sort(inputArr);

        for (int i=0; i<len; i++) {
            System.out.println(inputArr[i]);
        }
    }
}
