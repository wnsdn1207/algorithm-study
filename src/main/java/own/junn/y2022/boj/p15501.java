package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 15501 - 부당한 퍼즐
 */
public class p15501 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static ArrayList<Integer>[] array1;
    static ArrayList<Integer>[] array2;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(reader.readLine());

        array1 = new ArrayList[n+1];
        array2 = new ArrayList[n+1];

        for (int i=1; i<n+1; i++) {
            array1[i] = new ArrayList<>();
            array2[i] = new ArrayList<>();
        }
        int idx = 2;
        while (idx-- > 0) {
            ArrayList<Integer>[] tmpArr = idx==1 ? array1 : array2;
            String[] tmp = reader.readLine().split(" ");

            for (int i=1; i<n+1; i++) {
                int x = Integer.parseInt(tmp[i-1]);
                int y = Integer.parseInt(i >= n ? tmp[i-n] : tmp[i]);

                tmpArr[x].add(y);
                tmpArr[y].add(x);
            }
        }

        for (int i=1; i<n+1; i++) {
            for (int j=0; j<array1[i].size(); j++) {
                boolean isContained = false;
                for (int k=0; k<array2[i].size(); k++) {
                    if (Objects.equals(array1[i].get(j), array2[i].get(k))) {
                        isContained = true;
                    }
                }
                if (!isContained) {
                    System.out.println("bad puzzle");
                    System.exit(0);
                }
            }
        }

        System.out.println("good puzzle");

        reader.close();
    }
}
