package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 1038 - 감소하는 수
 */
public class p1038 {
    static ArrayList<Long> list;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(reader.readLine());
        list = new ArrayList<>();

        if(n <= 10) System.out.println(n);
        else if(n > 1022) System.out.println("-1");
        else {
            for(int i = 0; i < 10; i++) {
                bp(i, 1);
            }
            Collections.sort(list);

            System.out.println(list.get(n));
        }
    }

    public static void bp(long num, int idx) {
        if(idx > 10) return;

        list.add(num);
        for(int i = 0; i < num % 10; i++) {
            bp((num * 10) + i, idx + 1);
        }
    }

    static boolean isDecrementNum(int n) {
        if (n <= 0) return false;

        ArrayList<Integer> list = new ArrayList<>();
        do {
            list.add(n%10);
            n /= 10;
        } while (n/10 > 0);
        list.add(n%10);

        for (int i=1; i<list.size(); i++) {
            if (list.get(i-1) >= list.get(i)) {
                return false;
            }
        }

        return true;
    }

    static int getDigit(int n) {
        int[] digitArr = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

        for (int i=digitArr.length-1; i>=0; i--) {
            if (n > digitArr[i]) {
                return i+1;
            }
        }

        return -1;
    }
}
