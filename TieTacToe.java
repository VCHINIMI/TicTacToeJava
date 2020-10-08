import java.util.Random;
import java.util.Scanner;

public class TieTacToe {
	public static Scanner userInputScanner = new Scanner(System.in);

	public enum Player {
		COMPUTER, USER
	};

//Who shall Play first, toss
	public static Player whoShallPlayFirst() {
		Random random = new Random();
		int toss = random.nextInt(2);
		if (toss == 0)
			return Player.USER;
		else
			return Player.COMPUTER;
	}

//Display board feature
	public static void displayBoard(char[] gameBoard) {
		System.out.println("\n");
		System.out.println(gameBoard[1] + "|" + gameBoard[2] + "|" + gameBoard[2]);
		System.out.println("-----");
		System.out.println(gameBoard[4] + "|" + gameBoard[5] + "|" + gameBoard[6]);
		System.out.println("-----");
		System.out.println(gameBoard[7] + "|" + gameBoard[8] + "|" + gameBoard[9]);
	}
	
//Winning conditions
	public static boolean isWinner(char[] board, char userCharacter) {
		return (board[1] == userCharacter && board[2] == userCharacter && board[3] == userCharacter
				|| board[4] == userCharacter && board[5] == userCharacter && board[6] == userCharacter
				|| board[7] == userCharacter && board[8] == userCharacter && board[9] == userCharacter
				|| board[1] == userCharacter && board[4] == userCharacter && board[7] == userCharacter
				|| board[2] == userCharacter && board[5] == userCharacter && board[8] == userCharacter
				|| board[3] == userCharacter && board[6] == userCharacter && board[9] == userCharacter
				|| board[1] == userCharacter && board[5] == userCharacter && board[9] == userCharacter
				|| board[3] == userCharacter && board[5] == userCharacter && board[7] == userCharacter);
	}

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

//check if cell is empty
	public static boolean isCellEmpty(int index, char[] board) {
		if (board[index] == ' ')
			return true;
		else
			return false;
	}

//Get Users' next Move
	public static int getNextUserMove(char board[]) {
		while (true) {
			System.out.println("Enter next Move");
			int userNextMove = userInputScanner.nextInt();
			if (userNextMove > 0 && userNextMove <= 9 && isCellEmpty(userNextMove, board))
				return userNextMove;
		}
	}

//User Make Move
	public static void intitiateMove(char[] board, int index, char userCharacter) {
		if (isCellEmpty(index, board))
			board[index] = userCharacter;
	}

// Main Method
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Program");
		Player player = whoShallPlayFirst();
		System.out.println(player);
		char[] gameBoard = createGameBoard();
		char userInGameCharacter = userGameCharacter();
		char compInGameCharacter = ' ';
		if (userInGameCharacter == 'X')
			compInGameCharacter = 'O';
		else
			compInGameCharacter = 'X';
		intitiateMove(gameBoard, getNextUserMove(gameBoard), userInGameCharacter);
		for(int i = 0; i <4;i++) {
			gameBoard[i]='X';
		}
		System.out.println(isWinner(gameBoard, 'X'));
		displayBoard(gameBoard);
	}
}
