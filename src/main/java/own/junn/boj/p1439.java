package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1439 - 뒤집기
 */
public class p1439 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static char[] chars;
    public static void main(String[] args) throws Exception {
        chars = reader.readLine().toCharArray();

        char prev = '2';
        int zeroPackCount = 0, onePackCount = 0;
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == '0') {
                if (prev == '2') {
                    zeroPackCount++;
                }
            } else {
                if (prev == '2') {
                    onePackCount++;
                }
            }

            if (prev != '2' && prev != chars[i]) {
                if (chars[i] == '0') {
                    zeroPackCount++;
                } else {
                    onePackCount++;
                }
            }

            prev = chars[i];
        }

//        System.out.printf("zeroCnt : %d, oneCnt : %d, zeroPackCnt : %d, onePackCnt : %d\n",
//                zeroCount, oneCount, zeroPackCount, onePackCount);
        System.out.println(Math.min(zeroPackCount, onePackCount));

        reader.close();
    }
}
