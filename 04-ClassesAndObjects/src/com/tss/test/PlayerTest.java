package com.tss.test;

import com.tss.entity.Player;

import java.util.Scanner;

public class PlayerTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int id;
        String name;
        int numberofMatches;
        int totalRuns;
        int wickets;

        Player player = new Player();

        System.out.println("Default Values: ");
        System.out.println("ID : " + player.getId());
        System.out.println("Name : " + player.getName());
        System.out.println("Total Matches : " + player.getNumOfMatches());
        System.out.println("Total Runs : " + player.getTotalRuns());
        System.out.println("Wickets : " + player.getWickets());
        System.out.println("Average Runs: " + player.calculateAverage());


        System.out.println("Enter Name: ");
        name = scanner.nextLine();
        System.out.println("Enter ID : ");
        id = scanner.nextInt();
        System.out.println("Enter Total Matches");
        numberofMatches = scanner.nextInt();
        System.out.println("Enter Total Runs: ");
        totalRuns = scanner.nextInt();
        System.out.println("Enter total Wickets: ");
        wickets = scanner.nextInt();

        Player player1 = new Player(id, name, numberofMatches, totalRuns, wickets);

        System.out.println("Player details are as below: ");

        System.out.println("ID : " + player1.getId());
        System.out.println("Name : " + player1.getName());
        System.out.println("Total Matches : " + player1.getNumOfMatches());
        System.out.println("Total Runs : " + player1.getTotalRuns());
        System.out.println("Wickets : " + player1.getWickets());
        System.out.println("Average Runs: " + player1.calculateAverage());

        System.out.println("Re-enter number of matches:");
        numberofMatches = scanner.nextInt();
        player1.setNumOfMatches(numberofMatches);
        System.out.println("Re-enter total wickets: ");
        wickets = scanner.nextInt();
        player1.setWickets(wickets);

        System.out.println("Average wickets are: " + player1.calculateAverageWickets());
    }
}
