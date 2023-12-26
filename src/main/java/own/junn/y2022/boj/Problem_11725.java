package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 11725 - 트리의 부모 찾기
 */
@SuppressWarnings("unchecked")
public class Problem_11725 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static ArrayList<Integer>[] array;
    static int[] parents;
    
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        array = new ArrayList[N];
        parents = new int[N];

        for (int i=0; i<N; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            array[a].add(b);
            array[b].add(a);
        }

        Arrays.fill(parents, -1);
        bfs(0);
        printParent();

        reader.close();
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        parents[x] = 0;
        queue.add(x);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            ArrayList<Integer> list = array[node];
            for (int i : list) {
                if (parents[i] == -1) {
                    parents[i] = node;
                    queue.add(i);
                }
            }
        }
    }

    static void printParent() {
        for (int i=1; i< parents.length; i++) {
            System.out.println(parents[i]+1);
        }
    }
}
