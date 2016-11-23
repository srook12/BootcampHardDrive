package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck;
	
	public Deck(boolean isEmptyDeck) {
		deck = new ArrayList<Card>();
		
		if(!isEmptyDeck) {
			initDeck();
			shuffle();
		}
	}
	
	public void initDeck() {
		for(int i = 0; i < 4 ; i++) {
			for(int j = 0; j < 13; j++) {
				String cardType = findCardType(j);
				String cardSuit = findCardSuit(i);				
				int id = j + (i*13);
								
				deck.add(new Card(cardType, cardSuit, id));
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card getCard() {
		// Always get the top card if there is one!
		if(!isEmpty()) {
			return deck.remove(0);
		}
		
		// Should never get here
		return null;
	}
	
	public void addCard(Card card) {
		deck.add(card);
	}
	
	public boolean isEmpty() {
		return deck.size() == 0;
	}
	
	private String findCardType(int cardTypeInd) {
		String cardType = "";
		
		switch(cardTypeInd) {
			case CardConstants.TWO_ID:
				cardType = CardConstants.TWO_DESC;
				break;
			
			case CardConstants.THREE_ID:
				cardType = CardConstants.THREE_DESC;
				break;
			
			case CardConstants.FOUR_ID:
				cardType = CardConstants.FOUR_DESC;
				break;
			
			case CardConstants.FIVE_ID:
				cardType = CardConstants.FIVE_DESC;
				break;
			
			case CardConstants.SIX_ID:
				cardType = CardConstants.SIX_DESC;
				break;
			
			case CardConstants.SEVEN_ID:
				cardType = CardConstants.SEVEN_DESC;
				break;
			
			case CardConstants.EIGHT_ID:
				cardType = CardConstants.EIGHT_DESC;
				break;
			
			case CardConstants.NINE_ID:
				cardType = CardConstants.NINE_DESC;
				break;
			
			case CardConstants.TEN_ID:
				cardType = CardConstants.TEN_DESC;
				break;
			
			case CardConstants.JACK_ID:
				cardType = CardConstants.JACK_DESC;
				break;
			
			case CardConstants.QUEEN_ID:
				cardType = CardConstants.QUEEN_DESC;
				break;
			
			case CardConstants.KING_ID:
				cardType = CardConstants.KING_DESC;
				break;
			
			case CardConstants.ACE_ID:
				cardType = CardConstants.ACE_DESC;
				break;
		}
		
		return cardType;	
	}

	private String findCardSuit(int cardSuitInd) {
		String cardSuit = "";
		
		switch (cardSuitInd) {
			case CardConstants.CLUBS_ID:
				cardSuit = CardConstants.CLUBS_DESC;
				break;
				
			case CardConstants.DIAMONDS_ID:
				cardSuit = CardConstants.DIAMONDS_DESC;
				break;
				
			case CardConstants.HEARTS_ID:
				cardSuit = CardConstants.HEARTS_DESC;
				break;
				
			case CardConstants.SPADES_ID:
				cardSuit = CardConstants.SPADES_DESC;
				break;				
		}
		
		return cardSuit;
	}
}
