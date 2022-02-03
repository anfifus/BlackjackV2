package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_VALUEBLACKJACK = 21;

    public static void main(String[] args) {
        boolean wantToContinue = false;
        int playerValue = 0;
        int resultValuePlayer = 0;
        do {
            playerValue = askForACard(playerValue);
            showValuePlayer(playerValue);
            wantToContinue = wantContinue(playerValue);

        }
        while (wantToContinue);
        resultValuePlayer = calculationValuePlayer(resultValuePlayer, playerValue);
        resultScoreValuePlayer(resultValuePlayer);
    }

    private static void resultScoreValuePlayer(int resultValuePlayer) {
        if (resultValuePlayer <= 6 && resultValuePlayer >= 0)
        {
            System.out.println("the difference between the points of the player and the max value of blackjack is: "+resultValuePlayer+" you are a master");
        }else if (resultValuePlayer > 6 && resultValuePlayer <= 12 )
        {
            System.out.println("the difference between the points of the player and the max value of blackjack is: "+resultValuePlayer+" you are good");
        }else if (resultValuePlayer > 12 && resultValuePlayer <= MAX_VALUEBLACKJACK)
        {
            System.out.println("the difference between the points of the player and the max value of blackjack is: "+resultValuePlayer+" you are bad");
        }else if(resultValuePlayer < 0){
            System.out.println("the difference between the points of the player and the max value of blackjack is: "+resultValuePlayer+" you have failed");
        }
    }

    private static int calculationValuePlayer(int resultValuePlayer, int playerValue) {
        playerValue = MAX_VALUEBLACKJACK - playerValue;
        resultValuePlayer += playerValue;
        return resultValuePlayer;
    }

    private static void showValuePlayer(int playerValue) {
        System.out.println("The value of letter for the player is " + playerValue);
    }

    private static int askForACard(int valuePlayer) {
        int valueAdding = AddValue();
        valuePlayer += valueAdding;
        return valuePlayer;
    }

    private static int AddValue() {
        Random rand = new Random();
        return rand.nextInt(1, 13);
    }

    private static boolean wantContinue(int playerValue) {
        return confirmation(playerValue);
    }

    private static boolean confirmation(int playerValue) {
        String confirm = "";
        Boolean failedGame = false ;
        if(playerValue > MAX_VALUEBLACKJACK)
        {
            failedGame = true;
        }
        if(failedGame == false) {
            System.out.println("Do you want to throw a letter?");
            Scanner scan = new Scanner(System.in);
             confirm = scan.nextLine();
        }

        return confirm.equalsIgnoreCase("S");
    }
}
