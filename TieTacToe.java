import java.util.Scanner;

public class TieTacToe {
	
	public static char[] createGameBoard() {
		char[] gameBoard = new char[10];
		for(int index = 1; index < 10;index++) {
			gameBoard[index] = ' ';
		}
		return gameBoard;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Program");
		createGameBoard();
	}
}
