package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 19941 - 햄버거분배
 */
public class Problem_19941 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int K;

    static boolean[] length;

    public static void main(String[] args) throws Exception {
        String[] inputs = reader.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);

        length = new boolean[N];

        inputs = reader.readLine().split("");
        for (int i=0; i<inputs.length; i++) {
            if (inputs[i].equalsIgnoreCase("P")) {
                length[i] = true;
            }
        }

        HashSet<Integer> garbage = new HashSet<>();
        int stuffed = 0;
        for (int i=0; i<length.length; i++) {
            if (length[i]) {
                boolean isAte = false;
                for (int j=(K-1)+1; j>0; j--) {
                    int minPos = i-j;

                    if (minPos >= 0 && !length[minPos] && !garbage.contains(minPos)) {
                        stuffed++;
                        garbage.add(minPos);
                        isAte = true;
                        break;
                    }
                }

                if (!isAte) {
                    for (int j=1; j<K+1; j++) {
                        int maxPos = i+j;

                        if (maxPos < N && !length[maxPos] && !garbage.contains(maxPos)) {
                            stuffed++;
                            garbage.add(maxPos);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(stuffed);
    }
}
