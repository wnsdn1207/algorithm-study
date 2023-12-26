package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 20444 - 색종이와 가위
 *
 * 예제 입력 1
 * 4 9
 * 예제 출력 1
 * YES
 *
 * 예제 입력 2
 * 4 6
 * 예제 출력 2
 * NO
 */
public class p20444 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static long N;
    static long K;

    public static void main(String[] args) throws Exception {
        String[] input = reader.readLine().split(" ");

        N = Long.parseLong(input[0]);
        K = Long.parseLong(input[1]);

        long height=1, width=1;

        for (long i=N; i>=N/2; i--) {
            long ah = height + i;
            long aw = width + (N - i);

            long ahw = ah * aw;
            if (ahw == K) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");

        reader.close();
    }
}
