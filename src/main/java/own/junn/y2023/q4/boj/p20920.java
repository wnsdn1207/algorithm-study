package own.junn.y2023.q4.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class p20920 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Word> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            String word = reader.readLine();
            if (word.length() < M) {
                continue;
            }

            map.computeIfAbsent(word, k -> new Word(word, word.length()))
                    .incrementCount();
        }

        PriorityQueue<Word> priorityQueue = new PriorityQueue<>(map.values());
        while (priorityQueue.size() > 0) {
            writer.write(priorityQueue.poll().word + "\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }

    public static class Word implements Comparable<Word> {

        private final String word;

        private final int length;

        private int count;

        public Word(String word, int length) {
            this.word = word;
            this.length = length;
            this.count = 0;
        }

        public void incrementCount() {
            this.count += 1;
        }

        @Override
        public int compareTo(Word o) {
            int countDiff = o.count - this.count;
            if (countDiff != 0) {
                return countDiff;
            }

            int lengthDiff = o.length - this.length;
            if (lengthDiff != 0) {
                return lengthDiff;
            }

            char[] originChars = this.word.toCharArray();
            char[] comparisonChars = o.word.toCharArray();

            for (int i=0; i<originChars.length; i++) {
                int charDiff = originChars[i] - comparisonChars[i];
                if (charDiff != 0) {
                    return charDiff;
                }
            }

            return 0;
        }
    }
}