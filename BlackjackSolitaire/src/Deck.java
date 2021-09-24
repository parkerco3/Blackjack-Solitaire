/**
 * 
 * @author coreyparker
 *collaborator : Daniel Xu
 */

public class Deck {


	Card [] deck = new Card[52];

	int topCard = 0;

	public Card pickCardFromTop() {
		Card chosenCard = deck[topCard]; //will allow me to pick the top card from the deck and move on to the next one in the array 
		topCard++;
		return chosenCard;

	}
	
	public void shuffle() {
		//allow me to shuffle and create a new deck of 52 cards whenever this is called
		String[] suits = {"H", "D", "S","C"};
		String[] cardType = {"2", "3", "4", "5", "6","7","8","9", "T", "J", "Q", "K", "A"};
		int[] deckOrder = RandomOrderGenerator.getRandomOrder(52);
		topCard = 0;
		int counter = 0;
		for (int i = 0; i < cardType.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				Card myCard = new Card(cardType[i], suits[j]);
				deck[deckOrder[counter]] = myCard;
				counter++;
			}
		}
	}

}


