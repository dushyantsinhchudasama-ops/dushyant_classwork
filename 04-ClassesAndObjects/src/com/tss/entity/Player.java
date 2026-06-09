package com.tss.entity;

public class Player
{
    private int id;
    private String name;
    private int numOfMatches;
    private int totalRuns;
    private int wickets;

    //constructor
    public Player(){
        id = 1;
        name = "TestName";
        numOfMatches = 10;
        totalRuns = 100;
        wickets = 5;
    }

    public Player(int id, String name, int numOfMatches, int totalRuns, int wickets)
    {
        this.id = id;
        this.name = name;
        this.numOfMatches = numOfMatches;
        this.totalRuns = totalRuns;
        this.wickets = wickets;
    }

    //getters and setters
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setNumOfMatches(int numOfMatches) {this.numOfMatches = numOfMatches;}
    public void setTotalRuns(int id) {this.totalRuns = totalRuns;}
    public void setWickets(int wickets) {this.wickets = wickets;}

    public int getId(){ return id;}
    public String getName(){ return name;}
    public int getTotalRuns(){ return totalRuns;}
    public int getNumOfMatches(){ return numOfMatches;}
    public int getWickets(){ return wickets;}

    //calculate agerage

    public double calculateAverage() { return (totalRuns / numOfMatches);}
    public double calculateAverageWickets() { return (wickets / numOfMatches);}
}
