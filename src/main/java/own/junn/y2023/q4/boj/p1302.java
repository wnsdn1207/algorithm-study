package own.junn.y2023.q4.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class p1302 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(reader.readLine());

        Map<String, BookStoreHistory> bookStoreHistoryMap = new HashMap<>();
        for (int i=0; i<N; i++) {
            String bookName = reader.readLine();

            // bookName별로 bookName, countOfSales 값을 가지는 객체를 매핑시킨다.
            // 판매된 bookName을 읽을 때마다 매핑되는 각 객체의 countOfSales 변수를 1씩 증가시킨다.
            bookStoreHistoryMap
                    .computeIfAbsent(bookName, k -> new BookStoreHistory(bookName, 0))
                    .setCountOfSales(bookStoreHistoryMap.get(bookName).getCountOfSales() + 1);
        }

        // 내부 Comparable 구현으로 자동정렬 시킨다.
        BookStoreHistory bestSeller = bookStoreHistoryMap.values()
                .stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(IllegalAccessError::new);

        System.out.println(bestSeller.getBookName());

        reader.close();

    }

    public static class BookStoreHistory implements Comparable<BookStoreHistory> {

        private final String bookName;

        private int countOfSales;

        public BookStoreHistory(String bookName, int countOfSales) {
            this.bookName = bookName;
            this.countOfSales = countOfSales;
        }

        public String getBookName() {
            return this.bookName;
        }

        public int getCountOfSales() {
            return countOfSales;
        }

        public void setCountOfSales(int countOfSales) {
            this.countOfSales = countOfSales;
        }

        @Override
        public String toString() {
            return "BookStoreHistory{" +
                    "bookName='" + bookName + '\'' +
                    ", countOfSales=" + countOfSales +
                    '}';
        }

        @Override
        public int compareTo(BookStoreHistory o) {
            // natural comparing
            int countDiff = this.countOfSales - o.countOfSales;
            if (countDiff != 0) {
                return countDiff;
            }

            char[] o1Chars = this.bookName.toCharArray();
            char[] o2Chars = o.bookName.toCharArray();
            int minLength = Math.min(o1Chars.length, o2Chars.length);

            // 문자열이 여러개 같을 수 있으므로 마지막 문자까지 순회
            // 사전순이므로 단어가 클수록 우선순위가 낮기 때문에, 역비교를 진행한다.
            // 역비교 결과가 같지 않을 시에만 반환한다.
            for (int i=0; i<minLength; i++) {
                // reverse comparing
                int charDiff = o2Chars[i] - o1Chars[i];
                if (charDiff != 0) {
                    return charDiff;
                }
            }

            // 이 단계까지 왔다면, length가 짧은 것이 우선순위가 높다.
            // 따라서, 역비교를 진행한다.
            return o2Chars.length - o1Chars.length;
        }
    }
}
