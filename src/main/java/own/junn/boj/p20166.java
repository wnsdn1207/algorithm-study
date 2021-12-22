package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 20166 - 문자열 지옥에 빠진 호석
 *
 * 3 ≤ N, M ≤ 10, N과 M은 자연수이다.
 * 1 ≤ K ≤ 1,000, K는 자연수이다.
 * 1 ≤ 신이 좋아하는 문자열의 길이 ≤ 5
 * 신이 좋아하는 문자열은 중복될 수도 있다.
 *
 * 예제 입력 1
 * 3 3 2
 * aaa
 * aba
 * aaa
 * aa
 * bb
 * 예제 출력 1
 * 56
 * 0
 *
 * 예제 입력 2
 * 3 4 3
 * abcb
 * bcaa
 * abac
 * aba
 * abc
 * cab
 * 예제 출력 2
 * 66
 * 32
 * 38
 */
public class p20166 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int K;

    static char[][] chars;

    static String[] strs;
    static Map<String, Integer> map = new HashMap<>();

    static int MAX_LENGTH;

    static int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        chars = new char[N][M];
        strs = new String[K];

        for (int i=0; i<N; i++) {
            chars[i] = reader.readLine().toCharArray();
        }

        for (int n=0; n<K; n++) {
            String likes = reader.readLine();
            MAX_LENGTH = Math.max(MAX_LENGTH, likes.length());
            map.put(likes, 0);
            strs[n] = likes;
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                bfs(i, j, Character.toString(chars[i][j]));
            }
        }

        System.out.println("Map : " + map.entrySet());

        StringBuilder sb = new StringBuilder();
        for (String key : strs) {
            sb.append(map.get(key)).append("\n");
        }

        System.out.println(sb);

        reader.close();
    }

    static void bfs(int x, int y, String s) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 1, s));

        while (!queue.isEmpty()) {
            Point node = queue.peek();
            if (map.containsKey(node.s)) {
                map.put(node.s, map.get(node.s) + 1);
            }
            if (node.cnt == MAX_LENGTH) {
                continue;
            }
            queue.poll();

            for (int i=0; i<8; i++) {
                int ax = node.x + dx[i];
                int ay = node.y + dy[i];

                if (ax < 0) {
                    ax = N-1;
                } else if (ax == N) {
                    ax = 0;
                }

                if (ay < 0) {
                    ay = M-1;
                } else if (ay == M) {
                    ay = 0;
                }

                queue.add(new Point(ax, ay, node.cnt + 1, node.s + chars[ax][ay]));
            }
        }

//        while (!queue.isEmpty()) {
//            Point node = queue.poll();
//
//            if (map.containsKey(node.s)) {
//                map.put(node.s, map.get(node.s) + 1);
//            }
//        }
    }

    static class Point {
        int x;
        int y;
        int cnt;
        String s;

        public Point(int x, int y, int cnt, String s) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.s = s;
        }
    }
}
