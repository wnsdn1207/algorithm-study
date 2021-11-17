package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 3758 - KCPC
 *
 * 첫째줄, 팀의 개수 n (3 ≤ n), 문제의 개수 k (k ≤ 100), 당신 팀의 ID t (1 ≤ t ≤ n), 로그 엔트리의 개수 m (3 ≤ m ≤ 10,000)
 * 다음줄, 각 줄에는 팀 ID i, 문제 번호 j, 획득한 점수 s
 */
public class p3758 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int T;

    static int[][] scoreArr;
    static int[] finalScoreArr;
    static int[] requestArr;
    static int[] latestIdxArr;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

            int teamCount = Integer.parseInt(st.nextToken());
            int psCount = Integer.parseInt(st.nextToken());
            int myTeamId = Integer.parseInt(st.nextToken());
            int accessCount = Integer.parseInt(st.nextToken());

            scoreArr = new int[teamCount+1][psCount+1];
            requestArr = new int[teamCount+1];
            latestIdxArr = new int[teamCount+1];

            Arrays.fill(latestIdxArr, Integer.MAX_VALUE);
            int maximumScore = 0;
            for (int i=0; i<accessCount; i++) {
                st = new StringTokenizer(reader.readLine(), " ");

                int teamId = Integer.parseInt(st.nextToken());
                int psNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                maximumScore = Math.max(maximumScore, score);

                scoreArr[teamId][psNum] = Math.max(scoreArr[teamId][psNum], score);
                requestArr[teamId] += 1;
                latestIdxArr[teamId] = i;
            }

            finalScoreArr = new int[teamCount+1];

            for (int i=1; i<teamCount+1; i++) {
                for (int j=1; j<psCount+1; j++) {
                    finalScoreArr[i] += scoreArr[i][j];
                }
            }

            int count = 0;
            for (int i=1; i<teamCount+1; i++) {
                if (i == myTeamId) continue;

                if (finalScoreArr[myTeamId] < finalScoreArr[i]) {
                    count++;
                } else if (finalScoreArr[myTeamId] == finalScoreArr[i]) {
                    /*
                     * 최종 점수가 같은 경우, 풀이를 제출한 횟수가 적은 팀의 순위가 높다.
                     * 최종 점수도 같고 제출 횟수도 같은 경우, 마지막 제출 시간이 더 빠른 팀의 순위가 높다.
                     */
                    if (requestArr[myTeamId] > requestArr[i]) {
                        count++;
                    } else if (requestArr[myTeamId] == requestArr[i]) {
                        if (latestIdxArr[myTeamId] > latestIdxArr[i]) {
                            count++;
                        }
                    }
                }
            }

            System.out.println(count+1);
        }

        reader.close();
    }
}
