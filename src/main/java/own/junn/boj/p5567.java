package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 5567 - 결혼식
 */
public class p5567 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static ArrayList<Integer>[] array;
    static int[] relations;

    static int answer;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());

        array = new ArrayList[N];
        relations = new int[N];

        for (int i=0; i<N; i++) {
            array[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(reader.readLine(), " ");

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            array[a].add(b);
            array[b].add(a);
        }

        Arrays.fill(relations, -1);
        inviteFriends();
        for (int i : relations) {
            if (i > 0 && i <= 2) {
                answer++;
            }
        }

//        System.out.println(Arrays.toString(relations));
        System.out.println(answer);

        reader.close();
    }

    static void inviteFriends() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        relations[0] = 0;

        while (queue.size() > 0) {
            int p = queue.poll();

            ArrayList<Integer> list = array[p];

            for (int i : list) {
                if (relations[i] == -1) {
                    queue.add(i);
                    relations[i] = relations[p] + 1;
                }
            }
        }
    }
}
