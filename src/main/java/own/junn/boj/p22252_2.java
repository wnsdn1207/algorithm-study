package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 22252 - 정보 상인 호석
 *
 * 예제 입력 1
 * 7
 * 1 Cpp 5 10 4 2 8 4
 * 1 Java 2 8 2
 * 2 Cpp 2
 * 1 Cpp 2 10 3
 * 2 Cpp 3
 * 2 Java 1
 * 2 Python 10
 *
 * 예제 출력 1
 * 44
 */
public class p22252_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int Q;

    static Map<String, PriorityQueue<Integer>> map = new HashMap<>();
    static Comparator<Integer> comparator = (o1, o2) -> o2 - o1;

    static long result;

    public static void main(String[] args) throws Exception {
        Q = stoi(reader.readLine());

        StringTokenizer st;
        while (Q-- > 0) {
            st = new StringTokenizer(reader.readLine(), " ");

            int command = stoi(st.nextToken());
            String name = st.nextToken();;
            int cnt = stoi(st.nextToken());

            PriorityQueue<Integer> queue = map.getOrDefault(name, new PriorityQueue<>(comparator));
            if (command == 1) {
                while (cnt-- > 0) {
                    queue.add(stoi(st.nextToken()));
                }
                map.put(name, queue);
            } else {
                while (cnt-- > 0 && !queue.isEmpty()) {
                    result += queue.poll();
                }
            }
        }

        System.out.println(result);

        reader.close();
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
