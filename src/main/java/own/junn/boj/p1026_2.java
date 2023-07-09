package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1026_2 {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;

    private static int[] A;

    private static int[] B;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        A = new int[N];
        B = new int[N];

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(reader.readLine(), " ");

        for (int i=0; i<N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);

        int result = 0;

        for (int i=0; i<N; i++) {
            result += (A[i] * B[N-1-i]);
        }

        System.out.println(result);

        reader.close();
    }
}
