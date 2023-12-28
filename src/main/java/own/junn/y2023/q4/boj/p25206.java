package own.junn.y2023.q4.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class p25206 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        Map<String, BigDecimal> gradePointMap = new HashMap<>();
        gradePointMap.put("A+", new BigDecimal("4.5"));
        gradePointMap.put("A0", new BigDecimal("4.0"));
        gradePointMap.put("B+", new BigDecimal("3.5"));
        gradePointMap.put("B0", new BigDecimal("3.0"));
        gradePointMap.put("C+", new BigDecimal("2.5"));
        gradePointMap.put("C0", new BigDecimal("2.0"));
        gradePointMap.put("D+", new BigDecimal("1.5"));
        gradePointMap.put("D0", new BigDecimal("1.0"));
        gradePointMap.put("F", new BigDecimal("0"));

        BigDecimal totalScore = BigDecimal.ZERO;
        BigDecimal totalGrade = BigDecimal.ZERO;

        for (int i=0; i<20; i++) {
            String[] splitInput = reader.readLine().split(" ");
            String grade = splitInput[1];
            String classLevel = splitInput[2];
            if (classLevel.equals("P")) {
                continue;
            }
            totalGrade = totalGrade.add(new BigDecimal(grade));
            totalScore = totalScore.add(new BigDecimal(grade).multiply(gradePointMap.get(classLevel)));
        }

        BigDecimal finalGrade = totalScore.divide(totalGrade, 6, RoundingMode.HALF_UP);
        System.out.println(finalGrade);

        reader.close();

    }
}
