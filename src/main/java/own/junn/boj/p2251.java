package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2251 - 물통
 *
 * A, B, C(1≤A, B, C≤200)
 * 처음에는 앞의 두 물통은 비어 있고, 세 번째 물통은 가득(C 리터)
 *
 * 예제 입력 1
 * 8 9 10
 * 예제 출력 1
 * 1 2 8 9 10
 */
public class p2251 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int A, B, C;
    static boolean[][] visited = new boolean[201][201];
    static boolean[] answer = new boolean[201];
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dfs(0, 0, C);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<201; i++) {
            if (answer[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);

        reader.close();
    }

    static void dfs(int a, int b, int c) {
        // 중복 처리를 방지하기 위하여, 방문했던 곳은 처리하지 않음
        if (visited[a][b]) {
            return;
        }
        // 문제에서 a가 비어있을 때 c의 값들의 경우의 수를 찾는 것이었으므로, 해당 조건 명시
        if (a == 0) {
            answer[c] = true;
        }

        // 방문 체크
        visited[a][b] = true;

        /**
         * 물을 따르는 경우의 수는 6가지 (A-B, A-C, B-A, B-C, C-A, C-B)
         * 해당 경우의 수에 따라 처리해준다.
         *
         * 담겨있는 물과 따를 물의 합이 담을 물통의 부피보다 클 경우,
         * 담을 물통은 최대 부피로 세팅
         * 따른 물통은 담겨있는 물과 따를 물의 합에서 최대 부피를 뺀 만큼 세팅
         *
         * C에만 물이 가득차있으므로,
         * A 또는 B 물통에서 C로 따르는 경우에는 C 물통이 넘치는 경우를 고려하지 않아도 된다.
         */
        // A to B
        if (a + b > B) {
            dfs((a + b) - B, B, c);
        } else {
            dfs(0, a+b, c);
        }

        // B to A
        if (b + a > A) {
            dfs(A, (b + a) - A, c);
        } else {
            dfs(b+a, 0, c);
        }

        // C to A
        if (c + a > A) {
            dfs(A, b, (c + a) - A);
        } else {
            dfs(c+a, b, 0);
        }

        // C to B
        if (c + b > B) {
            dfs(a, B, (c + b) - B);
        } else {
            dfs(a, c+b, 0);
        }

        // A to C
        dfs(0, b, a+c);
        // B to C
        dfs(a, 0, b+c);
    }
}
