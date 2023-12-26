package own.junn.y2022.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 13565 - 침투
 */
public class Problem_13565 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int M;
    static int N;
    static boolean[][] material;
    static boolean[][] visited;

    static boolean isArrived = false;

    public static void main(String[] args) throws Exception {
        String[] inputArr = reader.readLine().split(" ");

        M = Integer.parseInt(inputArr[0]);
        N = Integer.parseInt(inputArr[1]);

        material = new boolean[M][N];

        for (int i=0; i<M; i++) {
            char[] tmp = reader.readLine().toCharArray();
            for (int j=0; j<N; j++) {
                material[i][j] = tmp[j] == '0';
            }
        }

        for (int i=0; i<N; i++) {
            if (!isArrived && material[0][i]) {
                visited = material.clone();
                bfs(0, i);
            }
        }

        System.out.println(isArrived ? "YES" : "NO");
    }

    static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        visited[i][j] = false;
        queue.add(new Point(i, j));

        // 방향 배열
        int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
        while (queue.size() > 0) {
            Point node = queue.poll();
            int x = node.x;
            int y = node.y;

            for (int k=0; k<4; k++) {
                int ax = x+dx[k];
                int ay = y+dy[k];

                if (isValidRange(ax, ay) && visited[ax][ay]) {
                    queue.add(new Point(ax, ay));
                    visited[ax][ay] = false;

                    if (ax == M-1) {
                        isArrived = true;
                        return;
                    }
                }
            }
        }
    }

    static boolean isValidRange(int x, int y) {
        return (x >= 0 && x < M) && (y >= 0 && y < N);
    }
}
