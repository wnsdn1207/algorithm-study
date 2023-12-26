package own.junn.y2023.q4.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p1427 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        char[] chars = reader.readLine().toCharArray();
        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();
        for (char element : chars) {
            sb.append(element);
        }
        StringBuilder reverseString = sb.reverse();
        System.out.println(reverseString);

        reader.close();
    }
}
