package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1120 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        char[] aTextArr = st.nextToken().toCharArray();
        char[] bTextArr = st.nextToken().toCharArray();

        int eventCount = bTextArr.length - aTextArr.length;

        int result = Integer.MAX_VALUE;
        for (int i=0; i<=eventCount; i++) {
            result = Math.min(result, getDiffCount(aTextArr, bTextArr, i));
        }

        System.out.println(result);
    }

    private static int getDiffCount(char[] arr1, char[] arr2, int idx) {
        int diffCount = 0;

        for (int i=0; i<arr1.length; i++) {
            if (arr1[i] != arr2[i+idx]) {
                diffCount++;
            }
        }

        return diffCount;
    }
}
