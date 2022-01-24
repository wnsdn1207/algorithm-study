package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 3079 - 입국심사
 *
 * (1 ≤ N ≤ 100,000, 1 ≤ M ≤ 1,000,000,000)
 * (1 ≤ Tk ≤ 109)
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
    static int[] arr;
    static Queue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        for (int i : arr) {
            for (int j=1; j<=M; j++) {
                queue.add(i*j);
            }
        }

        System.out.println(Arrays.toString(queue.toArray()));

        int result = 0;
        for (int i=0; i<M; i++) {
            if (!queue.isEmpty()) {
                result = queue.poll();
            }
        }

        System.out.println(result);

        reader.close();
    }
}
