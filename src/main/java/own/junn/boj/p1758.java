package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1758 - 알바생강호
 */
public class p1758 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] tips;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        tips = new int[N];

        for (int i=0; i<N; i++) {
            tips[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(tips);

        long result = 0;
        int stan = N-1;
        for (int i=0; i<N; i++) {
            int r = (tips[stan--] - ((i+1)-1));
            if (r > 0) {
                result += r;
            }
        }

        System.out.println(result);

        reader.close();
    }
}
