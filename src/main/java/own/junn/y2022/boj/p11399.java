package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 11399 - ATM
 *
 * N(1 ≤ N ≤ 1,000)
 * (1 ≤ Pi ≤ 1,000)
 *
 * 예제 입력 1
 * 5
 * 3 1 4 3 2
 * 예제 출력 1
 * 32
 */
public class p11399 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] elapsed;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        elapsed = new int[N];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i=0; i<N; i++) {
            elapsed[i] = Integer.parseInt(st.nextToken());
        }

        // 시간들끼리의 최소 합을 구해야 함
        // 따라서, 0번째 인덱스와 가까울 수록 숫자가 적은 오름차순 배열이 가장 적은 합을 만들 수 있음
        Arrays.sort(elapsed);
        int sum = 0;
        for (int i=1; i<N; i++) {
            // dp와 같이 i번째 인덱스에 해당하는 값을 i-1번째와 i번째의 값으로 더하여준다. (누적 시간)
            elapsed[i] = elapsed[i-1] + elapsed[i];
            // 각 사용자들이 돈을 뽑기 위해 걸리는 시간들을 합산하기 위해 더한다.
            sum += elapsed[i];
        }

        // 위의 반복문에서 계산하지 않는 0번째 인덱스의 값은 따로 더해준다.
        sum += elapsed[0];
        System.out.println(sum);

        reader.close();
    }
}