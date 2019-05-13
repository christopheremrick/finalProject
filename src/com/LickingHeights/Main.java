package com.LickingHeights;

public class Main {

    // Originally made this in another file
    // That's why the time stamps are so close together

    public static void main(String[] args) {
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
}
