package own.junn.boj;

import java.util.*;
import java.io.*;

/**
 * 14248 - 점프 점프
 */
public class Problem_14248 {
    static int N;
    static int[] distances;
    static boolean[] visited;
    static int startPoint;

    static Queue<Integer> queue;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        distances = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        for (int i=0; i<N; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        startPoint = Integer.parseInt(reader.readLine())-1;
        queue = new LinkedList<>();

        bfs(startPoint);
        System.out.println(result);
    }

    static void bfs(int startPoint) {
        queue.add(startPoint);
        visited[startPoint] = true;
        result += 1;

        while (queue.size() > 0) {
            int node = queue.remove();
            int distance = distances[node];

            // 왼쪽 점프
            int jump;

            jump = node - distance;
            if (jump >= 0 && !visited[jump]) {
                queue.add(jump);
                result += 1;
                visited[jump] = true;
            }

            jump = node + distance;
            if (jump < N && !visited[jump]) {
                queue.add(jump);
                result += 1;
                visited[jump] = true;
            }
        }
    }
}
