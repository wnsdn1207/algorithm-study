package own.junn.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 13565 - 침투
 */
public class Problem_13565_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int M;
    static int N;
    static boolean[][] material;
    static boolean[][] visited;

    static boolean isArrived = false;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        String[] inputArr = reader.readLine().split(" ");

        M = Integer.parseInt(inputArr[0]);
        N = Integer.parseInt(inputArr[1]);

        material = new boolean[M][N];

        for (int i=0; i<M; i++) {
            char[] tmp = reader.readLine().toCharArray();
            for (int j=0; j<N; j++) {
                material[i][j] = tmp[j] == '0';
            }
        }

        for (int i=0; i<N; i++) {
            if (!isArrived && material[0][i]) {
                visited = material.clone();
                dfs(0, i);
            }
        }

        System.out.println(isArrived ? "YES" : "NO");
    }

    static void dfs(int i, int j) {
        visited[i][j] = false;
        if (i == M-1) {
            isArrived = true;
            return;
        }

        for (int k=0; k<4; k++) {
            int ax = i+dx[k];
            int ay = j+dy[k];

            if (isValidRange(ax, ay) && visited[ax][ay]) {
                dfs(ax, ay);
            }
        }
    }

    static boolean isValidRange(int x, int y) {
        return (x >= 0 && x < M) && (y >= 0 && y < N);
    }
}
