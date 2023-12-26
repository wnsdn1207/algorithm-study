package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 13413 - 오셀로 재배치
 *
 * N(1≤N≤100,000)
 *
 * 예제 입력 1
 * 3
 * 5
 * WBBWW
 * WBWBW
 * 7
 * BBBBBBB
 * BWBWBWB
 * 4
 * WWBB
 * BBWB
 * 예제 출력 1
 * 1
 * 3
 * 2
 */
public class p13413 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;
    static int N;

    static char[] initStatus;
    static char[] targetStatus;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        for (int i=0; i<T; i++) {
            N = Integer.parseInt(reader.readLine());

            initStatus = reader.readLine().toCharArray();
            targetStatus = reader.readLine().toCharArray();

            // wbCount : initStatus[i] = 'W'이고, targetStatus[i] = 'B'인 개수
            // bwCount : initStatus[i] = 'B'이고, targetStatus[i] = 'W'인 개수
            int wbCount = 0, bwCount = 0;
            for (int j=0; j<N; j++) {
                if (initStatus[j] == 'W' && targetStatus[j] == 'B') {
                    wbCount++;
                } else if (initStatus[j] == 'B' && targetStatus[j] == 'W') {
                    bwCount++;
                }
            }

            /**
             * 간단하게 생각해보았을 때,
             *
             * swap의 경우, wbCount와 bwCount를 1씩 감소시킬 수 있다.
             * 왜냐하면, wbCount와 bwCount의 각 자리수를 서로 swap 시켜주면,
             * wbCount, 즉 initStatus[i]가 'W'이고 targetStatus[i]가 'B'이기 때문에 맞지 않았던 것이
             * bwCount, 즉 initSTatus[i]가 'B'이고 targetStatus[i]가 'W'이기 때문에 맞지 않았던 것과 서로 맞춰지면서 작업의 횟수인 count는 1개밖에 증가하지 않는다.
             * 위의 경우는 wbCount와 bwCount가 모두 양수여야만 한다.
             *
             * reverse의 경우, wbCount 또는 bwCount 중 1개를 1씩 감소시킬 수 있다.
             * 위의 경우는 wbCount와 bwCount 중 1개가 0일 때 사용하는 것이 유용하다.
             * 왜냐하면, swap을 통해 각 count를 감소시키며 작업 횟수는 1개밖에 증가하지 않기 때문이다.
             * 따라서, swap을 통해 각 count들 중 1개의 변수가 0이 될 때까지 빠르게 감소시켜 준 이후,
             * 나머지는 reverse를 통해 맞춰주기만 하면 된다.
             *
             * 위 내용을 종합하여 보면, wbCount, bwCount가 각각 3, 5라면,
             * 3번의 swap과 2번의 reverse를 통해 두 개의 상태를 맞춰줄 수 있다.
             * 따라서, wbCount와 bwCount 중 큰 숫자를 정답으로 채택할 수 있다.
             */
            System.out.println(Math.max(wbCount, bwCount));
        }

        reader.close();
    }
}
