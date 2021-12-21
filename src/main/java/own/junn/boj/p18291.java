package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 18291 - 비요뜨의 징검다리 건너기
 *
 * (1 ≤ T ≤ 1000)
 * (1 ≤ N ≤ 1e9)
 *
 * 예제 입력 1
 * 1
 * 4
 *
 * 예제 출력 1
 * 4
 */
public class p18291 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;
    static long N;

    static final long DIVIDE = (long) (1e9 + 7);

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            N = Long.parseLong(reader.readLine());

            if (N == 1) {
                System.out.println(1);
            } else {
                // 계산을 하여보면, 결국 2^N-2가 답이 된다.
                // N이 최대 10^9까지 가능하므로, 분할정복을 통해 거듭제곱을 해줘야만 한다.
                System.out.println(divideAndConquer(2, N-2));
            }
        }

        reader.close();
    }

    /**
     * 분할 정복을 통한 거듭 제곱
     *
     * @param a 정수(밑)
     * @param b 지수
     * @return a^b 결과값
     */
    static long divideAndConquer(long a, long b) {
        if (b == 0) {
            return 1;
        }

        long result = divideAndConquer(a, b/2) % DIVIDE;
        if (b % 2 == 0) {
            return (result * result) % DIVIDE;
        } else {
            long tmp = (result * result) % DIVIDE;
            return (tmp * a) % DIVIDE;
        }
    }
}
