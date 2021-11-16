package own.junn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p1660_2 {
    static int n, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        n = stoi(br.readLine());

        List<Integer> arr = new ArrayList<>();

        // 정사면체 만들기
        arr.add(1);
        int val = 3;
        int idx = 3;
        while(arr.get(arr.size() - 1) + val <= 300000) {
            arr.add(arr.get(arr.size() - 1) + val);
            val += idx;
            idx++;
        }
        arr.add(300001);		// 아래 while문을 빠져나가기 위한 조건으로 추가

        System.out.println(Arrays.toString(arr.toArray()));

        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        int j = 0;
        for(int i = 0; i <= n; i++) {
            j = 0;
            // 현재 대포알의 개수보다 작은 정사면체들을 하나씩 비교하며 dp를 구한다.
            while(arr.get(j) <= i) {
                dp[i] = Math.min(dp[i], dp[i - arr.get(j)] + 1);
                j++;
            }
        }

        System.out.println(dp[n]);
        br.close();
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
