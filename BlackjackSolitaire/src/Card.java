/**
 * 
 * @author coreyparker
 * collaborator: Daniel Xu
 *
 */
public class Card {

	String suit; //H,D,S,C
	String cardType; //both numbers 2-9, A,K,Q,J,T; for formatting I made 10: T 
	int value; //this is scoring value of each card

	Card(String cardType, String suit) {
		this.cardType = cardType;
		this.suit = suit;
		if (cardType.equals("J")) {
			value = 10;
		}
		if (cardType.equals("Q")) {
			value = 10;
		}
		if (cardType.equals("K")) {
			value = 10;
		}
		if (cardType.equals("T")) {
			value = 10;
		}
		if (cardType.equals("A")) {
			value = 1;
		}
		for (int i = 2; i<10; i++) {
			String s = String.valueOf(i);
			if (cardType.equals(s)) {
				value = Integer.parseInt(cardType);
			}
		}
	}

	public String getDescription() {
		return cardType + suit;
	}

	public Integer getValue() {
		return value;
	}


}
