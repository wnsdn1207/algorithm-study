package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 17103 - 골드바흐 파티션
 *
 * T (1 ≤ T ≤ 100)
 * 2 < N ≤ 1,000,000
 *
 * 예제 입력 1
 * 5
 * 6
 * 8
 * 10
 * 12
 * 100
 * 예제 출력 1
 * 1
 * 1
 * 2
 * 1
 * 6
 */
public class p17103 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;
    static int[] arr = new int[1000001];

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        for (int i=2; i<arr.length; i++) {
            arr[i] = i;
        }
        primeSieve();

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int count = 0;

            for (int i=2; i<n; i++) {
                if (arr[n-i] + arr[i] == n) {
                    count++;

                    // 2로 나누었을 때 소수인 수는 중복 검사에서 제외되므로,
                    // 아래에서 2로 나누어 중복 제거를 하는 로직이 있어 1만큼 더해준다.
                    if (n/2 == arr[i]) {
                        count++;
                    }
                }
            }

            sb.append(count/2).append("\n");
        }

        System.out.println(sb);

        reader.close();
    }

    /**
     * 에라토스테네스의 체
     */
    static void primeSieve() {
        for (int i=2; i<Math.sqrt(arr.length); i++) {
            if (arr[i] > 0) {
                for (int j=i*i; j<arr.length; j+=i) {
                    arr[j] = 0;
                }
            }
        }
    }
}
