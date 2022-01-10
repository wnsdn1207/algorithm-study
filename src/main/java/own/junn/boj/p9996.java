package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 9996 - 한국이 그리울 땐 서버에 접속하지
 *
 * 예제 입력 1
 * 3
 * a*d
 * abcd
 * anestonestod
 * facebook
 * 예제 출력 1
 * DA
 * DA
 * NE
 *
 * 예제 입력 2
 * 6
 * h*n
 * huhovdjestvarnomozedocisvastan
 * honijezakon
 * atila
 * je
 * bio
 * hun
 * 예제 출력 2
 * DA
 * DA
 * NE
 * NE
 * NE
 * DA
 */
public class p9996 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static String[] pattern;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        pattern = reader.readLine().split("\\*");

        for (int i=0; i<N; i++) {
            String input = reader.readLine();

            /**
             * 문자열이 "*" 앞의 문자열로 시작하며,
             * 문자열의 길이가 패턴의 "*"를 제외한 나머지 두 개의 문자열의 길이합보다 길며,
             * 문자열의 끝이 패턴의 "*" 뒤의 문자열로 끝나는 문자열
             */
            if (
                    input.startsWith(pattern[0]) &&
                    input.length() >= pattern[0].length() + pattern[1].length() &&
                    input.substring(input.length() - pattern[1].length()).equalsIgnoreCase(pattern[1])
            ) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }

        reader.close();
    }
}
