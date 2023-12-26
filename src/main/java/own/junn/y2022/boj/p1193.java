package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1193 - 분수찾기
 */
public class p1193 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[][] dp = new int[5000][5000];
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        reader.close();
    }
}
