package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1316 - 그룹 단어 체커
 */
public class p1316 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        int count = 0;
        while (T-- > 0) {
            char[] chars = reader.readLine().toCharArray();

            // 알파벳 사용 체크 배열 (a~z)
            used = new boolean[26];
            // 그룹단어여부 체크
            boolean isGroupWord = true;

            for (int i=0; i<chars.length; i++) {
                int idx = chars[i] - 'a';
                if (!used[idx]) {
                    // 사용한 적이 없다면, 사용함 체크
                    used[idx] = true;
                    int tmp = i+1;
                    // 인접한 상태의 동일 알파벳을 모두 건너뜀
                    while (tmp <= chars.length-1 && chars[i] == chars[tmp]) {
                        i++;
                        tmp = i+1;
                    }
                } else {
                    // 사용한 적이 있다면, 그룹단어가 아님 (왜냐하면, 사용한 적이 있다면 해당 알파벳과 인접한 동일 알파벳을 모두 건너뜀)
                    isGroupWord = false;
                    break;
                }
            }

            // 그룹단어 일 시에만 count 증가
            if (isGroupWord) count++;
        }

        System.out.println(count);

        reader.close();
    }
}
