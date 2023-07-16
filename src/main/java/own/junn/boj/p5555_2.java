package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p5555_2 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String findText = reader.readLine();
        int lineCount = Integer.parseInt(reader.readLine());

        int matchedRingCount = 0;
        for (int i=0; i<lineCount; i++) {
            String eachText = reader.readLine();
            eachText += eachText;

            if (eachText.contains(findText)) {
                matchedRingCount++;
            }
        }

        System.out.println(matchedRingCount);
        reader.close();
    }
}