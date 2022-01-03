package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1057 - 토너먼트
 *
 * N은 2보다 크거나 같고, 100,000보다 작거나 같은 자연수
 * 김지민의 번호와 임한수의 번호는 N보다 작거나 같은 자연수이고, 서로 다르다.
 *
 * 예제 입력 1
 * 16 1 2
 * 예제 출력 1
 * 1
 *
 * 예제 입력 2
 * 16 8 9
 * 예제 출력 2
 * 4
 *
 * 예제 입력 3
 * 1000 20 31
 * 예제 출력 3
 * 4
 *
 * 예제 입력 4
 * 65536 1000 35000
 * 예제 출력 4
 * 16
 *
 * 예제 입력 5
 * 60000 101 891
 * 예제 출력 5
 * 10
 */
public class p1057 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 0;
        do {
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);

            count++;
        } while (a != b);

        System.out.println(count);

        reader.close();
    }
}
