package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1026 - 보물
 */
public class p1026 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static int[] A;
    static int[] B;

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

//        System.out.println(Arrays.toString(A));
//        System.out.println(Arrays.toString(B));

        int result = 0;
        for (int i=0; i<N; i++) {
            // A 배열과 B 배열을 선정렬
            // A의 element 중 가장 큰 값과 B의 element의 가장 작은 값을 곱하고 더했을 때, 가장 작은 값을 도출해낼 수 있음
            result += (A[i] * B[N-1-i]);
        }

        System.out.println(result);

        reader.close();
    }
}
