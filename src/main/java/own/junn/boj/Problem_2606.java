package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2606 - 바이러스
 */
public class Problem_2606 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int comCount;
    static int connCount;

    static ArrayList<Integer>[] array;
    static boolean[] connected;
    static int corruptedCount;

    public static void main(String[] args) throws Exception {
        comCount = Integer.parseInt(reader.readLine());
        connCount = Integer.parseInt(reader.readLine());

        array = new ArrayList[comCount];
        connected = new boolean[comCount];

        for (int i=0; i<comCount; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i=0; i<connCount; i++) {
            String[] tmp = reader.readLine().split(" ");

            int a = Integer.parseInt(tmp[0])-1;
            int b = Integer.parseInt(tmp[1])-1;

            array[a].add(b);
            array[b].add(a);
        }

        bfs();
        System.out.println(corruptedCount);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        connected[0] = true;
        queue.add(0);

        while (queue.size()>0) {
            int node = queue.poll();

            ArrayList<Integer> list = array[node];
            for (int n : list) {
                if (!connected[n]) {
                    connected[n] = true;
                    queue.add(n);
                    corruptedCount++;
                }
            }
        }
    }
}
