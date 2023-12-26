package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3079 - 입국심사
 *
 * (1 ≤ N ≤ 100,000, 1 ≤ M ≤ 1,000,000,000)
 * (1 ≤ Tk ≤ 10e9)
 *
 * 예제 입력 1
 * 2 6
 * 7
 * 10
 * 예제 출력 1
 * 28
 *
 * 예제 입력 2
 * 7 10
 * 3
 * 8
 * 3
 * 6
 * 9
 * 2
 * 4
 * 예제 출력 2
 * 8
 */
public class p3079 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static long[] checkTables;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        checkTables = new long[N];

        // 이분 탐색의 최대 범위 설정을 위해 max값 세팅
        long max = 0;
        for (int i=0; i<N; i++) {
            checkTables[i] = Long.parseLong(reader.readLine());
            max = Math.max(max, checkTables[i]);
        }

        // 소요 시간의 최소값을 세팅하기 위해, Long의 최대값으로 세팅해준다.
        // Integer의 최대값은 입력으로 주어지는 수보다 작을 수 있다. (max(Tk) == 10e9)
        long result = Long.MAX_VALUE;

        // 주어진 범위 중 최소값은 1
        // 최대값은 입력으로 들어올 M(사람수)에 가장 오래 걸리는 시간을 곱해준 값이 된다.
        long low = 1, high = max * M;
        while (low <= high) {
            long midTime = (low + high) / 2;

            // midTime 시간 내에 입국심사를 할 수 있는 최대 인원을 찾기 위함
            long sum = 0;
            for (long elapsed : checkTables) {
                // 주어진 midTime 내에 입국심사 대상 인원(M)보다 많이 심사할 수 있다면,
                // 더이상 더하지 않아도 가능하단 것을 알 수 있으므로 break
                if (sum >= M) break;

                // midTime 시간 내에 각 테이블에서 검사할 수 있는 최대 명수
                long available = midTime / elapsed;

                // 최대 명수만큼 입국심사가 가능한 것이므로, 더해준다.
                sum += available;
            }

            // M명의 입국 대상자는 무조건 심사하여야 하므로,
            // 주어진 midTime 내에 M명의 입국 대상자보다 많이 심사할 수 있는지 확인한다. => sum
            if (sum >= M) {
                // 가장 적은 시간이 걸리는 midTime을 답으로 선정해야 하므로 아래와 같이 세팅해준다.
                result = Math.min(result, midTime);
                high = midTime - 1;
            } else {
                low = midTime + 1;
            }
        }

        System.out.println(result);

        reader.close();
    }
}
