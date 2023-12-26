package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 17413 - 단어 뒤집기 2
 */
public class p17413 {
    /**
     * Condition
     * <p>
     * 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
     * 문자열의 시작과 끝은 공백이 아니다.
     * '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
     * 태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다.
     * 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다.
     * 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
     */
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static String S;

    static String TAG_REGEX = "<[a-z0-9\\s]+>";
    static String EMPTY_REGEX = "\\s+";
    static String STR_REGEX = "[a-z0-9]+";

    static String[] REGEX_ARR = {TAG_REGEX, EMPTY_REGEX, STR_REGEX};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        S = reader.readLine();

//        int i = 3;
        while (!S.isEmpty()) {
            System.out.println("extracted : [" + S.charAt(0) + "]");
            System.out.println(checkCharPattern(S.substring(0, 1)));

            int patternNo = checkCharPattern(S.substring(0, 1));
            Pattern pattern = Pattern.compile(REGEX_ARR[patternNo]);
            Matcher matcher = pattern.matcher(S);

            if (matcher.find()) {
                System.out.println("find pattern : " + matcher.group());
                System.out.printf("[%s]\n", S.substring(0, matcher.end()));
                sb.append(reverseString(S.substring(0, matcher.end())));
                S = S.substring(matcher.end());
            }
        }
        System.out.println();
        System.out.println(sb);

        reader.close();
    }

    static int checkCharPattern(String s) {
        if (s.equalsIgnoreCase("<")) {
            return 0;
        } else if (s.equalsIgnoreCase(" ")) {
            return 1;
        } else if (s.matches(STR_REGEX)) {
            return 2;
        }

        return -1;
    }

    static String reverseString(String s) {
        if (s.charAt(0) == ' ' || s.charAt(0) == '<' || s.charAt(0) == '>') {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s, i, i + 1);
        }

        return sb.toString();
    }
}
