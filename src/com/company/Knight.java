package com.company;

public class Knight {

    // Board size
    public static int boardSize;
    // Chessboard
    public static int[][] chessBoard;

    private static int FREE = 0, USED = 1;

    private static boolean isValid(int x, int y) {
        // See if the move is on the board
        if (boardSize <= x || boardSize <= y || x < 0 || y < 0) {
            return false;
        }
        return true;
    }

    public static boolean findWay(int x, int y, int moveCount) {

        // Possible moves
        int moveX[] = { 2, 1, -1, -2, -2, -1,  1,  2 , 2 };
        int moveY[] = { 1, 2,  2,  1, -1, -2, -2, -1, 1 };

        // All spots visited
        if (moveCount == (boardSize * boardSize)) {
            chessBoard[x][y] = boardSize * boardSize;
            return true;
        }

        // First position taken
        chessBoard[x][y] = USED;

            // 8 possible moves
            for (int i = 0; i < 8; i++) {

                // Calculate next possible position
                int nextX = x + moveX[i];
                int nextY = y + moveY[i];

                // Check if next move i valid, and that the position is not taken
                if (isValid(nextX, nextY) && chessBoard[nextX][nextY] == FREE) {

                    // Find next move and add one move
                    if (findWay(nextX, nextY, moveCount + 1)) {

                        // Set the position to the current move count
                        chessBoard[x][y] = moveCount;
                        return true;
                    }
                }
            }
            // Set the position to be free
            chessBoard[x][y] = FREE;
            return false;
    }
}
