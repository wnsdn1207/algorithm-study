package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 9237 - 이장님 초대
 */
public class p9237 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] trees;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        trees = new int[N];

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        for (int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);

        int date = 1;
        int idx = trees.length-1;
        int maxDate = Integer.MIN_VALUE;
        while (idx >= 0) {
            maxDate = Math.max(maxDate, trees[idx--] + date);
            date++;
        }

        System.out.println(maxDate+1);
    }
}
