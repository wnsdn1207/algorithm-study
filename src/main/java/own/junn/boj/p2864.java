package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2864 - 5와 6의 차이
 */
public class p2864 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        char[] num1 = st.nextToken().toCharArray();
        char[] num2 = st.nextToken().toCharArray();

        int minNum1, maxNum1, minNum2, maxNum2;

        StringBuilder min = new StringBuilder(), max = new StringBuilder();
        for (char c : num1) {
            if (c == '5' || c == '6') {
                min.append('5');
                max.append('6');
            } else {
                min.append(c);
                max.append(c);
            }
        }

        minNum1 = Integer.parseInt(min.toString());
        maxNum1 = Integer.parseInt(max.toString());

        min.setLength(0);
        max.setLength(0);

        for (char c : num2) {
            if (c == '5' || c == '6') {
                min.append('5');
                max.append('6');
            } else {
                min.append(c);
                max.append(c);
            }
        }

        minNum2 = Integer.parseInt(min.toString());
        maxNum2 = Integer.parseInt(max.toString());

        System.out.print((minNum1 + minNum2) + " " + (maxNum1 + maxNum2) + "\n");
    }
}
