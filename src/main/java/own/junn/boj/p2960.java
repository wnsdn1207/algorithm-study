package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2960 - 에라토스테네스의 체
 *
 * 예제 입력 1
 * 7 3
 * 예제 출력 1
 * 6
 *
 * 예제 입력 2
 * 15 12
 * 예제 출력 2
 * 7
 *
 * 예제 입력 3
 * 10 7
 * 예제 출력 3
 * 9
 */
public class p2960 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        for (int i=2; i<arr.length; i++) {
            arr[i] = i;
        }

        int count = 0;
        for (int i=2; i<arr.length; i++) {
            for (int j=i; j<arr.length; j+=i) {
                int tmp = arr[j];
                if (tmp == 0) continue;

                arr[j] = 0;
                count++;

                if (count == M) {
                    System.out.println(tmp);
                    return;
                }
            }
        }

        reader.close();
    }
}
