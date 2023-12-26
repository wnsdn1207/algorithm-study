package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2512 - 예산
 *
 * N은 3 이상 10,000 이하
 * N개의 정수가 빈칸을 사이에 두고 주어진다. 이 값들은 모두 1 이상 100,000 이하
 * M은 N 이상 1,000,000,000 이하
 *
 * 예제 입력 1
 * 4
 * 120 110 140 150
 * 485
 * 예제 출력 1
 * 127
 *
 * 예제 입력 2
 * 5
 * 70 80 30 40 100
 * 450
 * 예제 출력 2
 * 100
 */
public class p2512 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] needs;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        needs = new int[N];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i=0; i<N; i++) {
            needs[i] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색으로 최적값을 찾기 위해 정렬해준다.
        Arrays.sort(needs);

        int max = Integer.parseInt(reader.readLine());
        // 이분 탐색을 위한 start, end 인자
        int start = 0, end = needs[N-1];

        int answer = binarySearch(start, end, max);
        System.out.println(answer);

        reader.close();
    }

    /**
     * 상한값을 찾는 이분 탐색 메서드
     *
     * @param start 시작 Index
     * @param end 종료 Index
     * @param max 최대값
     * @return 상한값
     */
    static int binarySearch(int start, int end, int max) {
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            for (int i : needs) {
                // 중간값보다 큰 값은 중간값으로 치환하여 준다.
                sum += Math.min(i, mid);
            }

            if (sum > max) {
                end = max - 1;
            } else {
                start = mid + 1;
                // sum이 max보다 작은 경우이므로, 정답이 될 수 있다.
                // 정답이 될 수 있는 수 중 가장 큰 수가 정답이 돼야 하므로, Math.max() 함수를 이용하여 값을 할당한다.
                result = Math.max(result, mid);
            }
        }

        return result;
    }
}
