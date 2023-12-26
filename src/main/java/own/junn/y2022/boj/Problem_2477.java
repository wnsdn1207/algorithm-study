package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2477 - 참외밭
 *
 * 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4
 *
 * 육각형을 만들기 위해서는 인접한 변끼리 곱할 수가 있다.
 * 즉, 남북 방향이 나왔다면 다음은 무조건 동서 방향 중 한 방향이 나오게 된다.
 *
 * 이 때, 인접한 모든 변들의 곱을 더하면 파인면만 2번이 겹치게 되고 나머지 면들은 모두 3번씩 겹치게 된다.
 * 즉, 인접한 모든 변들의 곱을 더하면 : 나머지면*3 + 파인면*2
 * 따라서, 가장 큰 인접한 변의 곱(너비)을 구하고, 인접한 모든 변들의 곱을 더해준다.
 * 위의 핵심값들로 파인면의 너비를 구할 수 있다.
 *
 * 최종식: 참외개수 * (가장 큰 너비 - (가장 큰 너비*3 - 인접한 모든 변들의 곱의 합))
 */
public class Problem_2477 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int fruitCount = Integer.parseInt(reader.readLine());

        int sum = 0, max = Integer.MIN_VALUE;
        int firstLength = Integer.parseInt(reader.readLine().split(" ")[1]);
        int previous = firstLength;
        for (int i=1; i<6; i++) {
            int length = Integer.parseInt(reader.readLine().split(" ")[1]);

            sum += previous * length;
            max = Math.max(max, previous * length);
            previous = length;
        }
        sum += firstLength * previous;
        max = Math.max(max, firstLength * previous);

        System.out.println(fruitCount * ((max)-(3*max-sum)));
    }
}
