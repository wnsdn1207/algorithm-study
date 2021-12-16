package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 17839 - Baba is Rabbit
 *
 * 게임 시작 시 몇 개의 명령을 설정해놓는다.
 * 이 때, 모든 명령의 형태는 p is q 의 형태이며, p, q는 사물이다.
 * 두 사물 p, q에 대해 p is q 라는 명령은 사물 p를 사물 q로 바꾼다.
 * 이러한 행위를 명령을 적용한다고 부른다.
 *
 * 예제 입력 1
 * 1
 * Rabbit is Carrot
 * 예제 출력 1
 *
 * (적용할 수 있는 명령이 아예 없으므로, 아무것도 출력하지 않는다.)
 *
 * 예제 입력 2
 * 3
 * Rabbit is Carrot
 * Baba is Cat
 * Cat is Rabbit
 * 예제 출력 2
 * Carrot
 * Cat
 * Rabbit
 * Baba에 명령을 한 번 이상 적용한 결과로 나올 수 있는 사물은 Cat, Rabbit, 그리고 Carrot이다.
 *
 * 예제 입력 3
 * 1
 * Baba is Rabbit
 * 예제 출력 3
 * Rabbit
 * 예제 입력 4
 * 4
 * Baba is Rabbit
 * Rabbit is Cat
 * Cat is Wall
 * Wall is Unist
 *
 * 예제 출력 4
 * Cat
 * Rabbit
 * Unist
 * Wall
 */
public class p17839 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static final String BABA = "Baba";
    static final String splitWord = " is ";

    static int N;

    static Map<String, Queue<String>> map = new HashMap<>();
    static Queue<String> resultQ = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        boolean hasBaba = false;
        for (int i=0; i<N; i++) {
            String[] str = reader.readLine().split(splitWord);

            Queue<String> q = map.getOrDefault(str[0], new LinkedList<>());
            q.add(str[1]);

            map.put(str[0], q);

            if (!hasBaba && str[0].equalsIgnoreCase(BABA)) {
                hasBaba = true;
            }
        }

        if (hasBaba) {
            bfs();

            StringBuilder sb = new StringBuilder();
            String prevString = "";
            while (!resultQ.isEmpty()) {
                String s = resultQ.poll();
                if (prevString.equalsIgnoreCase(s)) {
                    continue;
                }
                sb.append(s).append("\n");
                prevString = s;
            }

            System.out.println(sb);
        } else {
            System.out.println();
        }

        reader.close();
    }

    static void bfs() {
        Queue<String> queue = new LinkedList<>();
        queue.add(BABA);

        while (!queue.isEmpty()) {
            String key = queue.poll();

            if (!map.containsKey(key)) {
                break;
            }

            Queue<String> list = map.get(key);
            while (!list.isEmpty()) {
                String _key = list.poll();
                resultQ.offer(_key);
                if (map.get(_key) != null && map.get(_key).size() > 0) {
                    queue.add(_key);
                }
            }
        }
    }
}
