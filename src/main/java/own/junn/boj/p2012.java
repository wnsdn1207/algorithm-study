package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2012 - 등수매기기
 */
public class p2012 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static long[] numbers;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        numbers = new long[N+1];

        for (int i=1; i<=N; i++) {
            numbers[i] = Long.parseLong(reader.readLine());
        }

        Arrays.sort(numbers);

        long sum = 0;
        for (int i=1; i<=N; i++) {
            sum += Math.abs(i - numbers[i]);
        }

        System.out.println(sum);
//        System.out.println(Arrays.toString(numbers));

        reader.close();
    }
}
