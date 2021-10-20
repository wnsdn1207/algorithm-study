package own.junn.boj;

import java.io.*;
import java.util.*;

public class Problem_14889 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[][] abilities = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j=0; j<N; j++) {
                abilities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        reader.close();
    }
}
