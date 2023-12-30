package own.junn.y2023.q4.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class p11478 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String str = reader.readLine();
        Set<String> stringSet = new HashSet<>();

        int length = str.length();

        for (int i=1; i<=length-1; i++) {
            for (int j=0; j+i<=length; j++) {
                stringSet.add(str.substring(j, j+i));
            }
        }
        stringSet.add(str);

        System.out.println(stringSet.size());
        reader.close();
    }
}
