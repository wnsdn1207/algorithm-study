package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1759 - 암호만들기
 */
public class Problem_1759 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int L;
    static int C;

    static String[] arr;
    static boolean[] visited;

    static HashSet<String> passwordSet = new HashSet<>();
    static ArrayList<String> passwordList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = reader.readLine().split(" ");
        visited = new boolean[C];

        Arrays.sort(arr);
        backTracking(0, 0);

        passwordList.addAll(passwordSet);
        Collections.sort(passwordList);

        for (String s : passwordList) {
            System.out.println(s);
        }

        reader.close();
    }

    static void backTracking(int start, int depth) {
        if (depth == 4) {
            addPassword();
            return;
        }

        for (int i=start; i<C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(start+1, depth+1);
                visited[i] = false;
            }
        }
    }

    static void addPassword() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            if (visited[i]) {
                sb.append(arr[i]);
            }
        }

        passwordSet.add(sb.toString());
        sb.setLength(0);
    }
}
