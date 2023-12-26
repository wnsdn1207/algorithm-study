package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 11720 - 숫자의 합
 */
public class p11720 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static char[] chars;
    
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        chars = reader.readLine().toCharArray();

        int result = 0;
        for (char c : chars) {
            result += (c - '0');
        }

        System.out.println(result);

        reader.close();
    }
}
