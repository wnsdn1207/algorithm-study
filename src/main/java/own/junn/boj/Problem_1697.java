package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1697 - 숨바꼭질
 */
public class Problem_1697 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int K;

    static int[] dx = {1, -1, 2};

    static int[] visited = new int[100001];

    public static void main(String[] args) throws Exception {
        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        Arrays.fill(visited,  -1);

        moving();
        System.out.println(visited[K]);
    }

    static void moving() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = visited[N] + 1;

        boolean isArrived = false;
        while (queue.size() > 0) {
            int pos = queue.poll();

            int aPos;
            for (int i=0; i<dx.length; i++) {
                if (dx[i] > 1) {
                    aPos = pos * dx[i];
                } else {
                    aPos = pos + dx[i];
                }

                if (isValidRange(aPos) && visited[aPos] == -1) {
                    queue.add(aPos);
                    visited[aPos] = visited[pos] + 1;
                }

                if (aPos == K) {
                    isArrived = true;
                    break;
                }
            }

            if (isArrived) {
                break;
            }
        }
    }

    static boolean isValidRange(int x) {
        return x >= 0 && x < 100001;
    }
}
