package com.company;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Stats {

    public static void showStats() {
        System.out.println("Persons who made it!");

        try {
            BufferedReader inputStream = new BufferedReader((new FileReader("stats.txt")));
            int rowNr = 1;
            while (true) {
                String str = inputStream.readLine();
                if (str == null) {
                    break;
                }
                System.out.println(rowNr + ": " + str);
                rowNr++;
            }
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