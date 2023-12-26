package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 5585 - 거스름돈
 */
public class p5585 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static int[] penny = {500, 100, 50, 10, 5, 1};
    public static void main(String[] args) throws Exception {
        N = 1000 - Integer.parseInt(reader.readLine());

        int answer = 0;
        int idx = 0;
        while (N > 0) {
            if (N >= penny[idx]) {
                N -= penny[idx];
                answer++;
            } else {
                idx++;
            }
        }

        System.out.println(answer);

        reader.close();
    }
}
