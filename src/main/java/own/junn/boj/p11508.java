package own.junn.boj;

import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 11508 - 2+1 세일
 */
public class p11508 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] products;
    static final int MAX = (int) (2e31 - 1);
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        products = new int[N];

        for (int i=0; i<N; i++) {
            products[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(products);

        int ans = N/3;
        int mod = N%3;

        int sum = 0;
        for (int i=ans-1; i>=0; i--) {
            for (int j=2; j>=0; j--) {
                if (j==0) break;

                sum += products[3*i+j+mod];
            }
        }

        while (mod > 0) {
            sum += products[--mod];
        }

        System.out.println(Math.min(MAX, sum));

        reader.close();
    }

}
