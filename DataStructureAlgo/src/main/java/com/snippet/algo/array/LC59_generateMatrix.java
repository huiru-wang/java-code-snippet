package com.snippet.algo.array;

/**
 * create by whr on 2023-07-21
 */
public class LC59_generateMatrix {
    public static int[][] generateMatrix(int n) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int[][] ans = new int[n][n];
        int x = 0, y = -1, count = 1, direct = 0;
        while (count <= n * n) {
            for (int i = direct; ; ) {
                x += dx[i];
                y += dy[i];
                if (x < 0 || x > n - 1 || y < 0 || y > n - 1 || ans[x][y] != 0) {
                    x -= dx[i];
                    y -= dy[i];
                    break;
                }
                ans[x][y] = count++;
            }
            direct = direct == 3 ? 0 : direct + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        generateMatrix(4);
    }
}
