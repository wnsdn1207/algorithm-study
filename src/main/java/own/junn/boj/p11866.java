package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 11866 - 요새푸스 문제 0
 */
public class p11866 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int K;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i=1; i<N+1; i++) {
            queue.add(i);
        }

        while (true) {
            int start = queue.peek();
            if (start == N) {
                break;
            }
            queue.add(queue.remove());
        }

        queue.add(queue.remove());
        sb.append("<");
        while (queue.size() > 0) {
            for (int i=0; i<K-1; i++) {
                queue.add(queue.remove());
            }
            sb.append(queue.remove()).append(", ");
        }
        sb.setLength(sb.length()-2);
        sb.append(">");

        System.out.println(sb);

        reader.close();
    }
}
