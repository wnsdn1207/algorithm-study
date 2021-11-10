package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1978_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        int answer = 0;
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        for (int i=0; i<N; i++) {
            if (isPrime(Integer.parseInt(st.nextToken()))) {
                answer++;
            }
        }

        System.out.println(answer);

        reader.close();
    }

    static boolean isPrime(int x) {
        if (x <= 1) return false;
        int end = (int) Math.sqrt(x);
        for (int i=2; i<end+1; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}
