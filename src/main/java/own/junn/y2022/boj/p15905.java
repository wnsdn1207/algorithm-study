package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 15905 - 스텔라가 치킨을 선물했어요
 */
public class p15905 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] solved;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(reader.readLine());

        if (N == 5) {
            System.out.println(0);
            return;
        }
        solved = new int[N];

        for (int i=0; i<N; i++) {
            String[] tmp = reader.readLine().split(" ");
            solved[i] = Integer.parseInt(tmp[0]);
        }
        Arrays.sort(solved);

        int stan = solved[N-5];

        int result = 0;
        for (int i=N-6; i>=0; i--) {
            if (solved[i] == stan) {
                result++;
            } else {
                break;
            }
        }

        System.out.println(result);

        reader.close();
    }
}
