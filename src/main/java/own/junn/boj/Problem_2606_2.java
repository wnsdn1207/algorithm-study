package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2606 - 바이러스
 */
public class Problem_2606_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int count;
    static int connectCount;

    static boolean[] visited;
    static ArrayList<Integer>[] array;

    static int answer;

    public static void main(String[] args) throws Exception {
        count = Integer.parseInt(reader.readLine());
        connectCount = Integer.parseInt(reader.readLine());

        visited = new boolean[count];
        array = new ArrayList[count];

        for (int i=0; i<count; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i=0; i<connectCount; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            array[a].add(b);
            array[b].add(a);
        }

        dfs(0);
        System.out.println(Arrays.toString(visited));
        System.out.println(answer);

        reader.close();
    }

    static void dfs(int start) {
        visited[start] = true;
        ArrayList<Integer> list = array[start];

        for (int l : list) {
            if (!visited[l]) {
                visited[l] = true;
                answer++;
                dfs(l);
            }
        }
    }
}
