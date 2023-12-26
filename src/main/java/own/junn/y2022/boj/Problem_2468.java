package own.junn.y2022.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2468 - 안전 영역
 */
public class Problem_2468 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[][] map;

    static int[][] clonedMap;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        map = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<100; i++) {
            clonedMap = new int[N][N];
            for (int j=0; j<N; j++) {
                System.arraycopy(map[j], 0, clonedMap[j], 0, N);
            }

            int landCnt = 0;
            for (int j=0; j<N; j++) {
                for (int k=0; k<N; k++) {
                    if (clonedMap[j][k] - i > 0) {
                        bfs(i, j, k);
                        landCnt++;
                    }
                }
            }
            if (landCnt == 0) {
                break;
            }
            maxHeap.add(landCnt);
        }
        System.out.println(maxHeap.poll());
    }

    static void bfs(int height, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        clonedMap[x][y] = 0;
        queue.add(new Point(x, y));

        while (queue.size() > 0) {
            Point pos = queue.poll();

            int ax, ay;
            for (int i=0; i<4; i++) {
                ax = pos.x + dx[i];
                ay = pos.y + dy[i];

                if (isValidRange(ax, ay) && clonedMap[ax][ay]-height > 0) {
                    clonedMap[ax][ay] = 0;
                    queue.add(new Point(ax, ay));
                }
            }
        }
    }

    static boolean isValidRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
