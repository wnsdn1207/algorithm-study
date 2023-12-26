package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2615 - 오목
 */
public class p2615 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[][] map = new int[19][19];
    static int[] dx = {1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1};
    public static void main(String[] args) throws Exception {
        for (int i=0; i<19; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            for (int j=0; j<19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count;
        for (int i=0; i<19; i++) {
            for (int j=0; j<19; j++) {
                count = 0;
                if (map[i][j] == 1 || map[i][j] == 2) {
                    count++;
                    for (int k=0; k<4; k++) {
                        int ai = i;
                        int aj = j;
                        while (count < 5) {
                            ai += dx[k];
                            aj += dy[k];

                            if (!isValidRange(ai, aj)) {
                                count=1;
                                break;
                            }

                            if (map[i][j] == map[ai][aj]) {
                                count++;
                            } else {
                                count=1;
                                break;
                            }

                            if (count==5) {
                                if (
                                        (isValidRange(ai+dx[k], aj+dy[k]) && (map[i][j] == map[ai+dx[k]][aj+dy[k]])) ||
                                        (isValidRange(i-dx[k], j-dy[k])   && (map[i][j] == map[i-dx[k]][j-dy[k]]))
                                ) {
                                    count=1;
                                    break;
                                } else {
                                    System.out.println(map[i][j]);
                                    System.out.println((i+1)+" "+(j+1));
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    static boolean isValidRange(int x, int y) {
        return x>=0 && x<19 && y>=0 && y<19;
    }
}
