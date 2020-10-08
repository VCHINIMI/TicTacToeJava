import java.util.Scanner;

public class TieTacToe {
	public static Scanner userInputScanner = new Scanner(System.in);

//Initialising Game Board	
	public static char[] createGameBoard() {
		char[] gameBoard = new char[10];
		for (int index = 1; index < 10; index++) {
			gameBoard[index] = ' ';
		}
		return gameBoard;
	}

//Choose inGameCharacter by USER
	public static char userGameCharacter() {
		System.out.println("Choose Character X or O");
		char userCharacter = userInputScanner.next().charAt(0);
		return userCharacter;
	}
	
	//Main Method	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Program");
		createGameBoard();
		char userInGameCharacter = userGameCharacter();
		char compInGameCharacter = ' ';
		if(userInGameCharacter == 'X')
			compInGameCharacter = 'O';
		else
			compInGameCharacter = 'X';
		System.out.println(userInGameCharacter+" "+compInGameCharacter);
		
	}
}
