import java.util.Arrays;

public class ChessBoard {


    private int boardSize;
    private int[][] board;


    // Creates an empty chessboard with the provided size
    public ChessBoard(int boardSize) {
        this.boardSize = boardSize;
        board = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] =0;
            }
        }

    }

    public int[][] getBoard() {
        return board;
    }

    // Creates a board with already provided values
    public ChessBoard(int[][] board) {

        this.board = board;
        boardSize = board.length;
    }

    // 1 refers to queen being in the position, 0 refers to no queen
    public void printBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print("\t" + board[i][j]);
            }
            System.out.println();

        }
    }


    public boolean solveBoard(){

        if (!placeQueenOnColumn(0)){
            System.out.println("Solution doesnt exist for the provided board size");
            return false;
        }

        System.out.println("The following is the solution for the provided board size...\n\n");
        printBoard();
        return true;
    }

    private boolean placeQueenOnColumn(int column) {

        // This is when the board is already solved since we are starting from column 0
        if (column >= boardSize){
            return true;
        }

        // Here we try to place the queen in literally all rows of the column
        for (int i = 0; i < boardSize; i++) {

            if (isSafeToPlaceQueen(i, column)){
                // If safe, then place the queen
                board[i][column] =1;

                // Keep using recursion to place other queens
                if (placeQueenOnColumn(column+1)) {
                    return true;
                }
                    // If not , we have to backtrack
                    board[i][column] =0;


            }
        }
        // If queen cannot be placed on any row of the provided column, then
        // there is no solution for the board since, all column must have
        // one and only one queen
        return false;
    }


    public boolean isSafeToPlaceQueen(int row, int column){

        int i ;
        int j;

        // Check the row in left sides....
        for  (i = 0; i < column; i++) {
            if (board[row][i] ==1){
                return false;
            }
        }

        // Check upper part of diagonal
        for (i =row, j =column; i>=0 && j>= 0 ; i--, j--){
            if (board[i][j] ==1){
                return false;
            }
        }

        // Check lower part of diagonal
        for(i =row, j=column; j>=0 && i<boardSize; i++, j--){
            if (board[i][j]==1) return false;
        }
        // If the queen is not in any of the above,
        // it is safe to place the queen on the given row and column

        return true;

    }

    public boolean equals(ChessBoard chessBoard){
        return Arrays.equals(chessBoard.board, this.board);
    }


}
