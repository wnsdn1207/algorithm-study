package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 14425 - 문자열 집합
 */
public class Problem_14425 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static HashSet<String> strings = new HashSet<>();

    public static void main(String[] args) throws Exception {
        String[] inputArr = reader.readLine().split(" ");

        N = Integer.parseInt(inputArr[0]);
        M = Integer.parseInt(inputArr[1]);

        for (int i=0; i<N; i++) {
            strings.add(reader.readLine());
        }

        int answer = 0;
        for (int i=0; i<M; i++) {
            if (strings.contains(reader.readLine())) answer++;
        }

        System.out.println(answer);
    }
}
