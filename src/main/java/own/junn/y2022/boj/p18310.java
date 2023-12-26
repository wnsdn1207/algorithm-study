package own.junn.y2022.boj;

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
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        antennas = new int[N];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i=0; i<N; i++) {
            antennas[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(antennas);
        System.out.println(antennas[(N-1)/2]);

        /**
         * 정렬 후에 합산 계산을 해보면 중간 인덱스 부근에 있는 데이터들이 항상 최솟값이 나온다.
         */
//        for (int i=0; i<N; i++) {
//            int sum = 0;
//            for (int j=0; j<N; j++) {
//                sum += Math.abs(antennas[i] - antennas[j]);
//            }
//
//            System.out.print(sum + " ");
//        }
//        System.out.println();

        reader.close();
    }
}
