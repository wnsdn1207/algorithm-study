package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14490 - 백대열
 *
 * 유클리드 호제법 사용
 */
public class Problem_14490_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static final String COLON = ":";

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), COLON);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int s = gcd(n, m);
        System.out.println(n/s + COLON + m/s);
    }

    static int gcd(int n, int m) {
        if (m==0) return n;

        return gcd(m, n%m);
    }
}
