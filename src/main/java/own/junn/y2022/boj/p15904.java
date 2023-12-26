package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 15904 - UCPC는 무엇의 약자일까
 */
public class p15904 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static char[] chars;

    static Queue<Character> queue = new LinkedList<>(Arrays.asList('U', 'C', 'P', 'C'));

    public static void main(String[] args) throws Exception {
        chars = reader.readLine().toCharArray();
//        System.out.printf("Queue : %s\n", Arrays.toString(queue.toArray()));

        int idx = 0;
        while (!queue.isEmpty()) {
            char c = queue.peek();

            if (chars[idx++] == c) {
//                System.out.printf("c : %s, size : %d\n", c, queue.size());
                queue.poll();
            }

            if (idx == chars.length) {
                break;
            }
        }

//        System.out.println(Arrays.toString(queue.toArray()));
        System.out.println(queue.size() > 0 ? "I hate UCPC" : "I love UCPC");

        reader.close();
    }
}
