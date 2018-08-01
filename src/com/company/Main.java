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
                System.out.println("Wrong! Try again!");
        } while (!guess1.toUpperCase().equals(s.toUpperCase()));

        PlayingCardDeck deck = new PlayingCardDeck();
        PlayingCard currentCard;
        PlayingCard nextCard;

        int correctGuesses;
        correctGuesses = 1;

        char guess2;

        deck.shuffle();
        currentCard = deck.dealCard();
        System.out.println("Next up, a random card is the " + currentCard);

        while (true) {
            System.out.print("Will the next card be higher (H) or lower (L)?  ");
            do {
                guess2 = TextIO.getlnChar();
                guess2 = Character.toUpperCase(guess2);
                if (guess2 != 'H' && guess2 != 'L')
                    System.out.print("Please respond with H or L:  ");
            } while (guess2 != 'H' && guess2 != 'L');

            nextCard = deck.dealCard();

            if (nextCard.getValue() == currentCard.getValue()) {
                System.out.println("The value is the same as the previous card.");
                System.out.println("You lose on ties.  Sorry!");
                break;  // End the game.
            } else if (nextCard.getValue() > currentCard.getValue()) {
                if (guess2 == 'H') {
                    System.out.println("Your prediction was correct.");
                    correctGuesses++;
                } else {
                    System.out.println("Your prediction was incorrect.");
                    break;  // End the game.
                }
            } else {  // nextCard is lower
                if (guess2 == 'L') {
                    System.out.println("Your prediction was correct.");
                    correctGuesses++;
                } else {
                    System.out.println("Your prediction was incorrect.");
                    break;  // End the game.
                }
            }

            System.out.println();
            System.out.println("Final stage! Lets try to guess the value of the card!");
            Scanner key = new Scanner(System.in);
            String keyen;

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

            keyen = key.next().trim();

            if (keyen.toUpperCase().equals(str.toUpperCase())) {
                System.out.println("Correct! You won!");
                correctGuesses++;
                break;
            } else {
                System.out.println("Wrong!");
                break;
            }
        } // end of while loop

        System.out.println();
        System.out.println("The game is over.");
        System.out.println("You made : " + correctGuesses + " correct predictions.");
        System.out.println();
        return correctGuesses;
    }
}