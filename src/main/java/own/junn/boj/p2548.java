package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2548 - 대표자연수
 *
 * 예제 입력 1
 * 6
 * 4 3 2 2 9 10
 * 예제 출력 1
 * 3
 */
public class p2548 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static int[] arr;
    static Queue<Point> queue = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        for (int i=0; i<N; i++) {
            int sum = 0;
            for (int j=0; j<N; j++) {
                sum += Math.abs(arr[i] - arr[j]);
            }

//            System.out.printf("stan : %d, sum : %d\n", arr[i], sum);

            if (answer >= sum) {
                queue.add(new Point(arr[i], sum));
                answer = sum;
            }
        }

//        System.out.println(Arrays.toString(queue.toArray()));
        System.out.println(queue.isEmpty() ? 0 : queue.poll().num);

        reader.close();
    }

    static class Point implements Comparable<Point> {
        int num;
        int sum;

        public Point(int num, int sum) {
            this.num = num;
            this.sum = sum;
        }

        @Override
        public int compareTo(Point o) {
            if (this.sum == o.sum) {
                return this.num - o.num;
            }

            return this.sum - o.sum;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "num=" + num +
                    ", sum=" + sum +
                    '}';
        }
    }
}
