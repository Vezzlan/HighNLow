package com.company;

import java.util.Random;
import java.util.Scanner;

public class Play {
    public static int play() {

        String guess1;
        Scanner keyboard = new Scanner(System.in);

        Random r = new Random();
        char answer = r.nextBoolean() ? 'R' : 'B';
        String s = String.valueOf(answer);

        do {
            System.out.println("Guess the color of the card - (R)ed or (B)lack?");
            guess1 = keyboard.next().trim();
            if (guess1.toUpperCase().equals(s.toUpperCase()))
                System.out.println("Correct!");
            else
                System.out.println("Wrong! Take a zip and try again!");
        } while (!guess1.toUpperCase().equals(s.toUpperCase()));

        //Start of second level. The game will now be able to quit.

        PlayingCardDeck deck = new PlayingCardDeck();
        PlayingCard currentCard;
        PlayingCard nextCard;

        int correctGuesses;
        correctGuesses = 1;

        Scanner key1 = new Scanner(System.in);
        String keyen1;

        String chars1 = "hl";
        Random rnd1 = new Random();
        char c1 = chars1.charAt(rnd1.nextInt(chars1.length()));
        String str1 = Character.toString(c1);

        char guess2;

        deck.shuffle();
        currentCard = deck.dealCard();
        System.out.println("Next up, a random card is the " + currentCard);

        while (true) {
            System.out.print("Will the next card be higher (H) or lower (L)?  ");
            do {
                guess2 = Character.toUpperCase(c1);
                if (guess2 != 'H' && guess2 != 'L')
                    System.out.print("Please respond with H or L:  ");
            } while (guess2 != 'H' && guess2 != 'L');

            nextCard = deck.dealCard();
            keyen1 = key1.next().trim();

            if (nextCard.getValue() == currentCard.getValue()) {
                System.out.println("The value is the same as the previous card.");
                System.out.println("You lose on ties.  Sorry!");
                break;  // End the game.
            } else if (nextCard.getValue() > currentCard.getValue()) {
                if (keyen1.toUpperCase().equals(str1.toUpperCase())){
                    System.out.println("Your prediction was correct.");
                    correctGuesses++;
                } else {
                    System.out.println("Your prediction was incorrect.");
                    break;  // End the game.
                }
            } else {  // nextCard is lower
                if (keyen1.toUpperCase().equals(str1.toUpperCase())) {
                    System.out.println("Your prediction was correct.");
                    correctGuesses++;
                } else {
                    System.out.println("Your prediction was incorrect.");
                    break;  // End the game.
                }
            }

            //Start of third level.

            System.out.println();
            System.out.println("Final stage! Lets try to guess the value of the card!");
            Scanner key = new Scanner(System.in);
            String keyen2;

            String chars = "hdcs";
            Random rnd = new Random();
            char c = chars.charAt(rnd.nextInt(chars.length()));
            String str = Character.toString(c);

            char guess3;

            System.out.print("(H)earts, (D)iamonds, (C)lubs or (S)pades?");
            do {
                guess3 = Character.toUpperCase(c);
                if (guess3 != 'H' && guess3 != 'C' && guess3 != 'D' && guess3 != 'S')
                    System.out.print("Please respond with H, L, D or S:  ");
            } while (guess3 != 'H' && guess3 != 'C' && guess3 != 'D' && guess3 != 'S');

            keyen2 = key.next().trim();

            if (keyen2.toUpperCase().equals(str.toUpperCase())) {
                System.out.println("Congrats! No more drinking!");
                correctGuesses++;
                break;
            } else {
                System.out.println("Wrong! Take another zip!");
                break;
            }
        }

        System.out.println();
        System.out.println("The game is over.");
        System.out.println("You made : " + correctGuesses + " correct predictions.");
        System.out.println();
        return correctGuesses;
    }
}