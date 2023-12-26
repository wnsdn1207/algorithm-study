package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 6010 - Music Notes
 *
 * List의 구현체로써,
 * 삽입, 삭제보단 특정 index의 값을 가져오는 행위가 많이 발생하므로 ArrayList를 사용하는 것이 효율적
 */
public class p6010 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int Q;

    static List<Integer> notes = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        Q = Integer.parseInt(input[1]);

        int now = 0;

        while (N-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            notes.add(now + n - 1);
            now += n;
        }

//        System.out.println("notes : "+ Arrays.toString(notes.toArray()));

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            int q = Integer.parseInt(reader.readLine());

            int it = lowerBound(q);
            sb.append(it+1).append("\n");
        }

        System.out.println(sb);

        reader.close();
    }

    /**
     * c++ 에서 제공하는 lower_bound 함수를 구현한 메소드
     *
     * 이분탐색과 비슷한 로직을 가지나,
     * target 값보다 큰 값을 찾고 그 값의 index를 반환하는 것에 목적이 있다.
     *
     * @param target 찾으려고 하는 값
     * @return 찾으려고 하는 값보다 크거나 같은 값을 찾고, 그 값의 인덱스를 반환
     */
    static int lowerBound(int target) {
        int start = 0, end = notes.size();
        while (start < end) {
            int mid = (start + end) / 2;

            if (target <= notes.get(mid)) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return end;
    }
}
