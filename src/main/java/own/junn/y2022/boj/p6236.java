package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 6236 - 용돈관리
 *
 * (1 ≤ N ≤ 100,000, 1 ≤ M ≤ N)
 * (1 ≤ 금액 ≤ 10000)
 *
 * 예제 입력 1
 * 7 5
 * 100
 * 400
 * 300
 * 100
 * 500
 * 101
 * 400
 * 예제 출력 1
 * 500
 *
 */
public class p6236 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[] use;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        use = new int[N];

        int highPrice = 0;
        for (int i=0; i<N; i++) {
            use[i] = Integer.parseInt(reader.readLine());
            // 일별 생활 금액 중 가장 높은 금액
            highPrice = Math.max(highPrice, use[i]);
        }

        // start : 1부터 검색 (사실, 최대값으로 검색하는 것이 오차를 더 줄일 수 있다. 왜냐하면, 어차피 최대값만큼은 인출을 해야 생활이 가능하기 때문)
        // end :
        int start = 1, end = N * highPrice;
        int result = end;
        // 이분탐색
        while (start <= end) {
            int mid = (start + end) / 2;

            if (isPossible(mid)) {
                end = mid - 1;
                // 나온 결과값들 중 가장 작은 값을 사용한다.
                result = Math.min(result, mid);
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);

        reader.close();
    }

    static boolean isPossible(int mid) {
        int remain = mid;
        int count = 1;

        for (int i=0; i<N; i++) {
            // mid만큼의 돈을 계속 인출할 것인데, mid보다 사용할 돈이 더 많으면 해당 일자는 만족할 수 없는 하루가 됨
            // 따라서, false return
            if (mid < use[i]) {
                return false;
            }

            // 위의 조건이 있기 때문에, remain 금액으로 1일 이상의 삶을 살 수 있다.
            // 금액이 부족해지면, 재인출
            if (remain - use[i] < 0) {
                remain = mid;
                count++;
            }

            // 남은 금액을 지속적으로 줄여나감 (최초 인출한 금액으로 여러 일을 살 수도 있기 때문)
            remain -= use[i];
        }

        // 최대 인출 횟수만큼보다 적거나 같은 횟수만큼 돈을 인출하였는지
        return count <= M;
    }
}
