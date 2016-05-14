public class KnightTour {
	int validDirections[][] = { { 2, 1 }, { 1, 2 }, { -1, 2 },
			{ -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };

	void printBoardFull(int board[][]) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] < 10) {
					System.out.print(" ");
				}
				System.out.print(board[i][j]);
				if (j != board[i].length - 1) {
					System.out.print("-");
				}
			}
			System.out.println("");
		}
	}

	boolean isValidMove(int curX, int curY, int[] move, int board[][]) {
		if (curX + move[0] >= 0 && curX + move[0] < 8 && curY + move[1] >= 0
				&& curY + move[1] < 8
				&& board[curX + move[0]][curY + move[1]] == -1) {
			return true;
		}
		return false;
	}

	boolean findSequence(int pre_board[][], int curX, int curY, int moveNumber) {
		pre_board[curX][curY] = moveNumber;
		if(moveNumber==63){
			printBoardFull(pre_board);
			return true;
		}
		for (int m = 0; m < validDirections.length; m++) {
			if (isValidMove(curX, curY, validDirections[m], pre_board)) {
				if (findSequence(pre_board, curX + validDirections[m][0], curY
						+ validDirections[m][1], moveNumber + 1)) {
					return true;
				} else {
					
				}
			}
		}
		pre_board[curX][curY] = -1;
		return false;
	}

	public static void main(String args[]) {
		int board[][] = new int[8][8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = -1;
			}
		}
		KnightTour kt = new KnightTour();
		kt.findSequence(board, 5, 5, 0);
	}

}
