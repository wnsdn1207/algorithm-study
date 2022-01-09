package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 15903 - 카드합체놀이
 *
 * n(2 ≤ n ≤ 1,000)
 * m(0 ≤ m ≤ 15×n)
 * (1 ≤ ai ≤ 1,000,000)
 *
 * 예제 입력 1
 * 3 1
 * 3 2 6
 * 예제 출력 1
 * 16
 *
 * 예제 입력 2
 * 4 2
 * 4 2 3 1
 * 예제 출력 2
 * 19
 */
public class p15903 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static Queue<Long> queue = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<N; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        for (int i=0; i<M; i++) {
            long x = queue.isEmpty() ? 0 : queue.poll();
            long y = queue.isEmpty() ? 0 : queue.poll();
            long result = x + y;

            queue.add(result);
            queue.add(result);
        }

//        System.out.println(Arrays.toString(queue.toArray()));
        long sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }

        System.out.println(sum);

        reader.close();
    }
}
