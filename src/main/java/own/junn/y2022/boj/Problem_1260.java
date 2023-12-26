package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1260 - DFS와 BFS (인접행렬 방식)
 */
public class Problem_1260 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    static int N;
    static int M;
    static int V;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        while (st.hasMoreTokens()) {
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
        }

        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(reader.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;
        }
        dfs(V);
        sb.append("\n");
        Arrays.fill(visited, false);

        bfs(V);
        System.out.println(sb);

        sb.setLength(0);
        reader.close();
    }

    static void dfs(int s) {
        visited[s] = true;
        sb.append(s).append(" ");

        for (int i=1; i<N+1; i++) {
            if (!visited[i] && map[s][i] > 0) {
                dfs(i);
            }
        }
    }

    static void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        visited[s] = true;

        while (q.size() > 0) {
            int node = q.remove();
            sb.append(node).append(" ");

            int[] relations = map[node];

            for (int r=0; r<relations.length; r++) {
                if (map[node][r] > 0 && !visited[r]) {
                    q.add(r);
                    visited[r] = true;
                }
            }
        }

    }
}
