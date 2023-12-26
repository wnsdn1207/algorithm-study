package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 2628 - 종이자르기
 */
public class Problem_2628 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int horizontal;
    static int vertical;

    static ArrayList<Integer> xList = new ArrayList<>();
    static ArrayList<Integer> yList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        String[] width = reader.readLine().split(" ");

        horizontal = Integer.parseInt(width[0]);
        vertical = Integer.parseInt(width[1]);

        xList.add(horizontal);
        yList.add(vertical);

        int count = Integer.parseInt(reader.readLine());

        for (int i=0; i<count; i++) {
            String[] input = reader.readLine().split(" ");

            int pos = Integer.parseInt(input[1]);

            if (input[0].equalsIgnoreCase("0")) {
                yList.add(pos);
            } else {
                xList.add(pos);
            }
        }

        Collections.sort(xList);
        Collections.sort(yList);

        int xOffset = 0, prevX = 0;
        for (int x : xList) {
            xOffset = Math.max(xOffset, x - prevX);
            prevX = x;
        }
        int yOffset = 0, prevY = 0;
        for (int y : yList) {
            yOffset = Math.max(yOffset, y - prevY);
            prevY = y;
        }

        System.out.println(xOffset*yOffset);
    }
}
