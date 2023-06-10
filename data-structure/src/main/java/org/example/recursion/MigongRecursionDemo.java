package org.example.recursion;

public class MigongRecursionDemo {

    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == 0 || i == map.length - 1 || j == 0 || j == map[i].length - 1) {
                    map[i][j] = 1;
                }
            }
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;
        map[2][3] = 1;
        show(map);
        boolean recursion = recursion(1, 1, map);
        if (recursion) {
            System.out.println("逃跑路线");
            show(map);
        } else {
            System.out.println("失败了");
        }

    }

    private static void show(int[][] map) {
        for (int[] ints : map) {
            for (int point : ints) {
                System.out.printf("%d\t", point);
            }
            System.out.println();
        }
    }

    /**
     * 定义开始位置 i，j r
     * 策略 下右上左
     */

    public static boolean recursion(int i, int j, int[][] map) {
        if (i == map.length - 2 && j == map[0].length - 2) {
            map[i][j]=2;
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (recursion(i + 1, j, map)) {
                return true;
            } else if (recursion(i, j + 1, map)) {
                return true;
            } else if (recursion(i - 1, j, map)) {
                return true;
            } else if (recursion(i , j-1, map)) {
                return true;
            }else {
                map[i][j] = 3;
                return false;
            }
        }else {
            return false;
        }

    }



}
