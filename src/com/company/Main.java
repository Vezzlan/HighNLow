package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("This is the simple drinking game HighLow");
        System.out.println("Press 1 to play.");
        System.out.println("Press 2 for rules.");
        System.out.println("Press 3 to end the game.");
        System.out.println("Afterwards you will see the stats.");


        int gamesPlayed = 0;
        int sumOfScores = 0;
        double averageScore;
        boolean playAgain;

        do {
            int scoreThisGame;        // Score for one game.
            scoreThisGame = Play.play();   // Play the game and get the score.
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
}


