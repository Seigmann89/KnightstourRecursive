package com.company;

import java.util.Scanner;

import static com.company.Knight.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] startPos = new int[2];
        int startX, startY;

        System.out.println("Enter size of chessboard: ");
        boardSize = input.nextInt();

        // Initialize the board
        chessBoard = new int[boardSize][boardSize];

        System.out.println("Enter start position: ");
        // Checking for start position
        for (int i = 0; i < 2; i++) {
            startPos[i] = input.nextInt();
        }

        // Tilegner X og Y sine posisjoner fra listen startPos
        startX = startPos[0];
        startY = startPos[1];

        System.out.println("Starting position: " + startX + "," + startY);

        // Add solution to "foundWay" and use it later to check if it's true or not
        boolean foundWay = findWay(startX, startY, 1);

        // Runs through board and prints out
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                    System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println();

        // Checks if the board could be completed or not
        if (!foundWay) {
            System.out.println("Board could not be completed!");
        }
    }
}