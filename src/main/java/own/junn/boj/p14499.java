package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 14499 - 주사위 굴리기
 *
 * 세로 크기 N, 가로 크기 M (1 ≤ N, M ≤ 20)
 * 주사위를 놓은 곳의 좌표 x, y(0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1)
 * 명령의 개수 K (1 ≤ K ≤ 1,000)
 * 지도의 각 칸에 쓰여 있는 수는 10 미만의 자연수 또는 0이다.
 *
 * 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
 *
 * 예제 입력 1
 * 4 2 0 0 8
 * 0 2
 * 3 4
 * 5 6
 * 7 8
 * 4 4 4 1 3 3 3 2
 * 예제 출력 1
 * 0
 * 0
 * 3
 * 0
 * 0
 * 8
 * 6
 * 3
 *
 * 예제 입력 2
 * 3 3 1 1 9
 * 1 2 3
 * 4 0 5
 * 6 7 8
 * 1 3 2 2 4 4 1 1 3
 * 예제 출력 2
 * 0
 * 0
 * 0
 * 3
 * 0
 * 1
 * 0
 * 6
 * 0
 *
 * 예제 입력 3
 * 2 2 0 0 16
 * 0 2
 * 3 4
 * 4 4 4 4 1 1 1 1 3 3 3 3 2 2 2 2
 * 예제 출력 3
 * 0
 * 0
 * 0
 * 0
 *
 * 예제 입력 4
 * 3 3 0 0 16
 * 0 1 2
 * 3 4 5
 * 6 7 8
 * 4 4 1 1 3 3 2 2 4 4 1 1 3 3 2 2
 * 예제 출력 4
 * 0
 * 0
 * 0
 * 6
 * 0
 * 8
 * 0
 * 2
 * 0
 * 8
 * 0
 * 2
 * 0
 * 8
 * 0
 * 2
 */
public class p14499 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M, T;
    static int x, y;

    static int[][] map;
    // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
    static int[] dx = {0, 0, 0, -1, 1}, dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(reader.readLine());

        Dice dice = new Dice();
        int ax=x, ay=y;
        for (int i=0; i<T; i++) {
            int direction = Integer.parseInt(st.nextToken());

            ax += dx[direction];
            ay += dy[direction];

//            System.out.printf("ax : %d, ay : %d\n", ax, ay);
//            System.out.printf("map : %d\n", map[ax][ay]);

            if (!validRange(ax, ay)) {
                ax -= dx[direction];
                ay -= dy[direction];

                continue;
            }

//            System.out.println("Before : "+ dice);
            System.out.println(dice.move(direction, map[ax][ay]));
            if (map[ax][ay] > 0)
                map[ax][ay] = 0;
//            System.out.println("After : "+ dice);
//            System.out.println("######################################################");
        }

        reader.close();
    }

    static boolean validRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static class Dice {
        int front;
        int back;
        int top;
        int bottom;
        int left;
        int right;

        public Dice() {
            this.front = 0;
            this.back = 0;
            this.top = 0;
            this.bottom = 0;
            this.left = 0;
            this.right = 0;
        }

        int move(int direction, int ground) {
            int pTop=top, pRight=right, pBottom=bottom, pLeft=left, pFront=front, pBack=back;
            if (Direction.EAST.equals(Direction.find(direction))) {
                if (ground > 0) pRight = ground;

                top = pLeft;
                left = pBottom;
                bottom = pRight;
                right = pTop;
            } else if (Direction.WEST.equals(Direction.find(direction))) {
                if (ground > 0) pLeft = ground;

                top = pRight;
                left = pTop;
                bottom = pLeft;
                right = pBottom;
            } else if (Direction.SOUTH.equals(Direction.find(direction))) {
                if (ground > 0) pFront = ground;

                front = pTop;
                top = pBack;
                back = pBottom;
                bottom = pFront;
            } else if (Direction.NORTH.equals(Direction.find(direction))){
                if (ground > 0) pBack = ground;

                front = pBottom;
                top = pFront;
                back = pTop;
                bottom = pBack;
            }

            return top;
        }

        enum Direction {
            EAST(1),
            WEST(2),
            NORTH(3),
            SOUTH(4);

            int direction;

            Direction(int direction) {
                this.direction = direction;
            }

            static Direction find(int direction) {
                return Arrays.stream(values())
                        .filter(e -> e.direction == direction)
                        .findAny()
                        .orElseGet(() -> Direction.EAST);
            }
        }

        @Override
        public String toString() {
            return "Dice{" +
                    "front=" + front +
                    ", back=" + back +
                    ", top=" + top +
                    ", bottom=" + bottom +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
