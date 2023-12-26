package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p1269_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static int[] A;
    static int[] B;

    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(reader.readLine(), " ");
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }

        st = new StringTokenizer(reader.readLine(), " ");
        for (int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }

        int result = set.size() * 2 - N - M;
        System.out.println(result);

        reader.close();
    }
}
