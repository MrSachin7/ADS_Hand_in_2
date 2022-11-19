import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void destroy() {

    }


    @Test
    void solutionDoesNotExistForABoardOfSize3() {
        ChessBoard board = new ChessBoard(3);
        assertFalse(board.solveBoard());

    }

    @Test
    void solutionDoesExistForABoardOfSizeMoreThan4() {
        ChessBoard board1 = new ChessBoard(4);
        ChessBoard board2 = new ChessBoard(8);
        ChessBoard board3 = new ChessBoard(10);

       assertTrue(board1.solveBoard());
       assertTrue(board2.solveBoard());
       assertTrue(board3.solveBoard());
    }

    @Test
    void solutionReturnedIsACorrectSolution() {
        ChessBoard board1 = new ChessBoard(4);
        board1.solveBoard();
        int[][] solvedBoard1 = board1.getBoard();
        int[][] possibleSolution1 = {{0, 0, 1, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}};
        int[][] possibleSolution2 = {{0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 0, 1, 0}};


       boolean equalsToFirst= checkForEquality(solvedBoard1, possibleSolution1);


        boolean equalsSecond= checkForEquality(solvedBoard1, possibleSolution2);

        boolean expected = equalsSecond || equalsToFirst;

        assertTrue(expected);

    }

    private boolean checkForEquality(int[][] board1, int[][] board2) {

        for (int i = 0; i < board1.length; i++) {
            for (int j = 0; j < board1.length; j++) {
                if (board1[i][j] != board2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }


}