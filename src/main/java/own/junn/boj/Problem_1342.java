package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 1342 - 행운의 문자열
 */
public class Problem_1342 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static HashMap<String, Integer> map = new HashMap<>();

    static String[] stringArr;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    static int[] dp = new int[10000];
    static int answer;

    public static void main(String[] args) throws Exception {
        stringArr = reader.readLine().split("");

        for (int i=0; i<stringArr.length; i++) {
            String tmp = stringArr[i];
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        visited = new boolean[stringArr.length];
        for (int i=0; i<stringArr.length; i++) {
            sb.setLength(0);
            sb.append(stringArr[i]);
            visited[i] = true;
            backTracking(sb);
            visited[i] = false;
        }

        for (String key : map.keySet()) {
            int num = map.get(key);
            dp[0] = 1;
            for (int i = 1; i < num + 1; i++) {
                dp[i] = dp[i - 1] * i;
            }
            answer /= dp[num];
        }
        System.out.println(answer);

        reader.close();
    }

    static void backTracking(StringBuilder sb) {
        if (sb.length() == stringArr.length) {
            answer++;
            return;
        }

        for (int i=0; i<stringArr.length; i++) {
            if (!visited[i] && !sb.substring(sb.length()-1).equalsIgnoreCase(stringArr[i])) {
                visited[i] = true;
                backTracking(sb.append(stringArr[i]));
                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
            }
        }
    }
}
