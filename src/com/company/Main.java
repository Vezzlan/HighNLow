package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner alt = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu - Drinking game High Low");
            System.out.println("Press 1 to play.");
            System.out.println("Press 2 for rules.");
            System.out.println("Press 3 to see the stats.");
            System.out.println("Press 4 to end the game.");
            choice = alt.nextInt();
            switch (choice)
            {
                case 1:
                    Play.play();
                    break;
                case 2:
                    Rules.rules();
                    break;
                case 3:
                    Stats.showStats();
                    break;
                case 4:
                    System.out.println("See yaa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 4.");
            }
        } while (choice != 4);
    }
}