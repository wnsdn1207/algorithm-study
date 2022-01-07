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

    static StringBuilder sb = new StringBuilder();

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

        // 주사위 객체
        Dice dice = new Dice();
        int ax=x, ay=y;
        for (int i=0; i<T; i++) {
            int direction = Integer.parseInt(st.nextToken());

            // ax와 ay에 초기 위치를 설정해주고, 해당 위치를 입력된 명령어 수만큼 계속해서 갱신한다.
            ax += dx[direction];
            ay += dy[direction];

            // 갱신한 값의 범위를 체크하여 map의 범위를 벗어날 경우, 다시 ax와 ay를 이전으로 복구하고 다음 명령을 수행한다.
            if (!validRange(ax, ay)) {
                ax -= dx[direction];
                ay -= dy[direction];

                continue;
            }

            // dice.move() 메소드를 통해 주사위의 윗면의 값을 반환받는다.
            sb.append(dice.move(direction, map[ax][ay])).append("\n");
            if (map[ax][ay] > 0) {
                map[ax][ay] = 0;
            } else if (map[ax][ay] == 0) {
                map[ax][ay] = dice.bottom;
            }
        }

        System.out.println(sb);

        reader.close();
    }

    /**
     * x위치와 y위치의 범위를 체크하여 정상 범위인지 체크해주는 Method
     *
     * @param x x index value
     * @param y y index value
     * @return x와 y 모두 정상 범위일 경우 true, 아닐 경우 false
     */
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

        /**
         * 인자로 들어온 direction 방향으로 주사위를 굴리고, 그 때의 주사위의 각 면의 값들을 갱신시켜주는 Method
         *
         * @param direction 방향 Index
         * @param ground 이동할 위치의 바닥에 적힌 숫자
         * @return 이동이 완료된 주사위의 윗면에 적힌 값
         */
        int move(int direction, int ground) {
            int pTop=top, pRight=right, pBottom=bottom, pLeft=left, pFront=front, pBack=back;
            if (Direction.EAST.equals(Direction.find(direction))) {
                // 바닥에 적힌 숫자값이 0보다 클 경우에만 바닥이 될 면의 값으로 세팅한다.
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

        /**
         * 위치를 나타내는 Enum Class
         */
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
