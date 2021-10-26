package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1260 - DFS와 BFS (인접리스트 방식)
 */
public class Problem_1260_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] array;
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

        array = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i=0; i<N+1; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(reader.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            array[x].add(y);
            array[y].add(x);
        }

        for (ArrayList<Integer> list : array) {
            Collections.sort(list);
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

        ArrayList<Integer> list = array[s];
        for (int i : list) {
            if (!visited[i]) {
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

            ArrayList<Integer> list = array[node];
            for (int i : list) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}
