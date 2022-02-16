package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1065 - 한수
 */
public class p1065 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static boolean[] arr = new boolean[1001];

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        if (N < 100) {
            System.out.println(N);
            return;
        }

        for (int i=100; i<=N; i++) {
            arr[i] = check(i);
        }

        int count = 99;
        for (int i=100; i<=N; i++) {
            if (arr[i]) {
                count++;
            }
        }

        System.out.println(count);

        reader.close();
    }

    static boolean check(int n) {
        String tmp = String.valueOf(n);
        int diff = (tmp.charAt(0) - '0') - (tmp.charAt(1) - '0');

        for (int i=2; i<tmp.length(); i++) {
            int a = tmp.charAt(i-1) - '0';
            int b = tmp.charAt(i) - '0';

            int currDiff = a - b;
            if (diff != currDiff) {
                return false;
            }
        }

        return true;
    }
}
