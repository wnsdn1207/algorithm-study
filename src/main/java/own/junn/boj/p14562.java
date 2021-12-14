package own.junn.boj;

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

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            Arrays.fill(visited, 300);

            int answer = bfs();
            System.out.println(answer);
        }

        reader.close();
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(A, B, 0));

        while (!queue.isEmpty()) {
            Point node = queue.poll();

            if (node.x == node.y) {
                return node.depth;
            }

            int aa, ab;
            aa = node.x * 2;
            ab = node.y + 3;

            if (aa <= ab) {
                queue.add(new Point(aa, ab, node.depth + 1));
            }

            aa = node.x + 1;
            ab = node.y;
            queue.add(new Point(aa, ab, node.depth + 1));
        }

        return 0;
    }

    static class Point {
        int x;
        int y;
        int depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
