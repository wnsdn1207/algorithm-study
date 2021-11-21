package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1138 - 한 줄로 서기
 */
public class p1138 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] numbers;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        for (int i=0; i<N; i++) {
            int idx = Integer.parseInt(st.nextToken());

            for (int j=idx; j<N; j++) {
                if (numbers[j] == 0) {
                    int count = 0;
                    for (int k=0; k<j; k++) {
                        if (numbers[k] == 0) {
                            count++;
                        }
                    }

                    count = idx - count;
                    if (count > 0) {
                        for (int k=j+1; k<N; k++) {
                            if (numbers[k] == 0) {
                                count--;
                            }
                            if (count == 0) {
                                j = k;
                                break;
                            }
                        }
                    }
                    numbers[j] = i+1;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : numbers) {
            sb.append(n).append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);

        sb.setLength(0);
        reader.close();
    }
}
