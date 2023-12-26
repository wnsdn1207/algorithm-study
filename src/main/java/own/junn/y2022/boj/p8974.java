package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 8974 - 희주의 수학시험
 */
public class p8974 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int A;
    static int B;

    static int[] numbers = new int[1001];
    public static void main(String[] args) throws Exception {
        String[] tmp = reader.readLine().split(" ");

        A = Integer.parseInt(tmp[0]);
        B = Integer.parseInt(tmp[1]);

        int idx = 1;
        int stan = 1;
        boolean isComplete = false;
        while (idx < 1000) {
            for (int i=1; i<stan+1; i++) {
                numbers[idx++] = stan;
                if (idx == 1001) {
                    isComplete = true;
                    break;
                }
            }
            if (isComplete) break;

            stan++;
        }

        int result = 0;
        for (int i=A; i<=B; i++) {
            result += numbers[i];
        }

        System.out.println(result);

        reader.close();
    }
}
