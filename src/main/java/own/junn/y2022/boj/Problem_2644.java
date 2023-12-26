package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2644 - 촌수 계산
 */
public class Problem_2644 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int m;

    static int per_1;
    static int per_2;

    static ArrayList<Integer>[] array;
    static int[] visited;

    static boolean isArrived;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(reader.readLine());

        String[] inputs = reader.readLine().split(" ");

        per_1 = Integer.parseInt(inputs[0]) - 1;
        per_2 = Integer.parseInt(inputs[1]) - 1;

        m = Integer.parseInt(reader.readLine());

        array = new ArrayList[n];
        visited = new int[n];

        for (int i=0; i<n; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            inputs = reader.readLine().split(" ");

            int x = Integer.parseInt(inputs[0]) - 1;
            int y = Integer.parseInt(inputs[1]) - 1;

            array[x].add(y);
            array[y].add(x);
        }

        Arrays.fill(visited, -1);
        bfs();
        System.out.println(visited[per_2]);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(per_1);
        visited[per_1] = visited[per_1] + 1;

        while (queue.size() > 0) {
            int per = queue.poll();

            ArrayList<Integer> list = array[per];

            for (int p : list) {
                if (visited[p] == -1) {
                    queue.add(p);
                    visited[p] = visited[per] + 1;

                    if (p == per_2) {
                        isArrived = true;
                        break;
                    }
                }
            }

            if (isArrived) {
                break;
            }
        }
    }
}
