package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 17413 - 단어 뒤집기 2
 */
public class p17413_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static char[] chars;
    public static void main(String[] args) throws Exception {
        chars = reader.readLine().toCharArray();

        int idx = 0;
        while (idx<chars.length) {
            if (chars[idx] == '<') {
                while(chars[idx++]!='>') {}
            } else if (Character.isLetterOrDigit(chars[idx])) {
                int start = idx;
                while (idx < chars.length && chars[idx] != '<' && chars[idx] != ' ') {
                    idx++;
                }
                int end = idx-1;
                reverse(chars, start, end);

                if(idx<chars.length && chars[idx]!='<') {
                    idx++;
                }
            }
        }

        System.out.println(chars);
    }

    static void reverse(char[] chars, int start, int end) {
        while (start<end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;

            start++;
            end--;
        }
    }
}
