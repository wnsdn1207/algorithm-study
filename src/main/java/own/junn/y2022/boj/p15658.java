package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 15658 - 연산자 끼워넣기 2
 */
public class p15658 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[] operator = {0, 0, 0, 0};
    static int[] numbers;
    static int T;

    static int minimum = (int) 1e9;
    static int maximum = (int) -1e9;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());
        numbers = new int[T];

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        for (int i=0; i<T; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(reader.readLine(), " ");
        for (int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(1, numbers[0], operator[0], operator[1], operator[2], operator[3]);

        System.out.println(maximum);
        System.out.println(minimum);

        reader.close();
    }

    static void backTracking(int idx, int currNum, int plus, int minus, int mul, int div) {
        if (idx == T) {
            if (maximum <= currNum) {
                maximum = currNum;
            }
            if (minimum >= currNum) {
                minimum = currNum;
            }

            return;
        }

        if (plus > 0) {
            backTracking(idx+1, currNum + numbers[idx], plus-1, minus, mul, div);
        }
        if (minus > 0) {
            backTracking(idx+1, currNum - numbers[idx], plus, minus-1, mul, div);
        }
        if (mul > 0) {
            backTracking(idx+1, currNum * numbers[idx], plus, minus, mul-1, div);
        }
        if (div > 0) {
            backTracking(idx+1, currNum / numbers[idx], plus, minus, mul, div-1);
        }
    }
}
