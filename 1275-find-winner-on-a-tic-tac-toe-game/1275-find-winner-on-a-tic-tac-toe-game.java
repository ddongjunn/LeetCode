class Solution {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            if (i % 2 == 0) {
                board[x][y] = 'X';
            } else {
                board[x][y] = 'O';
            }
        }

        if (check(board, 'X')) return "A";
        if (check(board, 'O')) return "B";
        return moves.length == 9 ? "Draw" : "Pending";
    }

    public boolean check (char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            boolean row = true;
            boolean col = true;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != player) row = false;
                if (board[j][i] != player) col = false;
            }
            if (row || col) return true;
        }

        boolean diag1 = true;
        boolean diag2 = true;
        for (int i = 0; i < 3; i++) {
            if (board[i][i] != player) diag1 = false;
            if (board[i][3 - 1 - i] != player) diag2 = false;
        }
        return diag1 || diag2;
    }
}