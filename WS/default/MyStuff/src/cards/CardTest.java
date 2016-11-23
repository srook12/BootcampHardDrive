package cards;

public class CardTest {

	public static void main(String[] args) {
		Deck deck = new Deck(false);
		
		int counter = 1;
		
		while(!deck.isEmpty()) {
			Card card = deck.getCard();
			
			if(card.getId() % 13 == CardConstants.JACK_ID)
			System.out.printf("%-20s %d\n", card, card.getId());
			/*
			if(counter % 5 == 0)
				System.out.println();
				*/		
			counter++;
		}

		System.out.println();
	}

}
