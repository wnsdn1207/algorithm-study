package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 20291 - 파일 정리
 */
public class p20291 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static HashMap<String, Integer> map = new HashMap<>();
    static String[] answers;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        for (int i=0; i<N; i++) {
            String[] input = reader.readLine().split("\\.");
            map.put(input[1], map.getOrDefault(input[1], 0) + 1);
        }

        answers = new String[map.keySet().size()];
        int idx = 0;
        for (String key : map.keySet()) {
            answers[idx++] = key + " " + map.get(key);
        }
        Arrays.sort(answers);

        for (String s : answers) {
            System.out.println(s);
        }

        reader.close();
    }
}
