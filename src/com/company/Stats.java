package com.company;

import java.io.*;

public class Stats {
    public static void showStats() {
        System.out.println("All who made it!");

        try {
            BufferedReader input = new BufferedReader((new FileReader("stats.txt")));
            int rowNr = 1;
            while (true) {
                String s = input.readLine();
                if (s == null) {
                    break;
                }
                System.out.println(rowNr + ": " + s);
                rowNr++;
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeName() {

        try {
            System.out.println("Enter your name!");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("stats.txt", true)));

            output.println(input.readLine());
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}