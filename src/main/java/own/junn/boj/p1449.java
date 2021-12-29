package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1449 - 수리공 항승
 *
 * N과 L은 1,000보다 작거나 같은 자연수
 * 물이 새는 곳의 위치는 1,000보다 작거나 같은 자연수
 *
 * 예제 입력 1
 * 4 2
 * 1 2 100 101
 * 예제 출력 1
 * 2
 *
 * 예제 입력 2
 * 4 3
 * 1 2 3 4
 * 예제 출력 2
 * 2
 *
 * 예제 입력 3
 * 3 1
 * 3 2 1
 * 예제 출력 3
 * 3
 */
public class p1449 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, L;
    // 물이 새는 곳의 위치를 나타낼 배열
    static boolean[] leaks = new boolean[1001];

    static int answer;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            // 물이 새는 곳의 위치를 true로 마킹
            leaks[idx] = true;
//            System.out.println("idx : "+ idx);
        }

        for (int i=1; i<leaks.length; i++) {
            // 물이 새는 곳이라면, 테이프의 길이만큼 반복문을 돌며 새는 곳을 막도록 함
            // 테이프의 길이가 5일 때, 1번의 leak를 막으려면 [1,2,3,4,5]의 길이를 모두 테이프로 막아버리도록 함
            if (leaks[i]) {
                int idx;
                for (int j=0; j<L; j++) {
                    idx = i + j;
                    // 테이프의 길이가 파이프의 길이를 초과할 시, 테이프를 잘라줌
                    if (idx > 1000) {
                        break;
                    }
                    leaks[idx] = false;
                }
                answer++;
            }
        }

        System.out.println(answer);

        reader.close();
    }
}
