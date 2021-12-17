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
public class p22252 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int Q;

    static Map<String, List<Integer>> map = new HashMap<>();
    static long result;
    public static void main(String[] args) throws Exception {
        Q = stoi(reader.readLine());

        StringTokenizer st;
        while (Q-- > 0) {
            st = new StringTokenizer(reader.readLine(), " ");

            String name;
            int cnt;
            if (stoi(st.nextToken()) == 1) {
                name = st.nextToken();
                cnt = stoi(st.nextToken());
                List<Integer> list = map.getOrDefault(name, new LinkedList<>());

                for (int i=0; i<cnt; i++) {
                    list.add(stoi(st.nextToken()));
                }

                map.put(name, list);
            } else {
                name = st.nextToken();
                cnt = stoi(st.nextToken());
                List<Integer> list = map.get(name);
                if (list != null && list.size() > 0) {
                    list.sort((o1, o2) -> o2 - o1);

                    while (cnt-- > 0) {
                        result += list.remove(0);

                        if (list.size() == 0) {
                            break;
                        }
                    }
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
