package com.pulselive.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeagueTable
{

  private List<Match> matches;

  public LeagueTable(final List<Match> matches)
  {
    this.matches = matches;
  }

  /**
   * Get the ordered list of league table entries for this league table.
   *
   * @return
   */
  public List<LeagueTableEntry> getTableEntries()
  {
    List<String> teamNames = getUniqueTeamNames();
    List<LeagueTableEntry> leagueTableEntries = new ArrayList<>();

    for (String teamName : teamNames)
    {
      int played = getPlayed(teamName);
      int won = getWon(teamName);
      int drawn = getDrawn(teamName);
      int lost = getLost(teamName);
      int goalsFor = getGoalsFor(teamName);
      int goalsAgainst = getGoalsAgainst(teamName);
      int goalDifference = goalsFor - goalsAgainst;
      int points = (won * 3) + drawn;

      leagueTableEntries.add(
          new LeagueTableEntry(teamName, played, won, drawn, lost, goalsFor, goalsAgainst,
              goalDifference, points));
    }

    leagueTableEntries.sort(Comparator.comparing(LeagueTableEntry::getPoints).reversed()
        .thenComparing(LeagueTableEntry::getGoalDifference, Comparator.reverseOrder())
        .thenComparing(LeagueTableEntry::getGoalsFor, Comparator.reverseOrder())
        .thenComparing(LeagueTableEntry::getTeamName));

    return leagueTableEntries;
  }

  private List<String> getUniqueTeamNames()
  {
    //@formatter:off
    return matches.stream()
        .flatMap(t -> Stream.of(t.getHomeTeam(), t.getAwayTeam()))
        .distinct()
        .collect(Collectors.toList());
    //@formatter:on
  }

  private int getPlayed(String teamName)
  {
    //@formatter:off
    return (int) matches.stream()
        .filter(t -> teamName.equals(t.getHomeTeam()) || teamName.equals(t.getAwayTeam()))
        .count();
    //@formatter:off
  }

  private int getWon(String teamName)
  {
    //@formatter:off
    return (int) matches.stream()
        .filter(t -> (teamName.equals(t.getHomeTeam()) && t.getHomeScore() > t.getAwayScore())
            || (teamName.equals(t.getAwayTeam()) && t.getHomeScore() < t.getAwayScore()))
        .count();
    //@formatter:on
  }

  private int getDrawn(String teamName)
  {
    //@formatter:off
    return (int) matches.stream()
        .filter(t -> (teamName.equals(t.getHomeTeam()) || teamName.equals(t.getAwayTeam()))
            && t.getHomeScore() == t.getAwayScore())
        .count();
    //@formatter:on
  }

  private int getLost(String teamName)
  {
    //@formatter:off
    return (int) matches.stream()
        .filter(t -> (teamName.equals(t.getHomeTeam()) && t.getHomeScore() < t.getAwayScore())
            || (teamName.equals(t.getAwayTeam()) && t.getHomeScore() > t.getAwayScore()))
        .count();
    //@formatter:on
  }

  private int getGoalsFor(String teamName)
  {
    //@formatter:off
    return matches.stream()
        .filter(t -> teamName.equals(t.getHomeTeam()) || teamName.equals(t.getAwayTeam()))
        .map(t ->
          {
            if (teamName.equals(t.getHomeTeam()))
            {
              return t.getHomeScore();
            }
            return t.getAwayScore();
          })
        .reduce(0, Integer::sum);
    //@formatter:on
  }

  private int getGoalsAgainst(String teamName)
  {
    //@formatter:off
    return matches.stream()
        .filter(t -> teamName.equals(t.getHomeTeam()) || teamName.equals(t.getAwayTeam()))
        .map(t ->
          {
            if (teamName.equals(t.getHomeTeam()))
            {
              return t.getAwayScore();
            }
            return t.getHomeScore();
          })
        .reduce(0, Integer::sum);
    //@formatter:on
  }
}
