package com.snippet.algo.lcci;

import java.util.ArrayList;
import java.util.List;

/**
 * create by whr on 2023-04-06
 */
public class Q1_8_SetZeroes {
    public void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                    continue;
                }
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
    }
}
