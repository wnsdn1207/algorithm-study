package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1978 - 소수 찾기
 */
public class Problem_1978 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static boolean[] isNotPrimeNumbers = new boolean[100001];
    static int[] numbers;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        numbers = new int[N];

        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, numbers[i]);
        }

        for (int i=2; i<isNotPrimeNumbers.length; i++) {
            for (int j=i*2; j<isNotPrimeNumbers.length; j+=i) {
                isNotPrimeNumbers[j] = true;
            }
        }

        int answer = 0;
        for (int i : numbers) {
            for (int j=2; j<i*i; j++) {
                if (!isNotPrimeNumbers[j] && j == i) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);

        reader.close();
    }
}
