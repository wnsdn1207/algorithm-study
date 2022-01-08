package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 1541 - 잃어버린 괄호
 *
 * 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
 *
 * 예제 입력 1
 * 55-50+40
 * 예제 출력 1
 * -35
 *
 * 예제 입력 2
 * 10+20+30+40
 * 예제 출력 2
 * 100
 *
 * 예제 입력 3
 * 00009-00009
 * 예제 출력 3
 * 0
 */
public class p1541 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static String string;
    static char[] chars;
    public static void main(String[] args) throws Exception {
        string = reader.readLine();
        chars = string.toCharArray();

        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int tmp = 0;
        for (int i=0; i<chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                sb.append(chars[i]);
            } else if (chars[i] == '-' || chars[i] == '+') {
                tmp += Integer.parseInt(sb.toString());
                sb.setLength(0);

                if (chars[i] == '-') {
                    list.add(tmp);
                    tmp = 0;
                }
            }
        }

        if (sb.length() > 0) {
            tmp += Integer.parseInt(sb.toString());
        }
        if (tmp > 0) {
            list.add(tmp);
        }

//        System.out.println(Arrays.toString(list.toArray()));

        int result = list.get(0);
        for (int i=1; i<list.size(); i++) {
            result -= list.get(i);
        }

        System.out.println(result);

        reader.close();
    }
}
