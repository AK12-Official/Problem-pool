class Solution4 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
                || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean found = dfs(board, word, visited, i + 1, j, index + 1) ||
                dfs(board, word, visited, i - 1, j, index + 1) ||
                dfs(board, word, visited, i, j + 1, index + 1) ||
                dfs(board, word, visited, i, j - 1, index + 1);
        visited[i][j] = false; // backtrack
        // 如果不回溯，visited[i][j]会一直为true，导致后续的dfs无法找到正确的路径
        return found;
    }

}