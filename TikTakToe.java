package day1;

//Tik tac toe
//Turn back game
//Console Game
//Player->Name
//Player->Marker - X or O
//Player->HasTurn
//Player->Score
//Board - 3 x 3 matrix, char Array[][]
//x|x|x
//-----
//x|x|x
//-----
//x|x|x
//Board logic
//Number of Players.
//Determine playing order.
//Determine which marker for whether player
//Board determine who wins.
//BoardController to be input coordinates.
// - Determines whether or not a player can put a marker in a certain place or valid.
//Board-abstract play Player names, Score of each player, board itself.
//Classes
//
import java.util.Scanner;

public class TikTakToe {
	public static void main(String[] args) {
		Board ticTacToe = new Board();
		ticTacToe.displayBoad();
		Scanner scanObj = new Scanner(System.in);

		System.out.println("Please enter in Player 1 name: ");
		Player player1 = new Player();
		player1.setName(scanObj.nextLine());
		System.out.println("Please enter  Player 1 mark: ");
		player1.setMarker(scanObj.nextLine().charAt(0));

		System.out.println("Please enter in Player 2 name: ");
		Player player2 = new Player();
		player2.setName(scanObj.nextLine());
		System.out.println("Please enter  Player 2 mark: ");
		player2.setMarker(scanObj.nextLine().charAt(0));

		ticTacToe.setPlayers(player1, player2);
		System.out.println(" Player 1 name: " + ticTacToe.getPlayers()[0].getName());
		System.out.println(" Player 1 mark: " + ticTacToe.getPlayers()[0].getMarker());
		System.out.println(" Player 2 name: " + ticTacToe.getPlayers()[1].getName());
		System.out.println(" Player 2 mark: " + ticTacToe.getPlayers()[1].getMarker());
		while(!ticTacToe.isGameOver()) {
			System.out.println("Player 1: please enter a number from 1 to 9 : " );
			ticTacToe.fillMove(scanObj.nextLine(), player1.getMarker());
			ticTacToe.displayBoad();
			if(ticTacToe.checkWinner(player1).length()==0) {
				System.out.println("Player 2: please enter a number from 1 to 9 : " );
				ticTacToe.fillMove(scanObj.nextLine(), player2.getMarker());
				ticTacToe.displayBoad();
				if(ticTacToe.checkWinner(player2).length()==0) {
					continue;
				}
				else {
					System.out.println("Winner is player 2");
					break;
				}
			}
			else {
				System.out.println("Winner is player 1");
				break;
			}
			
			
		}
		
		scanObj.close();

	}
}

class Player {
	private String name;
	private char marker;
	private boolean isMyTurn;
	private int score;
	private boolean isWinner;
	
	
	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getMarker() {
		return this.marker;
	}

	public void setMarker(char marker) {
		this.marker = marker;
	}

	public boolean getIsMyTurn() {
		return this.isMyTurn;
	}

	public void UpdateMyTurn(boolean turn) {
		this.isMyTurn = turn;
	}

	public int getScore() {
		return this.score;
	}

	public void UpdateScore() {
		this.score++;
	}
}

class Board {
	public static char[][] board;
	public Player[] players = new Player[2]; // 2 players
	public boolean gameOver;
	
    public Board() {
    	board= new char[3][3];
    	Board.board[0][0] = '-';
    	Board.board[0][1] = '-';
    	Board.board[0][2] = '-';
    	
    	Board.board[1][0] = '-';
    	Board.board[1][1] = '-';
    	Board.board[1][2] = '-';
    	
    	Board.board[2][0] = '-';
    	Board.board[2][1] = '-';
    	Board.board[2][2] = '-';
    }
	public boolean isGameOver() {
		return gameOver;
	}

	public String checkWinner(Player player) {
		
		if(board[0][0] == player.getMarker() && board[0][1] == player.getMarker() && board[0][0] == player.getMarker()
				|| board[1][0] == player.getMarker() && board[1][1] == player.getMarker() && board[1][0] == player.getMarker() 
					||	board[2][0] == player.getMarker() && board[2][1] == player.getMarker() && board[2][0] == player.getMarker()
					||	board[0][0] == player.getMarker() && board[1][1] == player.getMarker() && board[2][2] == player.getMarker()
					||	board[0][2] == player.getMarker() && board[1][1] == player.getMarker() && board[2][0] == player.getMarker()) {
			player.setWinner(true);
			return player.getName();
		}
		return "";
	}

	public void fillMove(String position, char marker) {
		switch(position) {
			case "1": if(Board.board[0][0] != marker) Board.board[0][0] = marker; else System.out.println("This position is taken");
				break;
			case "2": if(Board.board[0][1] != marker) Board.board[0][1] = marker; else System.out.println("This position is taken");
				break;
			case "3": if(Board.board[0][2] != marker) Board.board[0][2] = marker; else System.out.println("This position is taken");
				break;
			case "4": if(Board.board[1][0] != marker) Board.board[1][0] = marker; else System.out.println("This position is taken");
				break;
			case "5": if(Board.board[1][1] != marker) Board.board[1][1] = marker; else System.out.println("This position is taken");
				break;
			case "6": if(Board.board[1][2] != marker) Board.board[1][2] = marker; else System.out.println("This position is taken");
				break;
			case "7": if(Board.board[2][0] != marker) Board.board[2][0] = marker; else System.out.println("This position is taken");
				break;
			case "8": if(Board.board[2][1] != marker) Board.board[2][1] = marker; else System.out.println("This position is taken");
				break;
			case "9": if(Board.board[2][1] != marker) Board.board[2][2] = marker; else System.out.println("This position is taken");
				break;
			default : break;
			
		}
		
	}
	
	public void displayBoad() {
		for(int i = 0 ; i< 3; i ++ ) {
			for(int j = 0 ; j< 3; j ++ ) {
				System.out.print("   " + Board.board[i][j]+"   "  );
			}
			System.out.println("");
				
		}
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public Player[] getPlayers() {
		return this.players;
	}

	public void setPlayers(Player player1, Player player2) {
		this.players[0] = player1;
		this.players[1] = player2;
	}

	public void DisplayUI() {
	}

	public void DisplayPlayers() {
	}

	public int[] DisplayMoves() {
		return null;
	}

	public void SetMoves(int turn) {
	}

	public boolean logic() {
		// SetMove(int turn);
		// Winner case - Vertical of 3 spaces
		// Winner case - Horizontal of 3 Spaces
		// Winner case - Diagontal of 3 Spaces
		// Losing - If all spaces are used up
		return false;
	}

	private void UpdateScoreBoard() {
	}
}