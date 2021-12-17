package own.junn.boj;

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

public class p20444_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static long N;
    static long K;

    public static void main(String[] args) throws Exception {
        String[] input = reader.readLine().split(" ");

        N = Long.parseLong(input[0]);
        K = Long.parseLong(input[1]);

        long start = 0, end = N/2;

        long mid, result;
        while (start <= end) {
            mid = (start + end) / 2;
            result = getResult(mid, N-mid);

//            System.out.printf("row : %d, col : %d, width : %d\n", mid, N-mid, result);
            if (result == K) {
                System.out.println("YES");
                return;
            } else if (result > K){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println("NO");

        reader.close();
    }

    static long getResult(long a, long b) {
        return (a+1) * (b+1);
    }
}
