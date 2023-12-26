package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1783 - 병든 나이트
 *
 * N과 M은 2,000,000,000보다 작거나 같은 자연수
 *
 * 예제 입력 1  복사
 * 100 50
 * 예제 출력 1  복사
 * 48
 *
 * 예제 입력 2  복사
 * 1 1
 * 예제 출력 2  복사
 * 1
 *
 * 예제 입력 3  복사
 * 17 5
 * 예제 출력 3  복사
 * 4
 *
 * 예제 입력 4  복사
 * 2 4
 * 예제 출력 4  복사
 * 2
 *
 * 예제 입력 5  복사
 * 20 4
 * 예제 출력 5  복사
 * 4
 */
public class p1783 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N == 1) {
            System.out.println(1);
        } else if (N == 2) {
            System.out.println(Math.min(4, (M+1)/2));
        } else if (N >= 3 && M < 7) {
            System.out.println(Math.min(4, M));
        } else {
            System.out.println(M-2);
        }

        reader.close();
    }
}
