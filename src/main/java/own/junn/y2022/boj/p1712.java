package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1712 - 손익분기점
 */
public class p1712 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static long A, B, C;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if (B >= C) {
            System.out.println(-1);
            return;
        }

        System.out.println((A/(C-B))+1);

        reader.close();
    }
}
