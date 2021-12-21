package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 20438 - 출석체크
 */
public class p20438 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int K;
    static int Q;
    static int M;

    static int[] presents;  // 출석 가능한 학생 체크 배열
    static boolean[] absents;   // 졸고있는 학생 체크 배열

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        absents = new boolean[N+3];
        presents = new int[N+3];

        st = new StringTokenizer(reader.readLine(), " ");
        while (K-- > 0) {
            int k = Integer.parseInt(st.nextToken());
            // 졸고 있는 학생들을 체크
            absents[k] = true;
        }

        st = new StringTokenizer(reader.readLine(), " ");
        while (Q-- > 0) {
            int q = Integer.parseInt(st.nextToken());
            // 졸고있는 학생일 경우 Skip
            if (absents[q]) {
                continue;
            }

            // 출석 가능한 학생일 경우, 각 학생의 배수만큼 체크하여 준다.
            // 이 때, 배수 중에서 졸고있는 학생인 경우는 Skip
            for (int i=q; i<=N+2; i+=q) {
                if (!absents[i]) {
                    presents[i] = 1;
                }
            }
        }

//        System.out.println(Arrays.toString(presents));

        // 졸고있는 학생을 제외하고 나온 학생들의 배열들을 각 인덱스 별로 순차적으로 더해 누적값을 더해준다.
        for (int i=3; i<=N+2; i++) {
            presents[i] += presents[i-1];
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(reader.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

//            System.out.println(Arrays.toString(presents));

            // (e-s+1): 전체 학생의 수
            // presents[e]: 모든 학생들을 대상으로 출석 체크하였을 때의 학생들의 출석 가능한 사람의 수
            // presents[s-1]: 모든 학생들을 대상으로 하지 않을 수 있기 때문에, 범위를 제외한 만큼의 누계합은 빼서 계산해야 한다.
            int answer = (e-s+1) - (presents[e]-presents[s-1]);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

        reader.close();
    }
}
