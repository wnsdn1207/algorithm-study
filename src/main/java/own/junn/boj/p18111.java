package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 18111 - 마인크래프트
 *
 * 1번 작업 (2s): 블록 제거, -1
 * 2번 작업 (1s): 블록 추가, +1
 *
 * 0 <= 땅의 높이 <= 256
 * (1 ≤ M, N ≤ 500, 0 ≤ B ≤ 6.4 × 107)
 *
 *
 * 핵심은 우선 평탄하게 맞추는 모든 조건을 탐색하게 설계하고,
 * 모든 수를 탐색한 후 inventory의 크기를 체크하여 0보다 클 시에만 답으로 책정한다.
 *
 * 이 때, 탐색 기준값을 MIN~MAX로 올라가며 탐색을 하기 때문에
 * 최종적으로, 시간은 minumum으로 세팅될 것이고, 높이는 MAX로 올라가며 가장 높은 높이가 세팅될 것이다.
 *
 * 
 */
public class p18111 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int B;

    static int[][] ground;

    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        ground = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j=0; j<M; j++) {
                int n = Integer.parseInt(st.nextToken());
                ground[i][j] = n;

                MIN = Math.min(MIN, n);
                MAX = Math.max(MAX, n);
            }
        }

        int minimumSecond = Integer.MAX_VALUE;
        int maximumHeight = Integer.MIN_VALUE;

        for (int i=MIN; i<=MAX; i++) {
            int second = 0;
            int inventory = B;

            for (int j=0; j<ground.length; j++) {
                for (int k=0; k<ground[j].length; k++) {
                    int diff = ground[j][k] - i;

                    if (diff > 0) {
                        second += Math.abs(diff) * 2;
                        inventory += Math.abs(diff);
                    } else if (diff < 0) {
                        second += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }

            if (inventory >= 0) {
                if (minimumSecond >= second) {
                    minimumSecond = second;
                    maximumHeight = i;
                }
            }
        }

        System.out.println(minimumSecond + " " + maximumHeight);

        reader.close();
    }
}
