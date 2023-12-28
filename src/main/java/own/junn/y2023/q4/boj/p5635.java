package own.junn.y2023.q4.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p5635 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(reader.readLine());

        int dateMin = Integer.MAX_VALUE;
        int dateMax = 0;

        Map<Integer, String> birthdayNameMap = new HashMap<>();
        for (int i=0; i<N; i++) {
            String[] splitStr = reader.readLine().split(" ");

            // 연,월,일을 yyyyMMdd 형식으로 만든다.
            // MM, dd의 경우 0으로 시작하지 않으므로 length()가 1이라면 앞에 "0"을 붙여준다.
            String year = splitStr[3];
            String month = splitStr[2].length() == 1 ? "0" + splitStr[2] : splitStr[2];
            String day = splitStr[1].length() == 1 ? "0" + splitStr[1] : splitStr[1];

            // parsing과 동시에 min, max date를 구한다.
            int date = Integer.parseInt(year + month + day);
            dateMin = Math.min(dateMin, date);
            dateMax = Math.max(dateMax, date);
            birthdayNameMap.put(date, splitStr[0]);
        }

        // dateMax = 나이가 가장 많은 사람, dateMin = 나이가 가장 적은 사람
        System.out.println(birthdayNameMap.get(dateMax));
        System.out.println(birthdayNameMap.get(dateMin));

        reader.close();
    }
}
