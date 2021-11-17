package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 2910 - 빈도 정렬
 */
public class p2910 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int C;

    static int[] numbers;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(reader.readLine(), " ");
        int max = Integer.MIN_VALUE;
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
            max = Math.max(max, map.get(numbers[i]));
        }

        StringBuilder sb = new StringBuilder();
        while (max > 0) {
            for (int i=0; i<N; i++) {
                if (numbers[i] == 0) continue;

                if (map.get(numbers[i]) == max) {
                    for (int j=0; j<max; j++) {
                        sb.append(numbers[i]).append(" ");
                    }
                    int complete = numbers[i];
                    for (int j=i+1; j<N; j++) {
                        if (numbers[j] == complete) {
                            numbers[j] = 0;
                        }
                    }
                }
            }
            max--;
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);

        reader.close();
    }
}
