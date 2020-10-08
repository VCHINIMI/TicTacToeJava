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
	
//Computer making move
	public static int getNextComputerMove(char[] board, char computerGameCharacter,char userGameCharacter) {
		int winningMove = winningMoveAvailable(board, computerGameCharacter);
		if(winningMove!=0)
			return winningMove;
		int userWinningMove = winningMoveAvailable(board, userGameCharacter);
		if(userWinningMove!=0)
			return userWinningMove;
		int[] movesList = {1,3,7,9};
		for(int index =0; index<movesList.length;index++) {
			if(isCellEmpty(index, board))
				return index;
		}
		return 0;
	}
	
//Check if any winning moves available
	public static int winningMoveAvailable(char[] board, char character) {
		for(int index = 1; index<=9;index++) {
			char[] boardClone =getBoardClone(board);
			if(isCellEmpty(index, boardClone)) {
				intitiateMove(boardClone, index, character);
				if(isWinner(boardClone, character))
					return index;
			}
		}
		return 0;
	}
	
//Cloning Board to check for computer winning
	public static char[] getBoardClone(char[] board) {
		char[] boardClone = new char[10];
		boardClone = board.clone();
		return boardClone;
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
		gameBoard[2]='X';
//		System.out.println(isWinner(gameBoard, 'X'));
		displayBoard(gameBoard);
		int computerNextMove = getNextComputerMove(gameBoard,compInGameCharacter,userInGameCharacter);
		System.out.println(computerNextMove);
	}
}
