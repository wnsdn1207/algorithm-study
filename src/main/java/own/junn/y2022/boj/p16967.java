package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 16967 - 배열 복원하기
 */
public class p16967 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int H;
    static int W;
    static int X;
    static int Y;

    static int[][] A;
    static int[][] B;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        A = new int[H][W];
        B = new int[H+X][W+Y];

        for (int i=0; i<H+X; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j=0; j<W+Y; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] rowB;
        int xIdx = 0, xLoopCount = H-X;
        for (int i=0; i<xLoopCount; i++) {
            rowB = Arrays.copyOf(B[xIdx], B[xIdx++].length);
            for (int j=0; j<W; j++) {
                B[X+i][Y+j] -= rowB[j];
            }
        }
        for (int i=0; i<H; i++) {
            A[i] = Arrays.copyOf(B[i], W);
        }

        StringBuilder sb = new StringBuilder();
        for (int[] arr : A) {
            for (int n : arr) {
                sb.append(n).append(" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
        sb.setLength(0);

        reader.close();
    }
}
