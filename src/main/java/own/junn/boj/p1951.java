package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 1951 - 활자
 *
 * 1 ~ 9 : 1 ((9-1+1)*1)
 * 10 ~ 99 : 2 ((99-10+1)*2)
 * 100 ~ 999 : 3 ((999-100+1)*3)
 */
public class p1951 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    static List<Integer> list = new ArrayList<>();

    static long answer;
    static int len;
    public static void main(String[] args) throws Exception {
        String str = reader.readLine();
        len = str.length();
        N = Integer.parseInt(str);
        System.out.println(evaluate(N));

        reader.close();
    }

    static long evaluate(int n) {
        int[] arr = new int[10];
        arr[0] = 0;
        for (int i=1; i<arr.length; i++) {
            arr[i] = (int) (9 * (Math.pow(10, i-1)));
        }

//        System.out.println(arr[arr.length-1]);

        for (int i=1; i<arr.length; i++) {
            if (n > arr[i]) {
//                System.out.printf("n : %d, stan : %d, ans : %d\n", n, arr[i], answer);
                n -= arr[i];
                answer += ((long) arr[i] * i) % 1234567;
                answer %= 1234567;
            } else {
                break;
            }
        }

//        System.out.println("answer: "+answer);
//        System.out.println("n: "+n);
//        System.out.println("lastIdx : "+len);

        answer += ((long) n * len) % 1234567;
        answer %= 1234567;

        return answer % 1234567;
    }
}
