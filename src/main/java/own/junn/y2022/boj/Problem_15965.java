package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 15965 - K번째 소수
 *
 * "에라토스테네스의 체" 이용
 *
 * 1. 1~N 까지의 숫자를 나열
 * 2. 자기 자신을 제외하고 2의 배수를 제거
 * 3. 자기 자신을 제외하고 3의 배수를 제거
 * 4. 자기 자신을 제외하고 5의 배수를 제거 (4는 소수가 아니므로 제외, 2번 항목에 의해 걸러짐)
 * ...
 *
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
