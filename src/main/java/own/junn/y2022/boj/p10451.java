package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 10451 - 순열 사이클
 *
 * N (2 ≤ N ≤ 1,000)
 *
 * 예제 입력 1
 * 2
 * 8
 * 3 2 7 8 1 4 5 6
 * 10
 * 2 1 3 4 5 6 7 9 10 8
 *
 * 예제 출력 1
 * 3
 * 7
 */
public class p10451 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T, N;
    static List<Integer>[] array;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(reader.readLine());

            array = new List[N];
            visited = new boolean[N];

            for (int i=0; i<N; i++) {
                array[i] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int i=0; i<N; i++) {
                int n = Integer.parseInt(st.nextToken()) - 1;

                array[i].add(n);
                array[n].add(i);
            }

            int count = 0;
            for (int i=0; i<N; i++) {
                if (!visited[i]) {
//                    bfs(i);
                    dfs(i);
                    count++;
                }
            }

            System.out.println(count);
        }

        reader.close();
    }

    /**
     * 깊이우선탐색
     *
     * @param start 시작 지점
     */
    static void dfs(int start) {
        visited[start] = true;
        List<Integer> list = array[start];

        for (int i : list) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    /**
     * 너비 우선 탐색
     *
     * @param start 시작 지점
     */
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            List<Integer> list = array[node];
            for (int n : list) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
