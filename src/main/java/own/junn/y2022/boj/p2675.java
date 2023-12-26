package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2675 - 문자열 반복
 */
public class p2675 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            String[] input = reader.readLine().split(" ");

            int loopCount = Integer.parseInt(input[0]);
            char[] chars = input[1].toCharArray();

            sb.append(getNewString(loopCount, chars))
                    .append("\n");
        }

        System.out.println(sb);

        reader.close();
    }

    static String getNewString(int loopCount, char[] chars) {
        StringBuilder sb = new StringBuilder();

        for (char c : chars) {
            for (int i=0; i<loopCount; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
