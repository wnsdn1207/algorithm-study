package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 11899 - 괄호 끼워넣기
 */
public class p11899 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static LinkedList<Character> opener = new LinkedList<>();
    static LinkedList<Character> closer = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        char[] inputArr = reader.readLine().toCharArray();

        for (int i=0; i<inputArr.length; i++) {
            if (inputArr[i]==40) {
                opener.add(inputArr[i]);
            } else {
                if (opener.size() > 0) {
                    opener.poll();
                } else {
                    closer.add(inputArr[i]);
                }
            }
        }

        System.out.println(opener.size() + closer.size());
        reader.close();
    }
}
