package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 2493 - 탑
 */
public class p2493 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] tops;
    static int[] indexes;
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> indexStack = new Stack<>();
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        tops = new int[N];
        indexes = new int[N];

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        for (int i=0; i<N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        int idx = N;

        while (idx-- > 0) {
            while (!stack.isEmpty()) {
                int n = stack.peek();

                if (n < tops[idx]) {
                    stack.pop();
                    indexes[indexStack.pop()] = idx+1;
                } else {
                    break;
                }
            }
            stack.add(tops[idx]);
            indexStack.add(idx);
        }

        StringBuilder sb = new StringBuilder();
        for (int n : indexes) {
            sb.append(n).append(" ");
        }

        System.out.println(sb);

        reader.close();
    }
}
