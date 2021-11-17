package own.junn.boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 10655 - 마라톤
 *
 * N (3 ≤ N ≤ 100000)
 */
public class p10655 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    static ArrayList<Point> checkPoints = new ArrayList<>();
    static int answer;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(reader.readLine());

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            checkPoints.add(new Point(x, y));
        }

        int idx = N-2;
        int maxDiff = Integer.MIN_VALUE;
        int dummyIdx = -1;
        while (idx > 0) {
            int prevDistance = getDistance(checkPoints.get(idx-1), checkPoints.get(idx)) + getDistance(checkPoints.get(idx), checkPoints.get(idx+1));
            int newDistance = getDistance(checkPoints.get(idx-1), checkPoints.get(idx+1));

            if (maxDiff < Math.abs(newDistance-prevDistance)) {
                maxDiff = Math.abs(newDistance-prevDistance);
                dummyIdx = idx;
            }
            idx--;
        }

        Point prev = checkPoints.get(0);
        for (int i=1; i<N; i++) {
            if (i == dummyIdx) continue;

            Point curr = checkPoints.get(i);
            answer += getDistance(prev, curr);
            prev = curr;
        }

        System.out.println(answer);
        reader.close();
    }

    static int getDistance(Point before, Point current) {
        return Math.abs(current.x - before.x) + Math.abs(current.y - before.y);
    }
}

