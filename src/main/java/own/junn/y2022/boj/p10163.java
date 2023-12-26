package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10163 - 색종이
 */
public class p10163 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[][] rectangle = new int[1001][1001];
    static int[] results;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        results = new int[N+1];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for (int j=x; j<x+height; j++) {
                for (int k=y; k<y+width; k++) {
                    rectangle[j][k] = i+1;
                }
            }
        }

        for (int i=0; i<rectangle.length; i++) {
            for (int j=0; j<rectangle[i].length; j++) {
                int r = rectangle[i][j];
                if (r != 0) {
                    results[r] += 1;
                }
            }
        }

        for (int i=1; i<results.length; i++) {
            System.out.println(results[i]);
        }

        reader.close();
    }
}
