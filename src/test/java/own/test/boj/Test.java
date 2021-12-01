package own.test.boj;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.awt.*;
import java.io.FileReader;
import java.util.*;
import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    void gsonTest() throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonReader reader = new JsonReader(new FileReader("test.json"));
        List<TestVO> vo = gson.fromJson(reader, ArrayList.class);

        System.out.println(gson.toJson(vo));
    }

    class TestVO {
        transient String codeGrpId;
        String codeId;
        transient String codeName;
        transient String sortOrder;
        transient String useYn;
        boolean status;

        @Override
        public String toString() {
            return "TestVO{" +
                    "codeGrpId='" + codeGrpId + '\'' +
                    ", codeId='" + codeId + '\'' +
                    ", codeName='" + codeName + '\'' +
                    ", sortOrder='" + sortOrder + '\'' +
                    ", useYn='" + useYn + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    @org.junit.jupiter.api.Test
    void charMethodTest() throws Exception {
        String test = "";

//        Character.isDigit(charAt(s, start))

//        System.out.println(test.toCharArray());

        System.out.println(Character.isLetterOrDigit('c'));
        System.out.println(Character.isLetterOrDigit('1'));
        System.out.println(Character.isLetterOrDigit('7'));
        System.out.println(Character.isLetterOrDigit('A'));
        System.out.println(Character.isLetterOrDigit(' '));
        System.out.println(Character.isLetterOrDigit('S'));
    }

    @org.junit.jupiter.api.Test
    void fillArrayTest() throws Exception {
        int[][] map = new int[5][5];
        int[] array = new int[5];

        Arrays.fill(array, -1);
        Arrays.fill(map, array);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.deepToString(map));

        int[] tmp = array.clone();
        System.out.println(Arrays.toString(tmp));
    }

    @org.junit.jupiter.api.Test
    void numbersTest() throws Exception {
//        for (int i=1; i<5; i++) {
//            for (int j=0; j<2*i; j++) {
//                System.out.println(i);
//            }
//        }

        for (int i=1; i<3; i++) {
            for (int j=1; j<6; j++) {
                System.out.println(j);
            }
            for (int j=5; j>=0; j--) {
                System.out.println(j);
            }
        }
    }

    @org.junit.jupiter.api.Test
    void pointTest() throws Exception {
        System.out.println(new Point(0, 0).distance(new Point(1, 1)));
        System.out.println((int) new Point(0, 0).distanceSq(new Point(1, 1)));
        System.out.println(Point.distanceSq(1, 1, 0, 0));
    }

    @org.junit.jupiter.api.Test
    void priorityQueueTest() throws Exception {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(8);
        queue.add(4);
        queue.add(6);
        queue.add(6);
        queue.add(8);
        queue.add(9);
        queue.add(1);

        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }
    }

    @org.junit.jupiter.api.Test
    void loopTest() {
        int[] words = {2, 3, 5};

        for (int i=0; i<words.length; i++) {
            for (int j=0; j< words.length; j++) {
                for (int k=0; k< words.length; k++) {
                    if (i != j && j != k && k != i) {
                        System.out.print(words[i]);
                        System.out.print(words[j]);
                        System.out.print(words[k]);
                        System.out.println();
                    }
                }
            }
        }
    }

    @org.junit.jupiter.api.Test
    void intTest() {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//
//        priorityQueue.add(1);
//        priorityQueue.add(4);
//        priorityQueue.add(8);
//        priorityQueue.add(3);
//
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());

        int t1 = -5;
        int t2 = 5;

        System.out.println(--t1);
        System.out.println(--t2);
    }

    @org.junit.jupiter.api.Test
    void dequeTest() {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addLast(4);
        System.out.println(Arrays.toString(deque.toArray()));
        deque.pollLast();
        deque.pollLast();
        System.out.println(Arrays.toString(deque.toArray()));
        deque.pollFirst();
        System.out.println(Arrays.toString(deque.toArray()));
    }

    @org.junit.jupiter.api.Test
    void listTest() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        long begin = System.currentTimeMillis(), end;
        for (int i=0; i<100000; i++) {
            arrayList.add(i);
        }
        end = System.currentTimeMillis();

        System.out.println("arrayList add elapsed : " + (end - begin));

        begin = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
            linkedList.add(i);
        }
        end = System.currentTimeMillis();

        System.out.println("linkedList add elapsed : " + (end - begin));

        begin = System.currentTimeMillis();
        for (int i=0; i<arrayList.size(); i++) {
            arrayList.remove(0);
        }
        end = System.currentTimeMillis();

        System.out.println("arrayList get elapsed : " + (end - begin));

        begin = System.currentTimeMillis();
        for (int i=0; i<linkedList.size(); i++) {
            linkedList.remove(0);
        }
        end = System.currentTimeMillis();

        System.out.println("linkedList get elapsed : " + (end - begin));
    }

    @org.junit.jupiter.api.Test
    public void charTest() {
        System.out.println(ctoi('.'));
        System.out.println(ctoi('#'));
        System.out.println(ctoi('v'));
        System.out.println(ctoi('k'));
    }

    public int ctoi(char c) {
        return c;
    }

    @org.junit.jupiter.api.Test
    public void intTest2() {
        int a = 1012;

        for (int i=0; i<5; i++) {
            int mod = a%10;
            a /= 10;
            System.out.println(mod);
        }


        int b = 1;

        System.out.println(b * -3);

    }

    @org.junit.jupiter.api.Test
    public void rangeTest() {
        int a = Integer.MAX_VALUE;
        long b = Long.MAX_VALUE;
        double c = Double.MAX_VALUE;
        float d = Float.MAX_VALUE;

        System.out.println(a < b);
        System.out.println(b < c);
        System.out.println(b < d);
    }

    @org.junit.jupiter.api.Test
    public void arrayListTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(5);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(4);

        int count = 0;
        System.out.println(Arrays.toString(list.toArray()));

        int tmp = list.get(list.size()-1);
        list.remove(list.size()-1);
        list.add(2, tmp);

        count++;
        System.out.println(Arrays.toString(list.toArray()));

        tmp = list.get(1);
        list.remove(1);
        list.add(list.size(), tmp);
        count++;
        System.out.println(Arrays.toString(list.toArray()));

        tmp = list.get(list.size()-2);
        list.remove(list.size()-2);
        list.add(4, tmp);
        count++;
        System.out.println(Arrays.toString(list.toArray()));

        tmp = list.get(list.size()-2);
        list.remove(list.size()-2);
        list.add(4, tmp);
        count++;
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(count);

    }

    @org.junit.jupiter.api.Test
    void getLIS() throws Exception {
        int[] numbers = {10, 20, 10, 30, 20, 50, 80};

        int[] dp = new int[numbers.length];

        int max = 0;
        dp[0] = 1;

        for (int i=1; i< numbers.length; i++) {
            dp[i] = 1;

            for (int j=0; j<i; j++) {
                if (numbers[i] > numbers[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
