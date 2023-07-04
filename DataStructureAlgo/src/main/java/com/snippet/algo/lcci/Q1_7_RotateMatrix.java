package com.snippet.algo.lcci;

import java.util.Arrays;

/**
 * create by whr on 2023-04-06
 */
public class Q1_7_RotateMatrix {
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] copy = new int[length][length];
        for (int i = 0; i < length; i++) {
            copy[i] = Arrays.copyOf(matrix[i], length);
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = copy[length - j -1][i];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
    }
}