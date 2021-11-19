package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 15501 - 부당한 퍼즐
 */
public class p15501_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());

        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();

        String[] input = reader.readLine().split(" ");
        for (int i=0; i<N; i++) {
            deque1.addLast(Integer.parseInt(input[i]));
        }
        input = reader.readLine().split(" ");
        for (int i=0; i<N; i++) {
            deque2.addLast(Integer.parseInt(input[i]));
        }

        while (!Objects.equals(deque1.peekFirst(), deque2.peekFirst())) {
            shift(deque2);
        }

        if (validate(deque1, deque2)) {
            System.out.println("good puzzle");
        } else {
            reverse(deque2);
            shift(deque2);

            if (validate(deque1, deque2)) {
                System.out.println("good puzzle");
            } else {
                System.out.println("bad puzzle");
            }
        }

        reader.close();
    }

    /**
     * 뒤집기 : 현재 수열을 거꾸로 뒤집는다. ex) 1 2 3 4 5 -> 5 4 3 2 1
     * 밀기 : 현재 수열을 왼쪽 혹은 오른쪽으로 한 칸 민다. ex) 1 2 3 4 5 -> 5 1 2 3 4
     */
    static void reverse(Deque<Integer> deque) {
        int size = deque.size();
        Stack<Integer> tmpStack = new Stack<>();
        for (int i=0; i<size; i++) {
            tmpStack.add(deque.pop());
        }
        for (int i=0; i<size; i++) {
            deque.add(tmpStack.pop());
        }
    }

    static void shift(Deque<Integer> deque) {
        deque.addFirst(deque.pollLast());
    }

    static boolean validate(Deque<Integer> deque1, Deque<Integer> deque2) {
        boolean equalsElements = true;
        int size = deque1.size();
        for (int i=0; i<size; i++) {
            int e1 = deque1.pollFirst();
            int e2 = deque2.pollFirst();

            deque1.addLast(e1);
            deque2.addLast(e2);

            if (e1 != e2) {
                equalsElements = false;
            }
        }

        return equalsElements;
    }
}
