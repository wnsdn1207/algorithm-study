package own.junn.y2022.boj;

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

    static int N, removing;

    // 단방향 그래프 관계를 표시할 인접리스트 배열
    static List<Integer>[] map;
    // 삭제된 노드임을 표시할 배열
    static boolean[] removed;

    // Leaf Node 개수
    static int answer;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        map = new ArrayList[N];
        removed = new boolean[N];

        for (int i=0; i<N; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int rootNode = 0;
        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == -1) {
                rootNode = i;
                continue;
            }

            // Root 노드로부터의 단방향 흐름으로 문제를 풀 수 있으므로 단방향 구조로 데이터를 삽입한다.
            // Root Node -> Child Node -> Leaf Node
            map[n].add(i);
        }

        removing = Integer.parseInt(reader.readLine());
        // 삭제할 노드가 Root 노드라면 Leaf Node의 개수는 무조건 0이다.
        if (removing == rootNode) {
            System.out.println(0);
            return;
        }

        // 삭제해야 하는 Node 삭제
        removeNode(removing);

//        for (List<Integer> list : map) {
//            System.out.println(Arrays.toString(list.toArray()));
//        }
//        System.out.println(Arrays.toString(removed));

        // Leaf Node의 개수 Counting
        findLeaf(rootNode);
        System.out.println(answer);

        reader.close();
    }

    /**
     * 인자값으로 들어오는 Node와 해당 Node의 Child Node를 삭제시켜주는 Method
     *
     * @param n 삭제할 Node 번호
     */
    static void removeNode(int n) {
        removed[n] = true;

        List<Integer> list = map[n];
        for (int child : list) {
            removeNode(child);
        }
    }

    /**
     * Leaf Node의 개수를 세어주는 Method
     * 단방향 그래프이므로, visited 배열을 이용하여 방문 체크를 해줄 필요가 없다.
     *
     * @param root Root Node 번호
     */
    static void findLeaf(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            List<Integer> childNodes = map[node];
            // Child Node가 있더라도, 해당 Node가 삭제된 Node일 수 있다.
            // 따라서 실제로 Queue에 추가한 Count, 즉, 삭제되지 않고 유효한 Child Node가 있는지 여부를 파악하기 위하여 사용한다.
            int addCount = 0;

            for (int child : childNodes) {
                // Child Node 중 삭제되지 않은 Node가 있다면, 해당 Node는 Leaf Node가 아니다.
                if (!removed[child]) {
                    queue.add(child);
                    addCount++;
                }
            }

            // Child Node가 없거나, 있더라도 모두 삭제된 Node라면, 해당 Node는 Leaf Node이다.
            if (addCount == 0) {
                answer++;
            }
        }
    }
}
