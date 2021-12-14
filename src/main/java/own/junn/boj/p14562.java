package own.junn.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 14562 - 태권왕
 */
public class p14562 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;

    static int A;
    static int B;

    static int[] visited = new int[200];
    static int answer;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            Arrays.fill(visited, -1);

            bfs();
            System.out.println(visited[A]);
        }

        reader.close();
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(A, B));
        visited[A] = 0;

        while (!queue.isEmpty()) {
            Point node = queue.poll();

            if (node.x == node.y) {
                A = node.x;
                B = node.y;
                break;
            }

            for (int i=0; i<2; i++) {
                int aa, ab;
                if (i == 0) {
                    aa = node.x * 2;
                    ab = node.y + 3;
                } else {
                    aa = node.x + 1;
                    ab = node.y;
                }

                if (aa <= ab && visited[aa] == -1) {
                    visited[aa] = visited[node.x] + 1;
                    queue.add(new Point(aa, ab));
                }
            }
        }
    }
}
