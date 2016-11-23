package gov.ssa.cards;

public class Card {
	private String cardType;
	private String cardSuit;
	private int id;
	
	public Card(String cardType, String cardSuit, int id) {
		this.cardType = cardType;
		this.cardSuit = cardSuit;
		this.id = id;		
	}

	public String getCardType() {
		return cardType;
	}

	public String getCardSuit() {
		return cardSuit;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		return cardType + " of " + cardSuit;
	}
}
