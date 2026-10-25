class Solution {
    public boolean solveSudoku(char[][] board) {
          for (int row = 0; row<9; row++) {
              for(int column = 0; column<9; column++) {
                  if(board[row][column] == '.') {
                      for(char numberToTry = '1'; numberToTry <= '9'; numberToTry++) {
                          if(isValidPlacement(board, numberToTry,row,column)) {
                              board[row][column] = numberToTry;
                              if(solveSudoku(board)) {
                                  return true;
                              }
                              else {
                                  board[row][column] = '.';
                              }
                          }
                      }
                      return false;
                  }
              }
          }  
        return true;
    }
    public boolean isNumberInRow(char[][] board, int number, int row) {
        for(int i = 0; i<9; i++) {
            if(board[row][i] == number) {
                return true;
            }
        }
        return false;
    }
    public boolean isNumberInColumn(char[][] board, int number, int column) {
        for(int i=0; i<9; i++) {
            if(board[i][column] == number) {
                return true;
            }
        }
        return false;
    }
    public boolean isNumberInBox(char [][] board, int number, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;
        for(int i = localBoxRow; i<localBoxRow +3; i++) {
            for(int j = localBoxColumn; j<localBoxColumn + 3; j++) {
                if(board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isValidPlacement(char[][]board, int number, int row, int column) {
        return !isNumberInRow(board, number, row) &&
            !isNumberInColumn(board, number, column) &&
            !isNumberInBox(board, number, row, column);
    }
}