package own.junn.boj;

import java.io.*;
import java.util.*;

/**
 * 9322 - 철벽 보안 알고리즘
 */
public class Problem_9322 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(reader.readLine());

            String[] pubKey1 = reader.readLine().split(" ");
            String[] pubKey2 = reader.readLine().split(" ");
            int[] hint = new int[n];

            for (int x=0; x<n; x++) {
                for (int y=0; y<n; y++) {
                    if (pubKey2[x].equalsIgnoreCase(pubKey1[y])) {
                        hint[x]=y-x;
                        break;
                    }
                }
            }
            String[] password = reader.readLine().split(" ");
            String[] result = new String[n];

            for (int x=0; x<n; x++) {
                result[x+hint[x]] = password[x];
            }

            StringBuilder sb = new StringBuilder();
            for (String s : result) {
                sb.append(s).append(" ");
            }
            sb.setLength(sb.length()-1);
            System.out.println(sb);
        }
    }
}
