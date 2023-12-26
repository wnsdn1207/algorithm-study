package own.junn.y2022.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 14612 - 김식당
 */
public class p14612 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static List<Order> orderList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            String[] tmp = reader.readLine().split(" ");

            if (tmp[0].equalsIgnoreCase("ORDER")) {
                orderList.add(new Order(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
            } else if (tmp[0].equalsIgnoreCase("SORT")) {
                Collections.sort(orderList);
            } else {
//                orderList.removeIf(order -> order.tableNo == Integer.parseInt(tmp[1]));
                for (int j=0; j<orderList.size(); j++) {
                    if (orderList.get(j).tableNo == Integer.parseInt(tmp[1])) {
                        orderList.remove(j);
                        break;
                    }
                }
            }
            print();
        }

        reader.close();
    }

    static void print() {
        if (orderList.size() == 0) {
            System.out.println("sleep");
            return;
        }
        for (Order order : orderList) {
            sb.append(order.tableNo).append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
        sb.setLength(0);
    }

    static class Order implements Comparable<Order> {
        private String type;
        private int tableNo;
        private int orderTm;

        public Order(String type, int tableNo, int orderTm) {
            this.type = type;
            this.tableNo = tableNo;
            this.orderTm = orderTm;
        }

        @Override
        public int compareTo(Order o) {
            return this.orderTm - o.orderTm;
        }
    }
}
