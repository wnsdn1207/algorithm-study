package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1213 - 팰린드롬 만들기
 *
 * 예제 입력 1  복사
 * AABB
 * 예제 출력 1  복사
 * ABBA
 *
 * 예제 입력 2  복사
 * AAABB
 * 예제 출력 2  복사
 * ABABA
 *
 * 예제 입력 3  복사
 * ABACABA
 * 예제 출력 3  복사
 * AABCBAA
 *
 * 예제 입력 4  복사
 * ABCD
 * 예제 출력 4  복사
 * I'm Sorry Hansoo
 */
public class p1213 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // 문자열 저장
    static String str;
    // 알파벳별 개수 배열
    static int[] alphabet = new int[26];

    public static void main(String[] args) throws Exception {
        str = reader.readLine();

        for (int i=0; i<str.length(); i++) {
            // 각 알파벳의 인덱스 번호에 맞게 개수를 세준다.
            alphabet[str.charAt(i) - 'A'] += 1;
        }

        // 홀수 개의 알파벳 개수, 홀수 개의 알파벳 인덱스 번호
        int oddCount = 0, oddIdx = -1;
        for (int i = 0; i< alphabet.length; i++) {
            if (alphabet[i]%2 == 1) {
                oddCount++;
                oddIdx = i;
            }
        }

        // 짝수개의 문자열에 홀수 개수의 알파벳이 존재하든지
        // 홀수개의 문자열에 홀수 개수의 알파벳이 2개 이상 존재하든지
        if ((str.length()%2==0 && oddCount>0) || (str.length()%2==1 && oddCount>1)) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            StringBuilder sb = new StringBuilder();

            // 각 알파벳의 개수의 2를 나눈만큼 초기에 더해준다 (사전순 배열이므로)
            for (int i=0; i<alphabet.length; i++) {
                for (int j=0; j<alphabet[i]/2; j++) {
                    sb.append((char) (i + 'A'));
                }
            }

            // 입력된 알파벳들을 거꾸로 뒤집어 reverseStr 변수에 할당해준다. (mirroring string)
            String reverseStr = new StringBuilder(sb.toString()).reverse().toString();

            // 홀수 개수의 알파벳이 존재한다면, 위에서 저장해두었던 홀수 인덱스 번호를 통해 제일 끝에 넣어준다.
            // => 제일 끝이지만, 최종적으로는 제일 중간
            if (oddCount == 1) {
                sb.append((char) (oddIdx + 'A'));
            }
            sb.append(reverseStr);

            System.out.println(sb);
        }

        reader.close();
    }

}
