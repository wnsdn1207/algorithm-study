package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 17204 - 죽음의 게임
 */
public class p17204 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int K;

    static ArrayList<Integer>[] array;
    static int[] visited;

    static int result;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new ArrayList[N];
        visited = new int[N];

        Arrays.fill(visited, -1);
        for (int i=0; i<N; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(reader.readLine());
            array[i].add(n);
        }

        bfs();
        System.out.println(visited[K] == 0 ? -1 : visited[K]);

        reader.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = 0;

        while (queue.size() > 0) {
            int node = queue.poll();

            ArrayList<Integer> list = array[node];

            for (int i : list) {
                if (visited[i] == -1) {
                    visited[i] = visited[node] + 1;
                    queue.add(i);
                    result++;
                }
            }
        }
    }
}
