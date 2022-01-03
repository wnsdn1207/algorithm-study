package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 18310 - 안테나
 *
 * (1≤N≤200,000)
 * N채의 집에 위치가 공백을 기준으로 구분되어 1이상 100,000이하의 자연수
 *
 * 예제 입력 1
 * 4
 * 5 1 7 9
 * 예제 출력 1
 * 5
 */
public class p18310 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] antennas;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        antennas = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i=0; i<N; i++) {
            antennas[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(antennas);
        System.out.println(Arrays.toString(antennas));

        int minVal = Integer.MAX_VALUE, minIdx = -1;
        for (int i=0; i<N; i++) {
            int sum = 0;
            for (int j=0; j<N; j++) {
                sum += Math.abs(antennas[i] - antennas[j]);
            }

            if (minVal > sum) {
                minVal = sum;
                minIdx = i;
            }
        }

        System.out.println(antennas[minIdx]);

        reader.close();
    }
}
