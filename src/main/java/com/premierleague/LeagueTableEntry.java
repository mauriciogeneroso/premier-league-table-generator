package com.premierleague;

public class LeagueTableEntry {

    private String teamName;
    private int played;
    private int won;
    private int drawn;
    private int lost;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;
    private int points;

    public LeagueTableEntry(final String teamName) {
        this.teamName = teamName;
    }

    public LeagueTableEntry(String teamName, int played, int won, int drawn, int lost, int goalsFor, int goalsAgainst, int goalDifference, int points) {
        this.teamName = teamName;
        this.played = played;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.points = points;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPlayed() {
        return played;
    }

    public void increasePlayed() {
        this.played++;
    }

    public int getWon() {
        return won;
    }

    public void increaseWon() {
        this.won++;
    }

    public int getDrawn() {
        return drawn;
    }

    public void increaseDrawn() {
        this.drawn++;
    }

    public int getLost() {
        return lost;
    }

    public void increaseLost() {
        this.lost++;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void increaseGoalsFor(int goalsFor) {
        this.goalsFor += goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void increaseGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst += goalsAgainst;
    }

    public int getGoalDifference() {
        return goalsFor - goalsAgainst;
    }

    public int getPoints() {
        return points;
    }

    public void increasePoints(int points) {
        this.points += points;
    }

}
