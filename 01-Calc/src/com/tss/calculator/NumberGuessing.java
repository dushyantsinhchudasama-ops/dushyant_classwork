package com.tss.calculator;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuessing {
    static void main() {

        Scanner scanner = new Scanner(System.in);

        int randomNumber = ThreadLocalRandom.current().nextInt(0,100);
        int guessNumber = 0;
        int attempts = 1;
        boolean won = false;
        int playAgain;

        do{

            System.out.println("Guess a number: ");

            guessNumber = scanner.nextInt();

            if(guessNumber < randomNumber) {
                System.out.println("It is too low");
                attempts += 1;
            }
            if(guessNumber > randomNumber) {
                System.out.println("It is too high");
                attempts += 1;
            }

            if(attempts > 5)
            {
                System.out.println("You loss, actual number was: " + randomNumber);

                System.out.println("Do you want to play again?(1 for yes and 0 for no)");
                playAgain = scanner.nextInt();

                if(playAgain == 1)
                {
                    won = false;
                    attempts = 0;
                }
                else {
                    System.out.println("Thank you!");
                }
            }
            if(guessNumber == randomNumber)
            {
                System.out.println("You won in " + attempts + " attempts!");
                won = true;

                System.out.println("Do you want to play again?(1 for yes and 0 for no)");
                playAgain = scanner.nextInt();

                if(playAgain == 1)
                {
                    won = false;
                    attempts = 0;
                }
                else {
                    System.out.println("Thank you!");
                }
            }
        } while(!won && attempts <= 5);
    }
}
