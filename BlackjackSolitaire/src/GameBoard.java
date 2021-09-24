/**
 * 
 * @author coreyparker
 *collaborator : Daniel Xu
 */
public class GameBoard {

	//class used to maintain the game board


	Card[][] board = new Card[4][5]; //create a 4 by 5 matrix to eventually extract the cards' values 

	void placeCard(int spot, Card topCard) {
		// used to place the card in the correct location of the matrix with exceptions made to the discard section
		if (spot <= 5 && board[0][spot - 1] == null) {
			board[0][spot - 1] = topCard;
		}
		if (spot >= 6 && spot <= 10 && board[1][spot - 6] == null) {
			board[1][spot - 6] = topCard;
		}

		if (spot >= 11 && spot <= 13 && board[2][spot - 10] == null) {
			board[2][spot - 10] = topCard;
		}

		if (spot >= 14 && spot <= 16 && board[3][spot - 13] == null) {
			board[3][spot - 13] = topCard;
		}

		if (spot >= 17 && spot <= 18 && board[spot - 15][0] == null) {
			board[spot - 15][0] = topCard;
		}

		if (spot >= 19 && spot <= 20 && board[spot - 17][4] == null) {
			board[spot - 17][4] = topCard;
		}
	}


	String printBoard() {
		//this will allow for a running printing of the board whenever requested in the play method 
		String field;
		field = "hi";
		int row = 0;
		for (int i = 1; i < 6; i++) {
			if (board[0][i-1] == null) {
				System.out.print(" " + i + "    ");
			}
			if (board[0][i-1] != null) {
				System.out.print(board[0][i-1].getDescription() + "    ");
			}
		}
		row++;
		System.out.println();
		if (row == 1) {
			for (int i = 6; i < 11; i++) {
				if (i == 10) {
					if (board[1][i-6] == null) {
						System.out.print("" + i + "    ");
					}
					if (board[1][i-6] != null) {
						System.out.print(board[1][i-6].getDescription() + "    ");
					}
				}
				else {
					if (board[1][i-6] == null) {
						System.out.print(" " + i + "    ");
					}
					if (board[1][i-6] != null) {
						System.out.print(board[1][i-6].getDescription() + "    ");
					}
				}
			}

			System.out.println();
			row++;
		}
		if (row == 2) {
			for (int i = 11; i < 14; i++) {
				if (i == 11) {
					if (board[2][i-10] == null) {
						System.out.print("      " + i);
					}
					if (board[2][i-10] != null) {
						System.out.print("      "+ board[2][i-10].getDescription());
					}
				}
				else {
					if (board[2][i-10] == null) {
						System.out.print("    " + i);
					}
					if (board[2][i-10] != null) {
						System.out.print("    "+ board[2][i-10].getDescription());
					}
				}
			}
			System.out.println();
			row++;
		}
		if (row == 3) {
			for (int i = 14; i < 17; i++) {
				if (i == 14) {
					if (board[3][i-13] == null) {
						System.out.print("      " + i);
					}
					if (board[3][i-13] != null) {
						System.out.print("      "+ board[3][i-13].getDescription());
					}
				}
				else {
					if (board[3][i-13] == null) {
						System.out.print("    " + i);
					}
					if (board[3][i-13] != null) {
						System.out.print("    "+ board[3][i-13].getDescription());
					}
				}

			}
			System.out.println();

		}
		return field;
	}
}





