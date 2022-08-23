package Graph;

class Solution
{
    public int xShape(char[][] grid)
    {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int shapes = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 'X' && (!visited[i][j])) {
                    shapes++;
                    DFS(grid, visited, i, j);
                }
            }
        }

        return shapes;
    }

    public void DFS(char[][] grid, boolean[][] visited, int i, int j) {

        int n = grid.length, m = grid[0].length;
        if (i<0 || i>=n || j<0 || j>=m || grid[i][j] == 'O' || visited[i][j]) return;

        visited[i][j] = true;

        DFS(grid, visited, i-1, j);
        DFS(grid, visited, i, j-1);
        DFS(grid, visited, i+1, j);
        DFS(grid, visited, i, j+1);
    }
}

class XTotalShapes
{
    public static void main(String[] args) {

        char[][] grid = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'X'}
        };

        Solution o = new Solution();
        int ans = o.xShape(grid);
        System.out.println(ans);
    }
}