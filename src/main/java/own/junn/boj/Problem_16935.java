package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 16935 - 배열돌리기
 */
public class Problem_16935 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M, R;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(reader.readLine(), " ");

        int[][] tmpMap = map;
        for (int i=0; i<R; i++) {
            ArrayUtil util = new ArrayUtil(tmpMap);
            tmpMap = util.operation(Integer.parseInt(st.nextToken()));
        }

        printArray(tmpMap);

        reader.close();
    }

    static class ArrayUtil {
        int[][] array;

        ArrayUtil(int[][] array) {
            this.array = array;
        }

        private int[][] operation(int n) {
            switch (n) {
                case 1:
                    operate_1();
                    break;
                case 2:
                    operate_2();
                    break;
                case 3:
                    operate_3();
                    break;
                case 4:
                    operate_4();
                    break;
                case 5:
                    operate_5();
                    break;
                case 6:
                    operate_6();
                    break;
                default:
                    break;
            }

            return array;
        }
        private int[][] operate_1() {
            // 상하 반전
            System.out.println("One Operation");
            return array;
        }
        private int[][] operate_2() {
            // 좌우 반전
            System.out.println("Two Operation");
            return array;
        }
        private int[][] operate_3() {
            // 오른쪽으로 90도 회전
            System.out.println("Three Operation");
            return array;
        }
        private int[][] operate_4() {
            // 왼쪽으로 90도 회전
            System.out.println("Four Operation");
            return array;
        }
        private int[][] operate_5() {
            // N/2×M/2인 4개의 부분 배열로 나눠야 한다.
            /**
             * 12
             * 43
             *
             * 기준으로,
             * 1>2 이동
             * 2>3 이동
             * 3>4 이동
             * 4>1 이동
             */
            System.out.println("Five Operation");
            return array;
        }
        private int[][] operate_6() {
            // // N/2×M/2인 4개의 부분 배열로 나눠야 한다.
            /**
             * 12
             * 43
             *
             * 기준으로,
             * 1>4 이동
             * 4>3 이동
             * 3>2 이동
             * 2>1 이동
             */
            System.out.println("Six Operation");
            return array;
        }
    }

    static void printArray(int[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array[i].length; j++) {
                sb.append(array[i][j]).append(" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
        sb.setLength(0);
    }
}
