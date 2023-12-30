package own.junn.y2023.q4.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1764_2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] nameArr = new String[N+M];

        // 듣도 못한 사람
        for (int i=0; i<N; i++) {
            nameArr[i] = reader.readLine();
        }

        // 보도 못한 사람
        for (int i=N; i<N+M; i++) {
            nameArr[i] = reader.readLine();
        }

        // 사전순 정렬
        Arrays.sort(nameArr);

        int length = 0;
        StringBuilder sb = new StringBuilder();

        // 인덱스를 옮겨가며 이전 문자열과 비교하고 같을 시, length를 증가시키고 sb에 추가한다.
        String prevStr = "";
        for (int i=0; i<N+M; i++) {
            if (nameArr[i].equals(prevStr)) {
                length++;
                sb.append(nameArr[i]).append("\n");
            }
            prevStr = nameArr[i];
        }

        System.out.println(length);
        System.out.println(sb);

        reader.close();
    }
}
