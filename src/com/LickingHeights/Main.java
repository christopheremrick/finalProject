package com.LickingHeights;

import java.io.*;
import java.util.Scanner;

public class Main {

    // Originally made this in another file
    // That's why the time stamps are so close together

    public static int wins;
    public static int losses;

    public static void main(String[] args) {

        do {
            Scanner scan = new Scanner(System.in);
            int compChoice = getRandomChoice();
            System.out.println("Welcome to rock, paper, scissors.");
            System.out.println("Type 1 for rock, 2 for paper, 3 for scissors.");
            int choice = scan.nextInt();
            printPlayerChoice(choice, compChoice);
            gameLogic(choice, compChoice);
            printLine();
            System.out.println("You have "+wins+" wins.");
            System.out.println("You have "+losses+" losses.");
            printLine();
            checkWinOrLoss();
        }while(true);
    }
    private static int getRandomChoice() {
        int [] choices = new int[4];
        choices[1] = 1;
        choices[2] = 2;
        choices[3] = 3;
        // Array looks like this:
        // _______
        // |1 2 3|
        // |-----|
        // |1 2 3|
        int random = (int) (Math.random()*100);
        if(random < 33) {
            return choices[1]; // rock
        }
        else if(random >= 33 && random <= 66) {
            return choices[2]; // paper
        }
        else {
            return choices[3]; // scissors
        }
    }
    private static void gameLogic(int userInput, int compInput) {
        if((userInput==1&&compInput==1)||(userInput ==2&&compInput==2)||(userInput==3&&compInput==3)) {
            System.out.println("Draw game.");
            return;
        }
        else if((userInput==1&&compInput==3)||(userInput==2&&compInput==1)||(userInput==3&&compInput==2)) {
            System.out.println("You win.");
            wins++;
            return;
        }
        else if((userInput==1&&compInput==2)||(userInput==2&&compInput==3)||(userInput==3&&compInput==1)) {
            System.out.println("You lose.");
            losses++;
            return;
        }
        else {
            System.out.println("Error.");
            return;
        }
    }
    private static void printPlayerChoice(int userInput, int compChoice) {
        switch(userInput) {
            case 1:
                System.out.println("You choose rock.");
                break;
            case 2:
                System.out.println("You choose paper.");
                break;
            case 3:
                System.out.println("You choose scissors.");
                break;
        }
        switch(compChoice) {
            case 1:
                System.out.println("Computer chooses rock.");
                break;
            case 2:
                System.out.println("Computer chooses paper.");
                break;
            case 3:
                System.out.println("Computer chooses scissors.");
                break;
        }
    }
    private static void printLine() {
        System.out.println("-----------------------------------------------------------------------------------------");
    }
    private static void checkWinOrLoss() {
        if(wins == 10) {
            System.out.println("You win the game.");
            printLine();
            try {
                writeToFile(true);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error.");
            }
            System.exit(0);
        }
        else if(losses == 10) {
            System.out.println("You lose the game.");
            printLine();
            try {
                writeToFile(false);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error.");
            }
        }

    }
    private static void writeToFile(boolean win) throws IOException {
        File file = new File("Highscores.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        Scanner scan = new Scanner(System.in);

        if(!file.exists()) {
            file.createNewFile();
        }
        if(file.length()>0) {
            writer.newLine();
        }
        System.out.println("Please type your name.");
        String name = scan.nextLine();
        if(win) {
            writer.write(name + ": " + wins + " wins, and " + losses + " losses. WIN");
        }
        else {
            writer.write(name + ": " + wins + " wins, and " + losses + " losses. LOSS");
        }
        writer.close();
    }
}
