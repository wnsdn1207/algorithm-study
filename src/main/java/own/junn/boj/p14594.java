package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 14594 - 동방 프로젝트 (Small)
 */
public class p14594 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[] rooms;

    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        rooms = new int[N];

        M = Integer.parseInt(reader.readLine());
        if (M == 0) {
            System.out.println(N);
            return;
        }

        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            for (int j=start; j<end; j++) {
                rooms[j] = 1;
            }
        }

        int answer = 0;
        for (int i=0; i<N; i++) {
            if (rooms[i] == 0) {
                answer++;
            }
        }

        System.out.println(answer);

        reader.close();
    }
}
