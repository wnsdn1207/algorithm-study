package own.junn.y2023.q4.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p1764 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Set을 통해 중복 여부를 체크하고, PriorityQueue를 통해 사전순 출력을 한다.
        Set<String> set = new HashSet<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        // 듣도 못한 사람
        for (int i=0; i<N; i++) {
            set.add(reader.readLine());
        }

        // 보도 못한 사람
        for (int i=0; i<M; i++) {
            String name = reader.readLine();
            if (set.contains(name)) {
                priorityQueue.add(name);
            }
        }

        System.out.println(priorityQueue.size());
        while (priorityQueue.size() > 0) {
            System.out.println(priorityQueue.poll());
        }

        reader.close();
    }
}
