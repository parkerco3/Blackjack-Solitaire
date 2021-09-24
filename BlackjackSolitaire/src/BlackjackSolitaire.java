/**
 * 
 * @author coreyparker
 *collaborator : Daniel Xu
 */
import java.util.*;
public class BlackjackSolitaire {


	int moves = 0;  //running counter of how many cards are in scoring field
	int inputs = 0; //running number of number of user inputs whether incorrect or not
	int errors = 0; //number of errors committed in 1 user's turn
	int placed = 0; //variable used to see if a card was already placed in a spot, will reset after each new insert 
	int gameSum = 0; //gameSum to be given to the user at the end of the game
	int spots = 0; //index for the chosenSpots matrix 
	int[] chosenSpots = new int[20]; // matrix that holds the user inputs 
	Scanner s = new Scanner(System.in);


	void play() {
		Deck cards = new Deck();
		cards.shuffle();
		GameBoard board = new GameBoard();


		for (int i = 0; i <= inputs; i++) {
			System.out.println();
			System.out.println("The board:");
			board.printBoard();
			System.out.println();

			errors = 0;

			Card chosen = cards.pickCardFromTop();
			System.out.println("Top card: " + chosen.getDescription());
			for (int j = 0; j <= errors; j++) {
				System.out.println("Where would you like to place the " + chosen.getDescription() + "?");
				int location = s.nextInt();
				placed = 0;
				if (location > 0 && location <= 20) {
					for (int k = 0; k < 20; k++) {
						if (chosenSpots[k] == location) {
							placed = 1;
						}
					}
					if (placed > 0) {
						System.out.println("Location filled. Please pick another board location.");
						System.out.println();
						System.out.println("The board:");
						board.printBoard();
						System.out.println();
						errors++;
					}
					if (placed == 0) {
						chosenSpots[spots] = location;
						board.placeCard(location, chosen);
						if (location >=17 && location<=20) {
							errors = 0;
							spots++;
							inputs++;
							System.out.println("Right in the discard pile!");

						}
						else {
							moves++;
							spots++;
							errors = 0;
							inputs++;
						}

					}

				}
				else {
					System.out.println("Not a valid board location. Please pick another board location.");
					System.out.println();
					System.out.println("The board:");
					board.printBoard();
					errors++;

				}
			}
			if (moves == 16) {
				//this whole block is for after the user inputs 16 valid moves (fills the game board)
				//this will accurately score the game 
				//important notes: I initially set all aces to be 1, if the row is less than or equal to 11 and an ace is present then it will add 10
				System.out.println();
				inputs = 0;
				System.out.println("Final board:");
				board.printBoard();

				int column0 = 0;
				int column1 = 0;
				int column2 = 0;
				int column3 = 0;
				int column4 = 0;
				int row0 = 0;
				int row1 = 0;
				int row2 = 0;
				int row3 = 0;

				column0 = board.board[0][0].getValue() + board.board[1][0].getValue();
				if (column0<=11 && (board.board[0][0].getValue() == 1 || board.board[1][0].getValue() == 1)) {
					column0+=10;
				}
				if (column0 <= 16) {
					gameSum += 1;
				}
				if (column0 == 17) {
					gameSum += 2;
				}
				if (column0 == 18) {
					gameSum += 3;
				}
				if (column0 == 19) {
					gameSum += 4;
				}
				if (column0 == 20) {
					gameSum += 5;
				}
				if (column0 == 21) {
					gameSum += 10;
				}

				column4 = board.board[0][4].getValue() + board.board[1][4].getValue();
				if (column4<=11 && (board.board[0][4].getValue() == 1 || board.board[1][4].getValue() == 1)) {
					column4+=10;
				}
				if (column4 <= 16) {
					gameSum += 1;
				}
				if (column4 == 17) {
					gameSum += 2;
				}
				if (column4 == 18) {
					gameSum += 3;
				}
				if (column4 == 19) {
					gameSum += 4;
				}
				if (column4 == 20) {
					gameSum += 5;
				}
				if (column4 == 21) {
					gameSum += 10;
				}
				column1 = board.board[0][1].getValue() + board.board[1][1].getValue() + board.board[2][1].getValue() + board.board[3][1].getValue();
				if (column1<=11 && (board.board[0][1].getValue() == 1 || board.board[1][1].getValue() == 1 || board.board[2][1].getValue() == 1 || board.board[3][1].getValue() == 1)) {
					column1+=10;
				}
				if (column1 <= 16) {
					gameSum += 1;
				}
				if (column1 == 17) {
					gameSum += 2;
				}
				if (column1 == 18) {
					gameSum += 3;
				}
				if (column1 == 19) {
					gameSum += 4;
				}
				if (column1 == 20) {
					gameSum += 5;
				}
				if (column1 == 21) {
					gameSum += 7;
				}
				if (column1>=22) {
					gameSum+=0;
				}

				column2 = board.board[0][2].getValue() + board.board[1][2].getValue() + board.board[2][2].getValue() + board.board[3][2].getValue();
				if (column2<=11 && (board.board[0][2].getValue() == 1 || board.board[1][2].getValue() == 1 || board.board[2][2].getValue() == 1 || board.board[3][2].getValue() == 1)) {
					column2+=10;
				}
				if (column2 <= 16) {
					gameSum += 1;
				}
				if (column2 == 17) {
					gameSum += 2;
				}
				if (column2 == 18) {
					gameSum += 3;
				}
				if (column2 == 19) {
					gameSum += 4;
				}
				if (column2 == 20) {
					gameSum += 5;
				}
				if (column2 == 21) {
					gameSum += 7;
				}
				if (column2>=22) {
					gameSum+=0;
				}

				column3 = board.board[0][3].getValue() + board.board[1][3].getValue() + board.board[2][3].getValue()+ board.board[3][3].getValue();
				if (column3<=11 && (board.board[0][3].getValue() == 1 || board.board[1][3].getValue() == 1 || board.board[2][3].getValue() == 1 || board.board[3][3].getValue() == 1)) {
					column3+=10;
				}
				if (column3 <= 16) {
					gameSum += 1;
				}
				if (column3 == 17) {
					gameSum += 2;
				}
				if (column3 == 18) {
					gameSum += 3;
				}
				if (column3 == 19) {
					gameSum += 4;
				}
				if (column3 == 20) {
					gameSum += 5;
				}
				if (column3 == 21) {
					gameSum += 7;
				}
				if (column3>=22) {
					gameSum+=0;
				}



				row0 = board.board[0][0].getValue() + board.board[0][1].getValue() + board.board[0][2].getValue() + board.board[0][3].getValue()+board.board[0][4].getValue();
				if (row0<=11 && (board.board[0][0].getValue() == 1 || board.board[0][1].getValue() == 1 || board.board[0][2].getValue() == 1 || board.board[0][3].getValue() == 1 || board.board[0][4].getValue() == 1)) {
					row0+=10;
				}
				if (row0 <= 16) {
					gameSum += 1;
				}
				if (row0 == 17) {
					gameSum += 2;
				}
				if (row0 == 18) {
					gameSum += 3;
				}
				if (row0 == 19) {
					gameSum += 4;
				}
				if (row0 == 20) {
					gameSum += 5;
				}
				if (row0 == 21) {
					gameSum += 7;
				}
				if (row0>=22) {
					gameSum+=0;
				}

				row1 = board.board[1][0].getValue() + board.board[1][1].getValue() + board.board[1][2].getValue() + board.board[1][3].getValue()+board.board[1][4].getValue();
				if (row1<=11 && (board.board[1][0].getValue() == 1 || board.board[1][1].getValue() == 1 || board.board[1][2].getValue() == 1 || board.board[1][3].getValue() == 1 || board.board[1][4].getValue() == 1)) {
					row1+=10;
				}
				if (row1 <= 16) {
					gameSum += 1;
				}
				if (row1 == 17) {
					gameSum += 2;
				}
				if (row1 == 18) {
					gameSum += 3;
				}
				if (row1 == 19) {
					gameSum += 4;
				}
				if (row1 == 20) {
					gameSum += 5;
				}
				if (row1 == 21) {
					gameSum += 7;
				}
				if (row1>=22) {
					gameSum+=0;
				}

				row2 = board.board[2][1].getValue() + board.board[2][2].getValue() + board.board[2][3].getValue();
				if (row2<=11 && (board.board[2][1].getValue() == 1 || board.board[2][2].getValue() == 1 || board.board[2][3].getValue() == 1)) {
					row2+=10; 
				}
				if (row2 <= 16) {
					gameSum += 1;
				}
				if (row2 == 17) {
					gameSum += 2;
				}
				if (row2 == 18) {
					gameSum += 3;
				}
				if (row2 == 19) {
					gameSum += 4;
				}
				if (row2 == 20) {
					gameSum += 5;
				}
				if (row2 == 21) {
					gameSum += 7;
				}
				if (row2>=22) {
					gameSum+=0;
				}

				row3 = board.board[3][1].getValue() + board.board[3][2].getValue() + board.board[3][3].getValue();
				if (row3<=22 && (board.board[3][1].getValue() == 1 || board.board[3][2].getValue() == 1 || board.board[3][3].getValue() == 1)) {
					row3+=10;
				}
				if (row3 <= 16) {
					gameSum += 1;
				}
				if (row3 == 17) {
					gameSum += 2;
				}
				if (row3 == 18) {
					gameSum += 3;
				}
				if (row3 == 19) {
					gameSum += 4;
				}
				if (row3 == 20) {
					gameSum += 5;
				}
				if (row3 == 21) {
					gameSum += 7;
				}
				if (row3>=22) {
					gameSum+=0;
				}
			}

		}
		System.out.println();
		System.out.println("Your final score was " + gameSum + ".");
		System.out.println("Thanks for playing!");
	}
}

