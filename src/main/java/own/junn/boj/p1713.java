package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1713 - 후보 추천하기
 */
public class p1713 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int T;

    static int[] numbers = new int[101];
    static Queue<Integer> orders = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        T = Integer.parseInt(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int count = 0;
        for (int i=0; i<T; i++) {
            int idx = Integer.parseInt(st.nextToken());

            
        }

        reader.close();
    }

    public static void insert(int n, int count) {
        if (count == 3) {

        }
    }

    public static void delete() {

    }
}
