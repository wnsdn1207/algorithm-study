package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1018 {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N, M;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];

        for (int i=0; i<N; i++) {
            arr[i] = reader.readLine().toCharArray();
        }

        int minCount = Integer.MAX_VALUE;

        for (int i=0; i<=N-8; i++) {
            for (int j=0; j<=M-8; j++) {
                int countOfW = getChangingCount(i, j, arr, 'W');
                int countOfB = getChangingCount(i, j, arr, 'B');

                minCount = Math.min(minCount, Math.min(countOfB, countOfW));
            }
        }

        System.out.println(minCount);
    }

    private static int getChangingCount(int x, int y, char[][] arr, char init) {
        int count = 0;

        char nextChar = init;
        for (int i=x; i<8+x; i++) {
            for (int j=y; j<8+y; j++) {
                if (arr[i][j] != nextChar) {
                    count++;
                }
                if (j == 7+y) {
                    break;
                }
                nextChar = getNextChar(nextChar);
            }
        }

        return count;
    }

    private static char getNextChar(char currChar) {
        if (currChar == 'W') {
            return 'B';
        }

        return 'W';
    }
}
