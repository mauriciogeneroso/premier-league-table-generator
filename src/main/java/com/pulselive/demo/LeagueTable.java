package com.pulselive.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeagueTable {

  private List<Match> matches;

  public LeagueTable(final List<Match> matches) {
    this.matches = matches;
  }

  /**
   * Get the ordered list of league table entries for this league table.
   *
   * @return
   */
  public List<LeagueTableEntry> getTableEntries() {
    List<String> teamsNames = teamsNames();
    List<LeagueTableEntry> leagueTableEntries = new ArrayList<>();

    for (String teamName : teamsNames) {
      int played = getPlayed(teamName);
      int won = getWon(teamName);
      int drawn = getDrawn(teamName);
      int lost = getLost(teamName);
      int goalsFor = getGoalsFor(teamName);
      int goalsAgainst = getGoalsAgainst(teamName);
      int goalDifference = goalsFor - goalsAgainst;
      int points = (won * 3) + drawn;

      leagueTableEntries.add(new LeagueTableEntry(
          teamName, played, won, drawn, lost, goalsFor, goalsAgainst, goalDifference, points));
    }

    leagueTableEntries.sort(Comparator.comparing(LeagueTableEntry::getPoints).reversed()
        .thenComparing(LeagueTableEntry::getGoalDifference, Comparator.reverseOrder())
        .thenComparing(LeagueTableEntry::getGoalsFor, Comparator.reverseOrder())
        .thenComparing(LeagueTableEntry::getTeamName));

    return leagueTableEntries;
  }

  private List<String> teamsNames() {
    List<String> homeTeams = matches
        .stream()
        .map(Match::getHomeTeam)
        .distinct()
        .collect(Collectors.toList());

    List<String> awayTeams = matches
        .stream()
        .map(Match::getAwayTeam)
        .distinct()
        .collect(Collectors.toList());

    return Stream.concat(homeTeams.stream(), awayTeams.stream())
        .distinct().collect(Collectors.toList());
  }

  private int getPlayed(String teamName) {
    return (int) matches
        .stream()
        .filter(t -> teamName.equals(t.getHomeTeam()) || teamName.equals(t.getAwayTeam())).count();
  }

  private int getWon(String teamName) {
    return (int) matches
        .stream()
        .filter(t ->
            (teamName.equals(t.getHomeTeam()) && t.getHomeScore() > t.getAwayScore())
                || (teamName.equals(t.getAwayTeam()) && t.getHomeScore() < t.getAwayScore()))
        .count();
  }

  private int getDrawn(String teamName) {
    return (int) matches
        .stream()
        .filter(t ->
            (teamName.equals(t.getHomeTeam()) || teamName.equals(t.getAwayTeam()))
                && t.getHomeScore() == t.getAwayScore())
        .count();
  }

  private int getLost(String teamName) {
    return (int) matches
        .stream()
        .filter(t ->
            (teamName.equals(t.getHomeTeam()) && t.getHomeScore() < t.getAwayScore())
                || (teamName.equals(t.getAwayTeam()) && t.getHomeScore() > t.getAwayScore()))
        .count();
  }

  private int getGoalsFor(String teamName) {
    int goalsHome = matches
        .stream()
        .filter(t -> teamName.equals(t.getHomeTeam()))
        .map(Match::getHomeScore)
        .reduce(0, Integer::sum);

    int goalsAway = matches
        .stream()
        .filter(t -> teamName.equals(t.getAwayTeam()))
        .map(Match::getAwayScore)
        .reduce(0, Integer::sum);

    return goalsHome + goalsAway;
  }

  private int getGoalsAgainst(String teamName) {
    int goalsAgainstInHome = matches
        .stream()
        .filter(t -> teamName.equals(t.getHomeTeam()))
        .map(Match::getAwayScore)
        .reduce(0, Integer::sum);

    int goalsAgainstInAway = matches
        .stream()
        .filter(t -> teamName.equals(t.getAwayTeam()))
        .map(Match::getHomeScore)
        .reduce(0, Integer::sum);

    return goalsAgainstInHome + goalsAgainstInAway;
  }
}
