package own.junn.y2022.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 7562 - 나이트의 이동
 */
public class Problem_7562 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int caseCount;

    static int len;

    static Point currPos;
    static Point desPos;

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    static int[][] posMap;

    public static void main(String[] args) throws Exception {
        caseCount = Integer.parseInt(reader.readLine());

        for (int i=0; i<caseCount; i++) {
            len = Integer.parseInt(reader.readLine());

            posMap = new int[len][len];
            for (int j=0; j<len; j++) {
                for (int k=0; k<len; k++) {
                    posMap[j][k] = -1;
                }
            }

            String[] tmp = reader.readLine().split(" ");
            currPos = new Point(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
            tmp = reader.readLine().split(" ");
            desPos = new Point(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));

            bfs();
            System.out.println(posMap[desPos.x][desPos.y]);
        }
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(currPos);
        posMap[currPos.x][currPos.y] = posMap[currPos.x][currPos.y] + 1;

        boolean isArrived = false;
        while (queue.size() > 0) {
            Point pos = queue.poll();

            int ax, ay;
            for (int i=0; i<8; i++) {
                ax = pos.x + dx[i];
                ay = pos.y + dy[i];

                if (isValidRange(ax, ay) && posMap[ax][ay] == -1) {
                    queue.add(new Point(ax, ay));
                    posMap[ax][ay] = posMap[pos.x][pos.y] + 1;

                    if (ax == desPos.x && ay == desPos.y) {
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

    static boolean isValidRange(int x, int y) {
        return x >= 0 && x < len && y >= 0 && y < len;
    }
}
