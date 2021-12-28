package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 13305 - 주유소
 *
 * N(2 ≤ N ≤ 100,000)
 * 제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수
 * 리터당 가격은 1 이상 1,000,000,000 이하의 자연수
 *
 *
 * 예제 입력 1
 * 4
 * 2 3 1
 * 5 2 4 1
 * 예제 출력 1
 * 18
 *
 * 예제 입력 2
 * 4
 * 3 3 4
 * 1 1 1 1
 * 예제 출력 2
 * 10
 *
 */
public class p13305 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    // 오일 가격 배열
    static int[] oilPrices;
    // 도시 간 거리 배열
    static int[] distances;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        oilPrices = new int[N];
        distances = new int[N];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i=1; i<N; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<N; i++) {
            oilPrices[i] = Integer.parseInt(st.nextToken());
        }

        // 오일의 최소가격을 저장
        int minPrices = oilPrices[0];

        // 왼쪽 도시에서 오른쪽 도시로 가기위한 최소 금액
        long totalPrices = 0;
        for (int i=1; i<N; i++) {
            // 오일의 최고가격과 거리를 곱하여 최소 금액 변수에 더해줌
            totalPrices += (long) minPrices * distances[i];
            // minPrices를 각 방문 도시의 오일 가격과 비교하여 최소값으로 저장
            minPrices = Math.min(minPrices, oilPrices[i]);
        }

        System.out.println(totalPrices);

        reader.close();
    }
}
