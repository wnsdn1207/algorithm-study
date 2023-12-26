package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 16922 - 로마숫자 만들기
 */
public class p16922 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static boolean[] visited = new boolean[1001];
    static int[] numbers = {1, 5, 10, 50};
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        backTracking(0, 0, 0);
        int result = 0;
        for (boolean v : visited) {
            if (v) result++;
        }
        System.out.println(result);

        reader.close();
    }

    static void backTracking(int depth, int idx, int result) {
        if (depth == N) {
            if (visited[result]) return;

            visited[result] = true;
            return;
        }

        for (int i=idx; i<4; i++) {
            backTracking(depth+1, i, result+numbers[i]);
        }
    }
}
