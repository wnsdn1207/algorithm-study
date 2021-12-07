package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1343 - 폴리오미노
 */
public class p1343 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static char[] chars;
    static String[] pairString = {"AAAA", "BB"};
    public static void main(String[] args) throws Exception {
        chars = reader.readLine().toCharArray();

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == 'X') {
                count++;

                if (i == chars.length-1) {
                    count = replace(count, sb);

                    if (invalidAnswer(sb)) {
                        System.out.println(sb);
                        System.exit(0);
                    }
                }
            } else {
                count = replace(count, sb);

                if (invalidAnswer(sb)) {
                    System.out.println(sb);
                    System.exit(0);
                }

                sb.append(".");
            }
        }

        System.out.println(sb);

        reader.close();
    }

    static int replace(int count, StringBuilder sb) {
        while (count >= 4) {
            sb.append(pairString[0]);
            count -= 4;
        }

        while (count >= 2) {
            sb.append(pairString[1]);
            count -= 2;
        }

        if (count == 1) {
            sb.setLength(0);
            sb.append(-1);
        }

        return count;
    }

    static boolean invalidAnswer(StringBuilder sb) {
        return sb.toString().equalsIgnoreCase("-1");
    }
}
