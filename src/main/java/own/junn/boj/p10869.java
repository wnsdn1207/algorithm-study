package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10869 - 사칙연산
 */
public class p10869 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(N+M);
        System.out.println(N-M);
        System.out.println(N*M);
        System.out.println(N/M);
        System.out.println(N%M);

        reader.close();
    }
}
