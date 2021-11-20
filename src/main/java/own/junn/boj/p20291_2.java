package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 20291 - 파일 정리
 */
public class p20291_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static String[] answers;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        answers = new String[N];

        for (int i=0; i<N; i++) {
            answers[i] = reader.readLine().split("\\.")[1];
        }

        Arrays.sort(answers);

        int count = 0;

        String currS = answers[0];
        count++;
        String prevS = currS;

        StringBuilder sb = new StringBuilder();
        sb.append(currS);
        for (int i=1; i<N; i++) {
            currS = answers[i];
            if (!currS.equalsIgnoreCase(prevS)) {
                sb.append(" ").append(count).append("\n");
                count = 0;
                sb.append(currS);
            }
            count++;
            prevS = currS;
        }
        sb.append(" ").append(count).append("\n");

        System.out.println(sb);

        reader.close();
    }
}
