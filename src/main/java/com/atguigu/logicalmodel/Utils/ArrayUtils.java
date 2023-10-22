package com.atguigu.logicalmodel.Utils;


public class ArrayUtils {
    //将一个Integer[][]类型的数组转换为int[][]型的数组
    public static int[][] IntegerArrayToIntArray(Integer array[][]) {
        int rows = array.length;
        int cols = array[0].length;

        int[][] res = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] != null) {
                    res[i][j] = array[i][j];
                }
            }
        }

        return res;
    }
}
