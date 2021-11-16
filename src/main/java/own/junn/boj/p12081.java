package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 12081 - Yonsei TOTO
 */
public class p12081 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int m;

    static int[] priorityArr;
    static int answer;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        priorityArr = new int[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(reader.readLine(), " ");

            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            int nextCount = (p+1) - s;
            int minimumMileage = 1;

            st = new StringTokenizer(reader.readLine(), " ");
            if (nextCount <= 0) {
                priorityArr[i] = minimumMileage;
                continue;
            }
            int[] mileageStatus = new int[p];
            for (int j=0; j<p; j++) {
                mileageStatus[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(mileageStatus);
            priorityArr[i] = mileageStatus[nextCount-1];
        }

        Arrays.sort(priorityArr);

        for (int needsMileage : priorityArr) {
            if (m - needsMileage >= 0) {
                m -= needsMileage;
                answer++;
            } else {
                break;
            }
        }

        System.out.println(answer);
        reader.close();
    }
}
