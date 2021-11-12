package own.junn.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2615 - 오목
 */
public class p2615 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[][] map = new int[19][19];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        for (int i=0; i<map.length-1; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j=0; j<input.length; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[i].length; j++) {
                if (isStone(map[i][j]) && isWinner(i, j, map)) {
                    sb.append(map[i][j])
                      .append("\n")
                      .append(i+1)
                      .append(" ")
                      .append(j+1);
                    break;
                }
            }

            if (sb.length()>0) {
                break;
            }
        }
        System.out.println(sb.length() > 0 ? sb : "0");

        reader.close();
    }

    static boolean isWinner(int x, int y, int[][] map) {
        return verticalWin(x, y, map) ||
                horizontalWin(x, y, map) ||
                rightDiagonalWin(x, y, map) ||
                leftDiagonalWin(x, y, map);
    }

    static boolean verticalWin(int x, int y, int[][] map) {
        for (int i=1; i<5; i++) {
            int a = x+(i-1);
            int b = x+i;

            if (!isValidRange(a, y) || !isValidRange(b, y)) {
                return false;
            }

            if (map[a][y] != map[b][y]) {
                return false;
            }
        }

        if (!isValidRange(x-1, y) && !isValidRange(x+5, y)) {
            return true;
        } else if (!isValidRange(x-1, y)) {
            return isValidRange(x+5, y) && map[x][y] != map[x+5][y];
        } else {
            return isValidRange(x-1, y) && map[x][y] != map[x-1][y];
        }
    }

    static boolean horizontalWin(int x, int y, int[][] map) {
        for (int i=1; i<5; i++) {
            int a = y+(i-1);
            int b = y+i;

            if (!isValidRange(x, a) || !isValidRange(x, b)) {
                return false;
            }

            if (map[x][a] != map[x][b]) {
                return false;
            }
        }

        if (!isValidRange(x, y-1) && !isValidRange(x, y+5)) {
            return true;
        } else if (!isValidRange(x, y-1)) {
            return isValidRange(x, y+5) && map[x][y] != map[x][y+5];
        } else {
            return isValidRange(x, y-1) && map[x][y] != map[x][y-1];
        }
    }

    static boolean rightDiagonalWin(int x, int y, int[][] map) {
        for (int i=1; i<5; i++) {
            int ax1 = x+(i-1);
            int ay1 = y+(i-1);
            int ax2 = x+i;
            int ay2 = y+i;

            if (!isValidRange(ax1, ay1) || !isValidRange(ax2, ay2)) {
                return false;
            }

            if (map[ax1][ay1] != map[ax2][ay2]) {
                return false;
            }
        }

        if (!isValidRange(x-1, y-1) && !isValidRange(x+5, y+5)) {
            return true;
        } else if (!isValidRange(x-1, y-1)) {
            return isValidRange(x+5, y+5) && map[x][y] != map[x+5][y+5];
        } else {
            return isValidRange(x-1, y-1) && map[x][y] != map[x-1][y-1];
        }
    }

    static boolean leftDiagonalWin(int x, int y, int[][] map) {
        for (int i=1; i<5; i++) {
            int ax1 = x+(i-1);
            int ay1 = y-(i-1);
            int ax2 = x+i;
            int ay2 = y-i;

            if (!isValidRange(ax1, ay1) || !isValidRange(ax2, ay2)) {
                return false;
            }

            if (map[ax1][ay1] != map[ax2][ay2]) {
                return false;
            }
        }

        if (!isValidRange(x-1, y+1) && !isValidRange(x+5, y-5)) {
            return true;
        } else if (!isValidRange(x-1, y+1)) {
            return isValidRange(x+5, y-5) && map[x][y] != map[x+5][y-5];
        } else {
            return isValidRange(x-1, y+1) && map[x][y] != map[x-1][y+1];
        }
    }

    static boolean isValidRange(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }

    static boolean isStone(int n) {
        return n==1 || n==2;
    }
}
