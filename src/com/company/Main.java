package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("This is the simple drinking game HighLow");
        System.out.println("Just follow the instructions and play!");

        int gamesPlayed = 0;
        int sumOfScores = 0;
        double averageScore;
        boolean playAgain;

        do {
            int scoreThisGame;        // Score for one game.
            scoreThisGame = play();   // Play the game and get the score.
            sumOfScores += scoreThisGame;
            gamesPlayed++;
            System.out.println("Play again? (Y or N)");
            playAgain = TextIO.getlnBoolean();
        } while (playAgain);

        averageScore = ((double) sumOfScores) / gamesPlayed;

        System.out.println();
        System.out.println("You played " + gamesPlayed + " games.");
        System.out.printf("Your average score was %1.3f.\n", averageScore);

    }  //Slut main


    private static int play() {

        String guessing;
        Scanner keyboard = new Scanner(System.in);

        Random r = new Random();
        char answear = r.nextBoolean() ? 'R' : 'B';
        String s = String.valueOf(answear);

        do {
            System.out.println("Guess the color of the card - (R)ed or (B)lack?");
            guessing = keyboard.next().trim();
            if (guessing.toUpperCase().equals(s.toUpperCase()))
                System.out.println("Correct!");
            else
                System.out.println("Wrong! Try again!");
        } while (!guessing.toUpperCase().equals(s.toUpperCase()));

        PlayingCardDeck deck = new PlayingCardDeck();
        PlayingCard currentCard;
        PlayingCard nextCard;

        int correctGuesses;
        char guess;

        deck.shuffle();
        correctGuesses = 0;
        currentCard = deck.dealCard();
        System.out.println("Next up, a random card is the " + currentCard);

        while (true) {
            System.out.println("Will the next card be higher (H) or lower (L)?  ");
            do {
                guess = TextIO.getlnChar();
                guess = Character.toUpperCase(guess);
                if (guess != 'H' && guess != 'L')
                    System.out.println("Please respond with H or L:  ");
            } while (guess != 'H' && guess != 'L');

            /* Get the next card and show it to the user. */

            nextCard = deck.dealCard();
            //System.out.println("The next card is " + nextCard);

            /* Check the user's prediction. */

            if (nextCard.getValue() == currentCard.getValue()) {
                System.out.println("The value is the same as the previous card.");
                System.out.println("You lose on ties.  Sorry!");
                break;  // End the game.
            } else if (nextCard.getValue() > currentCard.getValue()) {
                if (guess == 'H') {
                    System.out.println("Your prediction was correct.");
                    correctGuesses++;
                } else {
                    System.out.println("Your prediction was incorrect.");
                    break;  // End the game.
                }
            } else {  // nextCard is lower
                if (guess == 'L') {
                    System.out.println("Your prediction was correct.");
                    correctGuesses++;
                } else {
                    System.out.println("Your prediction was incorrect.");
                    break;  // End the game.
                }

                //Nytt projekt ------------------------------------------------------------

                System.out.println();
                Scanner key = new Scanner(System.in);
                String keyen;

                String chars = "abc";
                Random rnd = new Random();
                char c = chars.charAt(rnd.nextInt(chars.length()));

                String str = Character.toString(c);
                while (true)
                    do {
                        System.out.println("Final moment! Lets try to guess the value! (H)earts, (D)iamonds, (C)lubs or (S)pades?");
                        keyen = key.next().trim();
                        if (keyen.toUpperCase().equals(str.toUpperCase()))
                            System.out.println("Correct!");
                        else
                            System.out.println("Wrong! Try again!");
                        break;
                    } while (!keyen.toUpperCase().equals(str.toUpperCase()));
            }
        } // end of while loop

        System.out.println();
        System.out.println("The game is over.");
        System.out.println("You made " + correctGuesses
                + " correct predictions.");
        System.out.println();
        return correctGuesses;
    }  // end play()
} // end class HighLow





