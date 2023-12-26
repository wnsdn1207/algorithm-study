package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p5555 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static char[] findCharArr;

    public static void main(String[] args) throws Exception {
        findCharArr = reader.readLine().toCharArray();

        int charLength = findCharArr.length;
        int textLine = Integer.parseInt(reader.readLine());

        int totalMatchCount = 0;
        for (int i=0; i<textLine; i++) {
            char[] eachCharArr = reader.readLine().toCharArray();

            if (isContained(eachCharArr, charLength)) {
                totalMatchCount++;
            }
        }

        System.out.println(totalMatchCount);
    }

    private static boolean isContained(char[] textArr, int requiredCount) {
        for (int j=0; j<10; j++) {
            int matchCount = 0;
            for (int k=0; k<10; k++) {
                int idx = j+k;
                if (idx >= 10) {
                    idx -= 10;
                }

                if (textArr[idx] == findCharArr[matchCount]) {
                    if (++matchCount == requiredCount) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }

        return false;
    }
}
