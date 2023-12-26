package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10998 - AxB
 */
public class p10998 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        System.out.println(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));

        reader.close();
    }
}
