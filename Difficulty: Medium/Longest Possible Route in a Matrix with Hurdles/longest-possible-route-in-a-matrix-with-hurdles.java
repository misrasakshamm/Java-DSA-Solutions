class Solution {
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        // code here
        // Edge cases: empty matrix, or source/destination is blocked
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return -1;
        }
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }

        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] maxPath = new int[]{-1};

        // Start backtracking from the source cell
        dfs(mat, n, m, xs, ys, xd, yd, visited, 0, maxPath);

        return maxPath[0];
    }

    private void dfs(int[][] mat, int n, int m, int r, int c, int xd, int yd, 
                     boolean[][] visited, int currentLength, int[] maxPath) {
        // If we reach the destination, evaluate the path length
        if (r == xd && c == yd) {
            maxPath[0] = Math.max(maxPath[0], currentLength);
            return;
        }

        // Mark the current cell as visited
        visited[r][c] = true;

        // Direction vectors for moving Up, Down, Left, and Right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // Check boundaries, if the cell is traversable (1), and not visited yet
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(mat, n, m, nr, nc, xd, yd, visited, currentLength + 1, maxPath);
            }
        }

        // Backtrack: Unmark the cell for other potential path combinations
        visited[r][c] = false;
    }
}

    
