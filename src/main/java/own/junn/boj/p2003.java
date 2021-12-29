package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2003 - 수들의 합 2
 *
 * N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)
 * 각각의 A[x]는 30,000을 넘지 않는 자연수
 *
 * 예제 입력 1
 * 4 2
 * 1 1 1 1
 * 예제 출력 1
 * 3
 *
 * 예제 입력 2
 * 10 5
 * 1 2 3 4 2 5 3 1 1 2
 * 예제 출력 2
 * 3
 */
public class p2003 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(reader.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println("arr : "+ Arrays.toString(arr));

        // 투포인터 Index, lIdx : left, rIdx : right
        int lIdx = 0, rIdx = 0;
        // sum : 각 포인터를 이동시키며 얻은 값들의 합, cnt : 경우의 수
        int sum = 0, cnt = 0;

        while (lIdx <= rIdx && rIdx <= N) {
            if (sum >= M) {
                // 얻은 값이 기준 값보다 크거나 같으면 left index를 증가시키며 sum에서 해당 값만큼 빼준다.
                if (sum == M) {
                    // 더한 값이 기준값과 같으면, 경우의 수를 1만큼 증가시킨다.
                    cnt++;
                }
                sum -= arr[lIdx++];
            } else {
                // 얻은 값이 기준 값보다 작으면 right index를 증가시키며 sum에서 해당 값만큼 더해준다.
                sum += arr[rIdx++];
            }
        }

        System.out.println(cnt);

        reader.close();
    }
}
