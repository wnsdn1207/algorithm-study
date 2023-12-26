package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 16435 - 스네이크버드
 */
public class p16435 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int L;

    static int[] heights;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        heights = new int[N];

        st = new StringTokenizer(reader.readLine(), " ");
        for (int i=0; i<N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(heights);

        for (int i=0; i<N; i++) {
            if (heights[i] <= L) L++;
        }

        System.out.println(L);

        reader.close();
    }
}
