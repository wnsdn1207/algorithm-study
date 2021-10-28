package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 19941 - 햄버거분배
 */
public class Problem_19941_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int K;

    public static void main(String[] args) throws Exception {
        String[] inputs = reader.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);

        char[] arr = reader.readLine().toCharArray();

        int eatingCount = 0;
        for (int i=0; i<N; i++){
            if (arr[i] == 'P') {
                for (int j=i-K; j<=i+K; j++) {
                    if (j >= 0 && j < N && j != i) {
                        if (arr[j] == 'H') {
                            arr[j] = '.';
                            eatingCount++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(eatingCount);
    }
}
