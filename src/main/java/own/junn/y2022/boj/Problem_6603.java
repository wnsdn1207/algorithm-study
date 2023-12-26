package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 6603 - 로또
 */
public class Problem_6603 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[] arr;
    static boolean[] visited;

    static int K;

    public static void main(String[] args) throws Exception {
        String input;
        while (!(input = reader.readLine()).equalsIgnoreCase("0")) {
            StringTokenizer st = new StringTokenizer(input, " ");

            K = Integer.parseInt(st.nextToken());

            arr = new int[K];
            visited = new boolean[K];
            for (int i=0; i<K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println();
        }
    }

    static void dfs(int start, int depth) {
        if (depth == 6) {
            print();
            return;
        }
        for (int i = start; i< K; i++) {
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }

    static void print() {
        for (int i = 0; i< arr.length; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
