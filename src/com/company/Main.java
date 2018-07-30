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
            System.out.print("Play again? (Y or N)");
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
            if (s.equals(guessing))
                System.out.println("Correct!");
            else
                System.out.println("Wrong! Try again!");
        } while (!s.equals(guessing));

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
            System.out.print("Will the next card be higher (H) or lower (L)?  ");
            do {
                guess = TextIO.getlnChar();
                guess = Character.toUpperCase(guess);
                if (guess != 'H' && guess != 'L')
                    System.out.print("Please respond with H or L:  ");
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
            }

            //Nytt projekt ------------------------------------------------------------


            System.out.print("Final moment! Lets try to guess the value! (H)earts, (D)iamonds, (C)lubs or (S)pades?");

            while (true) {
                do {
                    guess = TextIO.getlnChar();
                    guess = Character.toUpperCase(guess);
                    if (guess != 'H' && guess != 'D' && guess != 'C' && guess !='S' )
                        System.out.print("Please respond with H, D, C or S:  ");
                } while (guess != 'H' && guess != 'D' && guess != 'C' && guess != 'S');


                /* Check the user's prediction. */

                if (guess == 'D') {
                    System.out.println("The value is the same as the previous card.");
                    System.out.println("You lose on ties.  Sorry!");
                    break;  // End the game.
                    /*
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
                    */
                }

            }


//Slut nytt projekt



         /* To set up for the next iteration of the loop, the nextCard
            becomes the currentCard, since the currentCard has to be
            the card that the user sees, and the nextCard will be
            set to the next card in the deck after the user makes
            his prediction.  */

                currentCard = nextCard;
                System.out.println();
                System.out.println("The card is " + currentCard);

            } // end of while loop

            System.out.println();
            System.out.println("The game is over.");
            System.out.println("You made " + correctGuesses
                    + " correct predictions.");
            System.out.println();

            return correctGuesses;

        }  // end play()

}// end class HighLow