package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2847 - 게임을 만든 동준이
 */
public class p2847 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] levels;

    static int count;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        // level의 수가 1개인 경우, 오름차순으로 감소시킬 대상이 없으므로 0 리턴
        if (N == 1) {
            System.out.println(0);
            return;
        }

        levels = new int[N];

        for (int i=0; i<N; i++) {
            levels[i] = Integer.parseInt(reader.readLine());
        }

//        System.out.println("origin : "+ Arrays.toString(levels));
        // 가장 끝자리의 수를 기준으로 삼는다 (난이도를 오름차순으로 만들기 위해 가장 적게 숫자를 감소시킬 수 방법)
        int stan = levels[N-1];
        // 주어진 수의 가장 마지막 수가 가장 큰 수가 되어야 하므로, 마지막 자리수로부터 두번째 위치하는 수부터 차례대로 탐색하며 처리한다.
        for (int i=N-2; i>=0; i--) {
            // 오른쪽 끝을 기준으로 2번째 수부터 진행하므로, 오름차순의 최소 조건을 만족하기 위해 1씩 빼준 수를 기준으로 한다.
            stan--;
            // 배열의 해당 인덱스의 수가 최소 기준 수를 만족할 경우, 다음 수로 넘어간다.
            if (levels[i] == stan) continue;

            // 배열의 해당 수가 기준 수보다 크다면, 해당 수에서 기준 수를 뺴주고 그 차이만큼 감소 횟수에 더해준다.
            // 기준 수보다 배열의 해당 수가 작다면, 기준 수를 배열의 해당 수로 치환해준다.
            if (levels[i] > stan) {
                int diff = levels[i] - stan;
                count += diff;
            } else {
                stan = levels[i];
            }
        }
//        System.out.println("altered : "+ Arrays.toString(levels));
//        System.out.println("count : "+ count);
        System.out.println(count);

        reader.close();
    }
}
