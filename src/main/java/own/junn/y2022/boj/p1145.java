package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1145 - 적어도 대부분의 배수 (최소공배수)
 */
public class p1145 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[] numbers = new int[5];
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        for (int i=0; i<numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int L = numbers.length;
        int minLcm = Integer.MAX_VALUE;
        for (int i=0; i<L; i++) {
            for (int j=i+1; j<L; j++) {
                for (int k=j+1; k<L; k++) {
                    int lcm = LCM(LCM(numbers[i], numbers[j]), numbers[k]);
                    minLcm = Math.min(minLcm, lcm);
                }
            }
        }

        System.out.println(minLcm);

        reader.close();
    }

    static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return GCD(b, a%b);
    }

    static int LCM(int a, int b) {
        return a * b / GCD(a,b);
    }
}
