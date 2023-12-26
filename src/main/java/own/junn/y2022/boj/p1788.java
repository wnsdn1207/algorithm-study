package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1788 - 피보나치 수의 확장
 */
public class p1788 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] positive = new int[1000001];
    static int[] negative = new int[1000001];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(reader.readLine());

        positive[0] = 0;
        positive[1] = 1;

        negative[0] = 0;
        negative[1] = 1;

        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
        } else if (n > 0) {
            for (int i=2; i<n+1; i++) {
                positive[i] = positive[i-1]%1000000000 + positive[i-2]%1000000000;
            }

            printAnswer(positive[n]%1000000000);
        } else {
            int stan = 1;
            if (n%2==0) {
                stan *= -1;
            }

            for (int i=2; i<Math.abs(n)+1; i++) {
                negative[i] = negative[i-1]%1000000000 + negative[i-2]%1000000000;
            }
            printAnswer(negative[Math.abs(n)]%1000000000 * stan);
        }

        reader.close();
    }

    static void printAnswer(int answer) {
        int result;
        if (answer > 0) {
            System.out.println(1);
            result = answer;
        } else {
            System.out.println(-1);
            result = Math.abs(answer);
        }
        System.out.println(result);
    }
}
