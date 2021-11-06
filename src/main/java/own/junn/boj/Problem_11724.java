package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 11724 - 연결 요소의 개수
 */
public class Problem_11724 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static boolean[] visited;
    static ArrayList<Integer>[] array;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        array = new ArrayList[N];

        for (int i=0; i<N; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(reader.readLine(), " ");

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            array[a].add(b);
            array[b].add(a);
        }

        int answer = 0;
        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
        reader.close();
    }

    static void dfs(int start) {
        if (!visited[start]) {
            visited[start] = true;
        }
        ArrayList<Integer> list = array[start];
        for (int i : list) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
