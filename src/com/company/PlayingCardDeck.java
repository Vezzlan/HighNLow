package com.company;

public class PlayingCardDeck {
    private PlayingCard[] deck;
    private int cardsUsed;

    public PlayingCardDeck() {
        this(false);
    }

    public PlayingCardDeck(boolean includeJokers) {
        if (includeJokers)
            deck = new PlayingCard[54];
        else
            deck = new PlayingCard[52];
        int cardCt = 0; // How many cards have been created so far.
        for (int suit = 0; suit <= 3; suit++) {
            for (int value = 1; value <= 13; value++) {
                deck[cardCt] = new PlayingCard(value, suit);
                cardCt++;
            }
        }
        if (includeJokers) {
            deck[52] = new PlayingCard(1, PlayingCard.JOKER);
            deck[53] = new PlayingCard(2, PlayingCard.JOKER);
        }
        cardsUsed = 0;
    }

    public void shuffle() {
        for (int i = deck.length - 1; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            PlayingCard temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }

    public PlayingCard dealCard() {
        if (cardsUsed == deck.length)
            throw new IllegalStateException("No cards are left in the deck.");
        cardsUsed++;
        return deck[cardsUsed - 1];
        // Controls how many cards have been used...
    }
}