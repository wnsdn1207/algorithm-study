package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 9656 - 돌게임 2
 * (1 ≤ N ≤ 1000)
 *
 * 예제 입력 1
 * 4
 * 예제 출력 1
 * SK
 */
public class p9656 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        int count = 0;
        count += N/3;
        N %= 3;

        if (N == 1) {
            count++;
        }

        System.out.println(count % 2 == 0 ? "SK" : "CY");

        reader.close();
    }
}
