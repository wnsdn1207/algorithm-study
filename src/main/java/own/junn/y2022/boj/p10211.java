package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10211 - Maximum Subarray
 */
public class p10211 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;
    static int N;
    static int[] array;
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(reader.readLine());
            array = new int[N];

            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            boolean hasMinus = false;
            for (int i=0; i<N; i++) {
                int n = Integer.parseInt(st.nextToken());
                array[i] = n;
                if (n < 0) {
                    hasMinus = true;
                }
            }

            if (hasMinus) {
                int beginIdx = 0;
                int maximum = Integer.MIN_VALUE;
                while (beginIdx < N) {
                    int sum = 0;
                    for (int i=beginIdx; i<N; i++) {
                        sum += array[i];
                        if (maximum < sum) {
                            maximum = sum;
                        }
                    }
                    beginIdx++;
                }
                System.out.println(maximum);
            } else {
                System.out.println(sum(array));
            }
        }

        reader.close();
    }

    static int sum(int[] array) {
        int result = 0;
        for (int i : array) {
            result += i;
        }
        return result;
    }
}
