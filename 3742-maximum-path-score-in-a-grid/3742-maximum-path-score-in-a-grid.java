class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int startCost = grid[0][0] == 0 ? 0 : 1;
        int startScore = grid[0][0];

        if (startCost <= k) {
            dp[0][0][startCost] = startScore;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int cost = grid[i][j] == 0 ? 0 : 1;
                int score = grid[i][j];

                for (int c = cost; c <= k; c++) {
                    int best = -1;

                    if (i > 0 && dp[i - 1][j][c - cost] != -1) {
                        best = Math.max(best, dp[i - 1][j][c - cost] + score);
                    }

                    if (j > 0 && dp[i][j - 1][c - cost] != -1) {
                        best = Math.max(best, dp[i][j - 1][c - cost] + score);
                    }

                    dp[i][j][c] = best;
                }
            }
        }

        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m - 1][n - 1][c]);
        }
        return ans;
    }
}