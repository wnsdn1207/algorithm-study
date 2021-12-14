package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 10610 - 30
 */
public class p10610 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static String[] numbers;
    static boolean[] visited;

    static List<Long> output = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        numbers = reader.readLine().split("");

        int result = 0;
        boolean hasZero = false;
        for (String s : numbers) {
            int num = Integer.parseInt(s);
            result += num;

            if (num == 0) {
                hasZero = true;
            }
        }

        if (hasZero) {
            if (result % 3 == 0) {
                Arrays.sort(numbers);
                for (int i=numbers.length-1; i>=0; i--) {
                    sb.append(numbers[i]);
                }
                System.out.println(sb);
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(-1);
        }

//        visited = new boolean[numbers.length];
//        char[] temp = new char[numbers.length];
//        System.out.println("### Combination ###");
//        combination(numbers, visited, 0, numbers.length, numbers.length);
//        System.out.println();
//        System.out.println("### Permutation ###");
//        permutation(numbers, temp, visited, 0, numbers.length, numbers.length);
//        System.out.println(Arrays.toString(output.toArray()));
//        Collections.sort(output);
//        Collections.reverse(output);
//        System.out.println(Arrays.toString(output.toArray()));
//        if (output.size() > 0) {
//            System.out.println(output.get(0));
//        } else {
//            System.out.println(-1);
//        }

        reader.close();
    }

    static void combination(char[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void permutation(char[] arr, char[] temp, boolean[] visited, int start, int n, int r) {
        if (r == start) {
//            print(temp);
            checkAnswer(temp);
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                temp[start] = arr[i];
                visited[i] = true;
                permutation(arr, temp, visited, start+1, n, r);
                visited[i] = false;
            }
        }
    }

    static void checkAnswer(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
//        System.out.println("sb : "+sb);

        if (sb.length() > 0) {
            long result = Long.parseLong(sb.toString());
            if (result % 30 == 0) {
                output.add(result);
            }
        }
    }

    static void print(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }

    static void print(char[] arr, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                sb.append(arr[i]);
            }
        }
        System.out.println(sb);
    }
}
