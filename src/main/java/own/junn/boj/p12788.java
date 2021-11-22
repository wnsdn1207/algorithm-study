package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 12788 - 제 2회 IUPC
 *
 * 7
 * 36 3
 * 9 70 15 13 19 20 11
 */
public class p12788 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int K;

    static int[] pens;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(reader.readLine());
        pens = new int[N];

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine(), " ");
        for (int i=0; i<N; i++) {
            pens[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pens);

        int total = M*K;
        int count = 0;
        for (int i=pens.length-1; i>=0; i--) {
            total -= pens[i];
            count++;
            if (total <= 0) {
                System.out.println(count);
                System.exit(0);
            }
        }

        System.out.println("STRESS");

        reader.close();
    }
}
