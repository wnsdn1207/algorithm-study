package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1822 - 차집합
 */
public class p1822 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int A;
    static int B;

    static HashSet<Integer> numbersA = new HashSet<>();
    static HashSet<Integer> numbersB = new HashSet<>();
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < A; i++) {
            int n = Integer.parseInt(st.nextToken());
            numbersA.add(n);
        }

        st = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < B; i++) {
            int n = Integer.parseInt(st.nextToken());
            numbersB.add(n);
        }

        int count = 0;
        for (int n : numbersA) {
            if (!numbersB.contains(n)) {
                answer.add(n);
                count++;
            }
        }

        System.out.println(count);
        if (count == 0) {
            return;
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int n : answer) {
            sb.append(n).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);

        sb.setLength(0);
        reader.close();
    }
}
