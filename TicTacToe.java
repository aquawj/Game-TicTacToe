package project1;

public class TicTacToe {
	int n;
	char[][] grid;
	char playerMark = 'X';
	
	public TicTacToe(int n, char playerMark) {
		this.n = n;
		this.grid = new char[n][n];
		this.playerMark = playerMark;
		System.out.println("You have set a " + n + "*" + n + " board. The first player's mark is " + playerMark + ".");
	} // initialize your data structure

	public void initializeBoard() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = ' ';
		System.out.println("==========================================================");
		System.out.println("Now the board is empty.");
	} // set or reset the board back to all empty values

	public void printBoard() {
		System.out.println("Now the board is displaying: ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(grid[i][j] + " ");
			System.out.println(";");
		}
	} // print the current board

	public boolean isBoardFull() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}// check if the board is full or not

	public boolean checkForWin() {
		// condition1: win in horizontal dimension
		boolean horizontalWin = true;
		for (int i = 0; i < n; i++) {
			horizontalWin = true;
			for (int j = 0; j < n - 1; j++) {
				if ((grid[i][j] != grid[i][j + 1]) || (grid[i][j] == ' ')) {
					horizontalWin = false;
					break;
				}
			}
			if (horizontalWin) {
				System.out.println("==Winner is the one set " + grid[i][0] + "(horizontal-win).GAME OVER!==");
				break;
			}
		}

		// condition2: win in vertical dimension
		boolean verticalWin = true;
		for (int j = 0; j < n; j++) {
			verticalWin = true;
			for (int i = 0; i < n - 1; i++) {
				if ((grid[i][j] != grid[i + 1][j]) || (grid[i][j] == ' ')) {
					verticalWin = false;
					break;
				}
			}
			if (verticalWin) {
				System.out.println("==Winner is the one set " + grid[0][j] + "(vertical-win).GAME OVER!==");
				break;
			}
		}
		// condition3: win in diagonal dimension
		boolean diagonalWin1 = true;// from upper left corner to right bottom
									// corner
		for (int i = 0; i < n - 1; i++) {
			if ((grid[i][i] != grid[i + 1][i + 1]) || (grid[i][i] == ' ')) {
				diagonalWin1 = false;
				break;
			}
		}
		if (diagonalWin1)
			System.out.println("==Winner is the one set " + grid[0][0] + "(diagonal-win).GAME OVER!==");
		boolean diagonalWin2 = true;// from upper right corner to left bottom
									// corner
		for (int i = 0; i < n - 1; i++) {
			if ((grid[i][n - i - 1] != grid[i + 1][n - i - 2]) || (grid[i][n - i - 1] == ' ')) {
				diagonalWin2 = false;
				break;
			}
		}
		if (diagonalWin2)
			System.out.println("==Winner is the one set " + grid[0][n - 1] + "(diagonal-win).GAME OVER!==");
		return horizontalWin || verticalWin || diagonalWin1 || diagonalWin2;
	
	}// check if there¡¯s a winner or not

	public void changePlayer() {
		char nextPlayerMark = ' ';
		if (this.playerMark == 'X')
			nextPlayerMark = 'O';
		if (this.playerMark == 'O')
			nextPlayerMark = 'X';
		playerMark = nextPlayerMark;
		System.out.println("Player is changing.");
	}// change player marks back and forth

	public void placeMark(int row, int col) {
		System.out.println(
				"Please enter the location of your mark. Make sure your inputs are from 0 to " + (this.n - 1) + ".");
		if (row >= this.n || row < 0 || col >= this.n || col < 0) {
			System.out.println("Invalid input. Please input again.");
		}
		else if (checkForWin()) {
			System.out.println("Game over. You can't input anymore.");
		}
		else if (isBoardFull()) {
			System.out.println("No winner! The board is full. You can't mark anymore. Restart!");
		}
		else if (grid[row][col] != ' ' ){
			System.out.println("You can't mark here. It's occupied.");
		} 
		else {
			grid[row][col] = playerMark;
			System.out.println("You have place " + playerMark + " on row " + row + " and col " + col);
		}
	}// place the mark of the current player at the cell specified
		// by row and col

	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe(3, 'X');
		// test for no-winner begins:
		ttt.initializeBoard();
		ttt.placeMark(1, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(0, 0);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(0, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(2, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(1, 0);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(1, 2);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(0, 2);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(2, 0);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(2, 2);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(0, 0);
		// test for horizontal-win begins:
		ttt.initializeBoard();
		ttt.placeMark(1, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(0, 2);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(0, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(2, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(0, 0);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(2, 2);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(1, 2);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(2, 0);
		ttt.printBoard();
		ttt.checkForWin();
		// test for vertical-win begins:
		ttt.initializeBoard();
		ttt.placeMark(0, 0);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(0, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(1, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(2, 2);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(1, 0);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(1, 2);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(2, 0);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.placeMark(0, 0);
		ttt.printBoard();
		ttt.checkForWin();
		// test for diagonal-win1 begins:
		ttt.initializeBoard();
		ttt.placeMark(0, 0);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(1, 0);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(1, 0);
		ttt.placeMark(0, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(0, 2);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(1, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(2, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(2, 2);
		ttt.printBoard();
		ttt.checkForWin();
		// test for diagonal-win2 begins:
		ttt.initializeBoard();
		ttt.placeMark(1, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(0, 0);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(0, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(2, 1);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(1, 0);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(1, 2);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(0, 2);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(2, 2);
		ttt.printBoard();
		ttt.checkForWin();
		ttt.changePlayer();
		ttt.placeMark(2, 0);
		ttt.printBoard();
		ttt.checkForWin();
	}
}
