package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2697 - 다음 수 구하기
 */
public class Problem_2697 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] numArr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(reader.readLine());

        for (int i=0; i<n; i++) {
            String[] tmp = reader.readLine().split("");
            numArr = new int[tmp.length];

            for (int j=0; j<tmp.length; j++) {
                numArr[j] = Integer.parseInt(tmp[j]);
            }

            int targetIdx=-1;
            for (int j=numArr.length-1; j>0; j--) {
                if (numArr[j-1] < numArr[j]) {
                    targetIdx = j-1;
                    for (int k=0; k<j-1; k++) {
                        sb.append(numArr[k]);
                    }
                    break;
                }
            }

            if (targetIdx == -1) {
                System.out.println("BIGGEST");
                continue;
            }

            Arrays.sort(numArr, targetIdx+1, numArr.length);

            for (int j=targetIdx+1; j<numArr.length; j++) {
                if (numArr[targetIdx] < numArr[j]) {
                    int temp = numArr[targetIdx];
                    numArr[targetIdx] = numArr[j];
                    numArr[j] = temp;
                    break;
                }
            }

            Arrays.sort(numArr, targetIdx+1, numArr.length);

            for (int j=targetIdx; j< numArr.length; j++) {
                sb.append(numArr[j]);
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
