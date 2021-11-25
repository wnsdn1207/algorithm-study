package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1120 - 문자열
 */
public class p1120 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static String A;
    static String B;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        A = st.nextToken();
        B = st.nextToken();

        if (B.contains(A)) {
            System.out.println("0");
        } else {
            if (B.charAt(0) == A.charAt(0)) {
                A = B.substring((B.length() - A.length()) - 1);
                System.out.println(A);
            } else if (B.charAt(B.length()-1) == A.charAt(A.length()-1)) {
                A = B.substring(0, B.length() - A.length()) + A;
                System.out.println(A);
            } else if (A.length() == B.length()) {
                System.out.println(A);
            } else {

            }
        }



        reader.close();
    }
}
