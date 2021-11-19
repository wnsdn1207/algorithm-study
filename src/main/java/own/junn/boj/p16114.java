package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 16114 - 화살표연산자
 */
public class p16114 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int X;
    static int N;
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        X = toInt(st.nextToken());
        N = toInt(st.nextToken());

        if(N == 1) {
            if (X < 0) {
                System.out.println("INFINITE");
            } else {
                System.out.println("0");
            }
        } else if (N%2== 1) {
            System.out.println("ERROR");
        } else if (N == 0) {
            if (X > 0) {
                System.out.println("INFINITE");
            } else {
                System.out.println("0");
            }
        } else {
            if (X > 0) {
                int c = (X-1)/(N/2);
                System.out.println(c);
            } else {
                System.out.println(0);
            }
        }

        reader.close();
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
