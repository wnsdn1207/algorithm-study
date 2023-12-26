package own.junn.y2023.q4.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1010 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int count = Integer.parseInt(reader.readLine());

        StringTokenizer st;
        for (int i=0; i<count; i++) {
            st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 1) {
                System.out.println(m);
            }
            if (n == m) {
                System.out.println(1);
            }
            

        }

        reader.close();
    }
}
