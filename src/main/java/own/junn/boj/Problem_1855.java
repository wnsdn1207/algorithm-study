package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1855 - 암호
 */
public class Problem_1855 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int K;
    static String password;

    public static void main(String[] args) throws Exception {
        K = Integer.parseInt(reader.readLine());
        password = reader.readLine();
        int passIdx = 0;
        String[] passwordArr = password.split("");

        int col = K;
        int row = password.length() / K;

        String[][] chars = new String[row][col];

        int idx=0;
        while (idx < row) {
            for (int j=0; j<col; j++) {
                chars[idx][j] = passwordArr[passIdx++];
            }
            if (++idx >= row) break;
            for (int j=col-1; j>=0; j--) {
                chars[idx][j] = passwordArr[passIdx++];
            }
            ++idx;
        }
        print(chars, row, col);

        reader.close();
    }

    static void print(String[][] strings, int row, int col) {
        for (int i=0; i<col; i++) {
            for (int j=0; j<row; j++) {
                System.out.print(strings[j][i]);
            }
        }
        System.out.println();
    }
}
