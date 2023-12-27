package own.junn.y2023.q4.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @see "https://www.acmicpc.net/problem/1652"
 */
public class p1652 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(reader.readLine());

        int countOfHorizontal = 0;
        int countOfVertical = 0;

        String[][] room = new String[N][N];
        for (int i=0; i<N; i++) {
            String originalText = reader.readLine();
            room[i] = originalText.split("");
        }

        // 세로, 가로 누울 자리 동시 counting
        for (int i=0; i<N; i++) {
            int height = 0;
            int width = 0;
            for (int j=0; j<N; j++) {
                String horizontalPoint = room[i][j];
                String verticalPoint = room[j][i];

                // 누울 수 있는 좌표면 width 증가
                if (horizontalPoint.equals(".")) {
                    width++;
                }

                // 누울 수 있는 좌표면 height 증가
                if (verticalPoint.equals(".")) {
                    height++;
                }

                // 누울 수 있는 좌표거나 해당 열의 마지막 좌표라면 누울 수 있는 자리가 있는지 체크 후 counting
                // 이후 width 초기화
                if (horizontalPoint.equals("X") || j == N-1) {
                    if (width >= 2) {
                        countOfHorizontal++;
                    }
                    width = 0;
                }

                // 누울 수 있는 좌표거나 해당 열의 마지막 좌표라면 누울 수 있는 자리가 있는지 체크 후 counting
                // 이후 height 초기화
                if (verticalPoint.equals("X") || j == N-1) {
                    if (height >= 2) {
                        countOfVertical++;
                    }
                    height = 0;
                }
            }
        }

        System.out.println(countOfHorizontal + " " + countOfVertical);

        reader.close();
    }
}