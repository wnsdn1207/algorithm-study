package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 12761 - 돌다리
 */
public class p12761 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int A;
    static int B;
    static int N;
    static int M;

    static int[] stones = new int[100001];
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Arrays.fill(stones, -1);

        int[] dy = {1, -1, -A, -B, A, B, A, B};
        bfs(dy);

        System.out.println(stones[M]);

        reader.close();
    }

    static void bfs(int[] dy) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        stones[N] = 0;

        while (queue.size() > 0) {
            int node = queue.poll();

            int ay;
            for (int i=0; i<8; i++) {

                if (i >= 6) {
                    ay = node * dy[i];
                } else {
                    ay = node + dy[i];
                }

                if (isValid(ay) && (stones[ay] == -1 || stones[ay] > stones[node] + 1)) {
                    stones[ay] = stones[node] + 1;
                    queue.add(ay);
                }
            }
        }
    }

    static boolean isValid(int y) {
        return y >= 0 && y <= 100000;
    }
}
