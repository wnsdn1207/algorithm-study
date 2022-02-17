package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2941 - 크로아티아 알파벳
 */
public class p2941 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String alphabet = reader.readLine();

        alphabet = alphabet.replace("c=", "A")
                .replace("c-", "A")
                .replace("dz=", "A")
                .replace("d-", "A")
                .replace("lj", "A")
                .replace("nj", "A")
                .replace("s=", "A")
                .replace("z=", "A");

        System.out.println(alphabet.length());

        reader.close();
    }
}
