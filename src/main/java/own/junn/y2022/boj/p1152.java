package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1152 - 단어의 개수
 */
public class p1152 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String input = reader.readLine();

        int count = 0;

        boolean isWord = false;
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            if (c == ' ') {
                isWord = false;
            }

            if (isWord) continue;
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                count++;
                isWord = true;
            }
        }

        System.out.println(count);

        reader.close();
    }
}
