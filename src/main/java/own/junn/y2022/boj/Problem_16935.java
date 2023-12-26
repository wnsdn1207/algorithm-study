package own.junn.y2022.boj;

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
            int length = array.length;

            for (int i=0; i<length/2; i++) {
                for (int j=0; j<array[i].length; j++) {
                    int idx = length-1;

                    int tmp = array[i][j];
                    array[i][j] = array[idx-i][j];
                    array[idx-i][j] = tmp;
                }
            }
            return array;
        }
        private int[][] operate_2() {
            // 좌우 반전
            int length = array[0].length;

            for (int i=0; i<array.length; i++) {
                for (int j=0; j<length/2; j++) {
                    int idx = length - 1;

                    int tmp = array[i][j];
                    array[i][j] = array[i][idx-j];
                    array[i][idx-j] = tmp;
                }
            }
            return array;
        }
        private int[][] operate_3() {
            // 오른쪽으로 90도 회전
            int[][] rotateToRight = new int[array[0].length][array.length];

            for (int i=0; i< rotateToRight.length; i++) {
                for (int j=0; j<rotateToRight[i].length; j++) {
                    rotateToRight[i][j] = array[array.length-1-j][i];
                }
            }

            array = rotateToRight;
            return array;
        }
        private int[][] operate_4() {
            // 왼쪽으로 90도 회전
            int[][] rotateToLeft = new int[array[0].length][array.length];

            for (int i=0; i< rotateToLeft.length; i++) {
                for (int j=0; j<rotateToLeft[i].length; j++) {
                    rotateToLeft[i][j] = array[j][array[j].length-1-i];
                }
            }

            array = rotateToLeft;
            return array;
        }
        private int[][] operate_5() {
            // 4사분면 형태로 분할 -> 각 사분면끼리의 교환
            // 1>2>3>4>1 이동
            int height = array.length/2;
            int width = array[0].length/2;

            // 너비의 반에 해당하는 위치의 세로 절반 선을 기준으로 좌우 위치 교환
            for (int i=0; i<array.length; i++) {
                for (int j=0; j<width; j++) {
                    int tmp = array[i][j];
                    array[i][j] = array[i][j+width];
                    array[i][j+width] = tmp;
                }
            }

            // 1사분면과 3사분면 간의 위치 교환
            for (int i=0; i<height; i++) {
                for (int j=0; j<width; j++) {
                    int tmp = array[i][j];
                    array[i][j] = array[i+height][j+width];
                    array[i+height][j+width] = tmp;
                }
            }

            return array;
        }
        private int[][] operate_6() {
            // 4사분면 형태로 분할 -> 각 사분면끼리의 교환
            // 1>4>3>2>1
            int height = array.length/2;
            int width = array[0].length/2;

            // 높이의 반에 해당하는 위치의 가로 절반 선을 기준으로 상하 위치 교환
            for (int i=0; i<height; i++) {
                for (int j=0; j<array[0].length; j++) {
                    int tmp = array[i][j];
                    array[i][j] = array[i+height][j];
                    array[i+height][j] = tmp;
                }
            }

            // 1사분면과 3사분면 간의 위치 교환
            for (int i=0; i<height; i++) {
                for (int j=0; j<width; j++) {
                    int tmp = array[i][j];
                    array[i][j] = array[i+height][j+width];
                    array[i+height][j+width] = tmp;
                }
            }

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
