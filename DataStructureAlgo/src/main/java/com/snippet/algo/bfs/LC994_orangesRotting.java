package com.snippet.algo.bfs;

import java.util.ArrayDeque;

/**
 * create by whr on 2023-07-02
 */
public class LC994_orangesRotting {

    // 步进坐标
    int[] rowStep = new int[]{1, -1, 0, 0};
    int[] colStep = new int[]{0, 0, -1, 1};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        // 获取第一层所有腐烂橘子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    // 找到最近的腐烂橘子，并记录时间
                    int com = i * n + j;
                    queue.add(com);
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            // 下一层的腐烂橘子队列
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            // 标记此层是否有感染
            boolean findAtLeastOne = false;
            // 将当前层全部遍历完成，视为当前这一分钟发生的感染
            while (!queue.isEmpty()) {
                int cur = queue.pop();
                int x = cur / n;
                int y = cur % n;
                for (int i = 0; i < 4; i++) {
                    int newX = x + rowStep[i];
                    int newY = y + colStep[i];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        if (grid[newX][newY] == 1) {
                            findAtLeastOne = true;
                            grid[newX][newY] = 2;
                            tmp.add(newX * n + newY);
                        }
                    }
                }
            }
            // 下一层
            queue = tmp;
            // 发生法感染则+1
            count += findAtLeastOne ? 1 : 0;
        }
        // 依然存在新鲜，则返回-1
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}
