package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 10546 - 배부른마라토너
 */
public class Problem_10546 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static HashMap<String, Integer> users = new HashMap<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        for (int i=0; i<N; i++) {
            String name = reader.readLine();
            users.put(name, users.getOrDefault(name, 0)+1);
        }

        for (int i=0; i<N-1; i++) {
            String name = reader.readLine();
            users.put(name, users.get(name) - 1);
        }

        for (String key : users.keySet()) {
            if (users.get(key) > 0) {
                System.out.println(key);
                break;
            }
        }
    }
}
