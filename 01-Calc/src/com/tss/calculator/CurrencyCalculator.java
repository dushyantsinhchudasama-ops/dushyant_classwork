package com.tss.calculator;

import java.util.Scanner;

public class CurrencyCalculator {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter amount");
        int amount = scanner.nextInt();

        int[] note = new int[4];

        note[0] = 2000;
        note[1] = 500;
        note[2] = 200;
        note[3] = 100;

        int[] notesCount = new int[4];

        if(amount > 50000 || amount <= 0)
        {
            System.out.println("Invalid amount");
        } else if (amount % 100 != 0) {
            System.out.println("Not multiple of 100");
        } else {
            int tempAmount = amount;

            for(int i = 0; i < note.length; i++)
            {
                if(tempAmount > note[i])
                {
                    notesCount[i] = tempAmount / note[i];
                    tempAmount = tempAmount % note[i];
                }

                if (notesCount[i] > 0) {
                    System.out.println(note[i] + " notes: " + notesCount[i]);
                }
            }
        }

    }
}
