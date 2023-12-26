package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1543 - 문서 검색
 *
 * 문서의 길이는 최대 2500
 * 검색하고 싶은 단어의 길이는 최대 50
 * 문서와 단어는 알파벳 소문자와 공백
 *
 * 예제 입력 1
 * ababababa
 * aba
 * 예제 출력 1
 * 2
 *
 * 예제 입력 2
 * a a a a a
 * a a
 * 예제 출력 2
 * 2
 *
 * 예제 입력 3
 * ababababa
 * ababa
 * 예제 출력 3
 * 1
 *
 * 예제 입력 4
 * aaaaaaa
 * aa
 * 예제 출력 4
 * 3
 */
public class p1543 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // 전체 문자 배열
    static char[] chars;
    // 중복 체크 방지를 위한 방문 체크 배열
    static boolean[] visited;
    // 찾을 문자 배열
    static char[] target;
    // 전체 문자 배열 내 포함된 찾을 문자 배열 개수
    static int answer;

    public static void main(String[] args) throws Exception {
        chars = reader.readLine().toCharArray();
        visited = new boolean[chars.length];
        target = reader.readLine().toCharArray();

        // 전체 문자 배열에서 찾을 문자 배열을 뺀 만큼 반복문을 돌린다.
        // target 문자 배열의 개수 전에서부터 세어야만 target 문자 배열과 일치한다.
        // target의 문자와 정확히 일치해야 하므로, chars의 0번째부터 target의 문자 배열만큼 반복문을 돌렸을 때 정확히 일치할 때만 정답 count를 세준다.
        // 그러기 위하여 이중 for문을 사용
        for (int i=0; i<=chars.length-target.length; i++) {
            // Temp Index 값 (내부 반복문을 위한 index)
            int idx = i;
            // 일치한 횟수 count (정답 count가 아님)
            int cnt = 0;
//            System.out.println("visited : "+ Arrays.toString(visited));
            for (int j=0; j<target.length; j++) {
                if (visited[idx]) break;

                // Temp Index의 값을 target 배열의 길이만큼 늘려가면서 체크해준다.
                if (chars[idx++] == target[j]) {
                    cnt++;

                    // 모두 일치하였을 때, cnt는 target 배열의 길이와 같아진다.
                    // 따라서, cnt값과 target 배열의 길이가 같을 경우,
                    // 정답 count를 증가시키고, 초기 index 값인 i번째부터 target 배열의 길이만큼 방문 처리를 해준다.
                    if (cnt == target.length) {
                        answer++;
                        for (int k=0; k<cnt; k++) {
                            visited[i+k] = true;
                        }
                        break;
                    }
                } else {
                    visited[i] = true;
                    break;
                }
            }
        }

        System.out.println(answer);

        reader.close();
    }
}
