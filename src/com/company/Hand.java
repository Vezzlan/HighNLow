package com.company;

import java.util.ArrayList;

public class Hand {

    private ArrayList<PlayingCard> hand;

    public Hand() {
        hand = new ArrayList<PlayingCard>();
    }

    public void clear() {
        hand.clear();
    }

    public void addCard(PlayingCard c) {
        if (c == null)
            throw new NullPointerException("Can't add a null card to a hand.");
        hand.add(c);
    }

    public void removeCard(PlayingCard c) {
        hand.remove(c);
    }

    public void removeCard(int position) {
        if (position < 0 || position >= hand.size())
            throw new IllegalArgumentException("Position does not exist in hand: "
                    + position);
        hand.remove(position);
    }

    public int getCardCount() {
        return hand.size();
    }

    public PlayingCard getCard(int position) {
        if (position < 0 || position >= hand.size())
            throw new IllegalArgumentException("Position does not exist in hand: "
                    + position);
        return hand.get(position);
    }

    public void sortBySuit() {
        ArrayList<PlayingCard> newHand = new ArrayList<PlayingCard>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            PlayingCard c = hand.get(0);  // Minimal card.
            for (int i = 1; i < hand.size(); i++) {
                PlayingCard c1 = hand.get(i);
                if (c1.getSuit() < c.getSuit() ||
                        (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue())) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }

    public void sortByValue() {
        ArrayList<PlayingCard> newHand = new ArrayList<PlayingCard>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            PlayingCard c = hand.get(0);  // Minimal card.
            for (int i = 1; i < hand.size(); i++) {
                PlayingCard c1 = hand.get(i);
                if (c1.getValue() < c.getValue() ||
                        (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit())) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }
}
