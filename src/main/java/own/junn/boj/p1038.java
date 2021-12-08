package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1038 - 감소하는 수
 */
public class p1038 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static int[] storage = new int[1000001];
    static int[] addByDigits = {0, 1, 10, 210, 3210, 43210, 543210, 6543210, 76543210, 876543210};
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }

        if (N > 1022) {
            System.out.println(-1);
            return;
        } else if (N == 1022) {
            System.out.println("9876543210");
            return;
        }

        for (int i=0; i<11; i++) {
            storage[i] = i;
        }


        for (int i=20; ;) {
            if (i == 987654321) {
                break;
            }

            System.out.println(getDigit(i));

            if (isDecrementNum(i)) {
                System.out.println("isDecrementNum : "+ i);
                storage[idx++] = i;
            }

            i++;
        }

        System.out.println(idx);
        for (int i=0; i<idx; i++) {
            System.out.print(storage[i] + " ");
        }
        System.out.println();
        System.out.println(storage[N] == 0 ? -1 : storage[N]);

        reader.close();
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
        int digit = 1;
        while (n/10 > 0) {
            n /= 10;
            digit++;
        }
        return digit;
    }
}
