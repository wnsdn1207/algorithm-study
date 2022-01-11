package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 16956 - 늑대와 양
 *
 * '.'는 빈 칸, 'S'는 양, 'W'는 늑대, 울타리는 'D'로 출력
 * 1 ≤ R, C ≤ 500
 *
 * 예제 입력 1
 * 6 6
 * ..S...
 * ..S.W.
 * .S....
 * ..W...
 * ...W..
 * ......
 * 예제 출력 1
 * 1
 * ..SD..
 * ..SDW.
 * .SD...
 * .DW...
 * DD.W..
 * ......
 *
 * 예제 입력 2
 * 1 2
 * SW
 * 예제 출력 2
 * 0
 *
 * 예제 입력 3
 * 5 5
 * .S...
 * ...S.
 * S....
 * ...S.
 * .S...
 * 예제 출력 3
 * 1
 * .S...
 * ...S.
 * S.D..
 * ...S.
 * .S...
 *
 */
public class p16956 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int R, C;
    static char[][] map;

    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i=0; i<R; i++) {
            map[i] = reader.readLine().toCharArray();
        }

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (map[i][j] == 'W') {
                    // 늑대의 사방을 울타리로 감싼다.
                    buildFences(i, j);
                } else if (map[i][j] == 'S' && isContactedWithWolf(i, j)) {
                    // 양이면서, 사방 중에 늑대가 존재할 경우 0 출력과 함께 프로그램을 종료시킨다.
                    System.out.println(0);
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append("1").append("\n");
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

        reader.close();
    }

    static void buildFences(int x, int y) {
        for (int i=0; i<4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            // 울타리는 맨 땅일 경우에만 친다.
            if (validRange(ax, ay) && map[ax][ay] == '.') {
                map[ax][ay] = 'D';
            }
        }
    }

    static boolean isContactedWithWolf(int x, int y) {
        for (int i=0; i<4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            // 사방 중 한 곳에 늑대가 존재한다면, 참을 반환
            if (validRange(ax, ay) && map[ax][ay] == 'W') {
                return true;
            }
        }

        return false;
    }

    static boolean validRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
