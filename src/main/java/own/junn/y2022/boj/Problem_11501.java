package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11501 - 주식
 *
 * 이 문제의 핵심은 loop문을 반대로 순회시키는 것에 있다.
 * 주식의 수익금을 구하는 문제이므로,
 * max값보다 가변값이 클 경우 max값에 세팅, max값보다 작을 경우 차액을 더해주는 형식으로 풀어야 한다.
 */
public class Problem_11501 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        long[] cases = new long[T];
        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(reader.readLine());

            long[] arr = new long[N];
            long max = 0;
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            for (int j=0; j<N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j=N-1; j>=0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                } else {
                    cases[i] += (max - arr[j]);
                }
            }
        }

        for (long i : cases) {
            System.out.println(i);
        }

        reader.close();
    }
}
