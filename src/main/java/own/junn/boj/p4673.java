package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 4673 - 셀프넘버
 */
public class p4673 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[] arr = new int[10001];
    public static void main(String[] args) throws Exception {
        for (int i=0; i<arr.length; i++) {
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > 0) {
                sb.append(arr[i]).append("\n");

                int tmp = arr[i];
                while (true) {
                    tmp = function(tmp);

                    if (tmp > 10000) break;
                    arr[tmp] = 0;
                }
            }
        }

        System.out.println(sb);

        reader.close();
    }

    /**
     * function(n) = n + n의 각 자리수의 합
     *
     * @param n 인자값
     * @return n + sum(n의 각 자리수)
     */
    static int function(int n) {
        int result = n;

        while (n > 0) {
            result += n % 10;
            n /= 10;
        }

        return result;
    }
}
