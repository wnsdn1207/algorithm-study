package own.junn.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1012 - 유기농배추
 */
public class Problem_1012 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;
    static int M;
    static int N;
    static int K;

    static boolean[][] map;
    static boolean[][] clonedMap;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int wormCount;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[M][N];

            for (int j=0; j<K; j++) {
                String[] tmp = reader.readLine().split(" ");

                int a = Integer.parseInt(tmp[0]);
                int b = Integer.parseInt(tmp[1]);

                map[a][b] = true;
            }

            wormCount = 0;
            clonedMap = map.clone();
            for (int j=0; j<clonedMap.length; j++) {
                for (int k=0; k<clonedMap[j].length; k++) {
                    if (clonedMap[j][k]) {
                        bfs(j, k);
                        wormCount++;
                    }
                }
            }
            System.out.println(wormCount);
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        clonedMap[x][y] = false;
        queue.add(new Point(x, y));

        while (queue.size()>0) {
            Point pos = queue.poll();

            for (int i=0; i<4; i++) {
                int ax = pos.x+dx[i];
                int ay = pos.y+dy[i];

                if (isValidRange(ax, ay) && clonedMap[ax][ay]) {
                    clonedMap[ax][ay] = false;
                    queue.add(new Point(ax, ay));
                }
            }
        }
    }

    static boolean isValidRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
