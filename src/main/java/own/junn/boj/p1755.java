package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1755 - 숫자놀이
 */
public class p1755 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static String[] englishNumber = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static String[] numbers;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new String[M-N+1];
        for (int i=N; i<=M; i++) {
            numbers[i-N] = convertToEnglish(i/10, i%10);
            sb.setLength(0);
        }

        Arrays.sort(numbers);
        for (int i=0; i<numbers.length; i++) {
            numbers[i] = convertToNumber(numbers[i]);
            sb.setLength(0);
        }

        for (int i=0; i<numbers.length; i++) {
            sb.append(numbers[i]).append(" ");
            if ((i+1)%10==0) {
                sb.setLength(sb.length()-1);
                sb.append("\n");
            }
        }

        sb.setLength(sb.length()-1);

        System.out.println(sb);

        reader.close();
    }

    static String convertToEnglish(int x, int y) {
        if (x > 0) {
            sb.append(englishNumber[x])
            .append(" ")
            .append(englishNumber[y]);
        } else {
            sb.append(englishNumber[y]);
        }

        return sb.toString();
    }

    static String convertToNumber(String s) {
        String[] tmp = s.split(" ");
        for (int n=0; n<tmp.length; n++) {
            for (int i=0; i<englishNumber.length; i++) {
                if (tmp[n].equalsIgnoreCase(englishNumber[i])) {
                    tmp[n] = String.valueOf(i);
                }
            }
        }

        for (String t : tmp) {
            sb.append(t);
        }

        return sb.toString();
    }
}
