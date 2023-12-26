package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 14490 - 백대열
 */
public class Problem_14490 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), ":");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == m) {
            System.out.println("1:1");
        }

        List<Integer> aliquots_N = new ArrayList<>();
        List<Integer> aliquots_M = new ArrayList<>();

        for (int i=2; i<n+1; i++) {
            if (n%i==0) {
                aliquots_N.add(i);
            }
        }
        for (int i=2; i<m+1; i++) {
            if (m%i==0) {
                aliquots_M.add(i);
            }
        }

        Collections.reverse(aliquots_N);
        Collections.reverse(aliquots_M);

        for (int aliquotM : aliquots_M) {
            for (int aliquotN : aliquots_N) {
                if (aliquotM > aliquotN) {
                    break;
                } else if (aliquotM == aliquotN) {
                    System.out.println(n/aliquotM + ":" + m/aliquotM);
                    return;
                }
            }
        }

        System.out.println(n+":"+m);
    }
}
