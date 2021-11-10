package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 15965 - K번째 소수
 *
 * "에라토스테네스의 체" 이용
 */
public class Problem_15965 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int K;
    static boolean[] numbers = new boolean[10000001];

    public static void main(String[] args) throws Exception {
        K = Integer.parseInt(reader.readLine());

        for (int i=2; i<numbers.length; i++) {
            for (int j=i*2; j<numbers.length; j+=i) {
                numbers[j] = true;
            }
        }

        int count = 0;
        for (int i=2; i<numbers.length; i++) {
            if (!numbers[i]) {
                if (++count == K) {
                    System.out.println(i);
                    return;
                }
            }
        }
        reader.close();
    }

    static boolean isPrime(int x) {
        if (x == 2) {
            return true;
        }
        int end = (int) Math.sqrt(x);
        for (int i=2; i<end; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}
