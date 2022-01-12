package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 11502 - 세 개의 소수 문제
 */
public class p11502 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;
    static int[] arr = new int[1001];
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        for (int i=2; i<arr.length; i++) {
            arr[i] = i;
        }

        primeSieve();

//        for (int i : arr) {
//            if (i > 0) {
//                System.out.println(i);
//            }
//        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(reader.readLine());

            boolean isPossible = false;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    for (int k=0; k<n; k++) {
                        if (arr[i] == 0 || arr[j] == 0 || arr[k] == 0) continue;

                        int sum = arr[i] + arr[j] + arr[k];
                        if (sum == n) {
                            sb.append(arr[i]).append(" ")
                                    .append(arr[j]).append(" ")
                                    .append(arr[k]).append("\n");

                            isPossible = true;
                        }
                    }
                    if (isPossible) break;
                }
                if (isPossible) break;
            }

            if (!isPossible) {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);

        reader.close();
    }

    static void primeSieve() {
        for (int i=2; i<Math.sqrt(arr.length); i++) {
            if (arr[i] > 0) {
                for (int j=i*i; j<arr.length; j+=i) {
                    arr[j] = 0;
                }
            }
        }
    }
}
