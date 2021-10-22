package own.junn.boj;

import java.util.*;
import java.io.*;

/**
 * 14248 - 점프 점프
 */
public class Problem_14248 {
    static int N;
    static int[] stones;
    static int[] distances;
    static boolean[] visited;
    static int startPoint;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        stones = new int[N];
        distances = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        for (int i=0; i<N; i++) {
            stones[i] = i+1;
            distances[i] = Integer.parseInt(st.nextToken());
        }

        startPoint = Integer.parseInt(reader.readLine());
    }
}
