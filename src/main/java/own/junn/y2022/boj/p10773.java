package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 10773 - 제로
 */
public class p10773 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> stack = new Stack<>();
    static int K;
    public static void main(String[] args) throws Exception{
        K = Integer.parseInt(reader.readLine());

        for (int i=0; i<K; i++) {
            int n = Integer.parseInt(reader.readLine());

            if (n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            int result = 0;
            for (int i : stack) {
                result += i;
            }
            System.out.println(result);
        }

        reader.close();

    }
}
