package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1068 - 트리
 *
 * 리프 노드란, 자식의 개수가 0인 노드
 * N은 50보다 작거나 같은 자연수이다.
 *
 * 예제 입력 1
 * 5
 * -1 0 0 1 1
 * 2
 * 예제 출력 1
 * 2
 *
 * 예제 입력 2
 * 5
 * -1 0 0 1 1
 * 1
 * 예제 출력 2
 * 1
 *
 * 예제 입력 3
 * 5
 * -1 0 0 1 1
 * 0
 * 예제 출력 3
 * 0
 *
 * 예제 입력 4
 * 9
 * -1 0 0 2 2 4 4 6 6
 * 4
 * 예제 출력 4
 * 2
 *
 */
public class p1068 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N, removed;

    static List<Integer>[] map;
    static boolean[] visited;

    static int answer;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        map = new ArrayList[N];
        visited = new boolean[N];

        for (int i=0; i<N; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int start = 0;
        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == -1) {
                start = i;
                continue;
            }

            map[i].add(n);
            map[n].add(i);
        }

        removed = Integer.parseInt(reader.readLine());
        if (removed == start) {
            System.out.println(0);
            return;
        }

        removing(start);

//        for (List<Integer> list : map) {
//            System.out.println(Arrays.toString(list.toArray()));
//        }
//        System.out.println(Arrays.toString(visited));

        System.out.println(answer);

        reader.close();
    }

    static void removing(int n) {
        if (!visited[n]) {
            visited[n] = true;
        }

        List<Integer> list = map[n];
        if (list.size() == 1) {
//            System.out.println(n);
            answer++;
            return;
        }

        for (int el : list) {
            if (el == removed) continue;

            if (!visited[el]) {
                visited[el] = true;
                removing(el);
            }
        }
    }
}
