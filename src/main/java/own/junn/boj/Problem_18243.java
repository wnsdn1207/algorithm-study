package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 18243 - Small World Network
 */
public class Problem_18243 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static ArrayList<Integer>[] array;
    static int[] visitedCnt;

    static int N;
    static int K;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new ArrayList[N];
        visitedCnt = new int[N];

        for (int i=0; i<N; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i=0; i<K; i++) {
            String[] tmp = reader.readLine().split(" ");

            int a = Integer.parseInt(tmp[0]) - 1;
            int b = Integer.parseInt(tmp[1]) - 1;

            array[a].add(b);
            array[b].add(a);
        }

        for (int i=0; i<N; i++) {
            Arrays.fill(visitedCnt, -1);
            bfs(i);

            for (int cnt : visitedCnt) {
                if (cnt == -1 || cnt > 6) {
                    System.out.println("Big World!");
                    System.exit(0);
                }
            }
        }

        System.out.println("Small World!");
    }

    static void bfs(int start) {
        visitedCnt[start] = visitedCnt[start] + 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (queue.size() > 0) {
            int node = queue.poll();

            ArrayList<Integer> list = array[node];
            for (int n : list) {
                if (visitedCnt[n] == -1) {
                    queue.add(n);
                    visitedCnt[n] = visitedCnt[node] + 1;
                }
            }
        }
    }
}
