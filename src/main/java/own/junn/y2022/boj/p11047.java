package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11047 - 동전 0
 *
 * (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 * (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 *
 * 예제 입력 1
 * 10 4200
 * 1
 * 5
 * 10
 * 50
 * 100
 * 500
 * 1000
 * 5000
 * 10000
 * 50000
 * 예제 출력 1
 * 6
 *
 * 예제 입력 2
 * 10 4790
 * 1
 * 5
 * 10
 * 50
 * 100
 * 500
 * 1000
 * 5000
 * 10000
 * 50000
 * 예제 출력 2
 * 12
 */
public class p11047 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, K;
    static int[] coins;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];

        for (int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(reader.readLine());
        }

        int count = 0;
        // 가장 큰 금액부터 차례대로 빼나간다
        for (int i=N-1; i>=0; i--) {
            if (K >= coins[i]) {
                // 목표 금액이 잔돈 기준 금액보다 클 시, 해당 금액이 더 작아질 때까지 뺀다.
                // 이 때, 단순 반복문이 아닌 나눗셈 이후 몫을 이용해 빼주는 방식으로 진행
                int ans = K / coins[i];
                K -= coins[i] * ans;
                count += ans;
            }
        }

        System.out.println(count);

        reader.close();
    }
}
