package com.snippet.algo.dfs;

/**
 * create by whr on 2023-07-09
 */
public class LC200_numIslands {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private int[] dx = new int[]{0, 1, -1, 0};
    private int[] dy = new int[]{1, 0, 0, -1};

    private void dfs(char[][] grid, int x, int y) {
        if (x >= grid.length || y >= grid[0].length || x < 0 || y < 0) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '2';
        } else {
            return;
        }
        for (int j = 0; j < 4; j++) {
            dfs(grid, x + dx[j], y + dy[j]);
        }
    }

    public static void main(String[] args) {
        new LC200_numIslands().numIslands(new char[][]{{'1'}, {'0'}, {'1'}, {'0'}, {'1'}, {'1'}});
    }
}
