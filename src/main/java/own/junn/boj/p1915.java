package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1915 - 가장 큰 정사각형
 *
 * 예제 입력 1
 * 4 4
 * 0100
 * 0111
 * 1110
 * 0010
 * 예제 출력 1
 * 4
 */
public class p1915 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        int result = 0;
        for (int i=0; i<N; i++) {
            char[] tmp = reader.readLine().toCharArray();

            for (int j=0; j<M; j++) {
                map[i][j] = tmp[j] == '0' ? 0 : 1;

                // 해당하는 x, y좌표가 0보다 크면서 1일 때만 해당 좌표의 map 값을 왼쪽, 위쪽, 왼위쪽의 값들 중 가작 작은 값 + 1의 값을 세팅하여 준다.
                // 왼쪽위부터 오른쪽아래로 차례대로 내려가는 반복문의 특성을 이용하여
                // 각 값을 세팅해줌과 동시에 왼쪽, 위쪽, 왼위쪽을 바로 체크하여도 문제가 되지 않는다.
                if (i>0 && j>0 && map[i][j] == 1) {
                    map[i][j] = min(map[i-1][j], map[i][j-1], map[i-1][j-1]) + 1;
                }
                // x좌표 또는 y좌표가 1보다 작지만, 해당 좌표의 값은 1인 경우를 대비하여 변의 값은 매번 최대값으로 세팅하여 준다.
                // (ex) (0,0)=1, (0,1)=0, (1,0)=0, (1,1)=0
                result = Math.max(result, map[i][j]);
            }
        }

        // 너비를 구하는 문제이므로, 최대값으로 세팅된 result(변의길이) 값을 제곱하여 준다.
        System.out.println(result*result);

        reader.close();
    }

    static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
