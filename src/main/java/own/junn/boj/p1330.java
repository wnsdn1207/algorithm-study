package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1330 - 두 수 비교하기
 */
public class p1330 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int A, B;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        System.out.println(A > B ? ">" : A == B ? "==" : "<");

        reader.close();
    }
}
