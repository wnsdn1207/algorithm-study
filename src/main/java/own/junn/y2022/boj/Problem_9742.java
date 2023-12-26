package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 9742 - 순열
 */
public class Problem_9742 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static String[] words;
    static boolean[] visited;
    static String[] output;

    static int idx;
    static int cnt;

    static String clause;
    static boolean isPrinted = false;

    public static void main(String[] args) throws Exception {
        String input;
        while ((input = reader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input, " ");
            clause = input;

            words = st.nextToken().split("");
            idx = Integer.parseInt(st.nextToken());
            visited = new boolean[words.length];
            output = new String[words.length];
            cnt = 0;
            isPrinted = false;

            permutation(0, words.length, words.length);
            if (!isPrinted) {
                System.out.println(clause + " = No Permutation");
            }
        }

        reader.close();
    }

    static void permutation(int depth, int n, int r) {
        if (depth == r) {
            print();
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = words[i];
                permutation(depth+1, n, r);
                visited[i] = false;
            }
        }
    }

    static void print() {
        if (++cnt == idx) {
            System.out.print(clause + " = ");
            for (int i=0; i< words.length; i++) {
                if (visited[i]) {
                    System.out.print(output[i]);
                }
            }
            System.out.println();
            isPrinted = true;
        }
    }
}
