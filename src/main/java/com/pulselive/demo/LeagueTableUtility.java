package com.pulselive.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeagueTableUtility
{

  private LeagueTableUtility()
  {
  }

  public static List<String> getUniqueTeamNames(List<Match> matches)
  {
    //@formatter:off
    return matches.stream()
        .flatMap(t -> Stream.of(t.getHomeTeam(), t.getAwayTeam()))
        .distinct()
        .collect(Collectors.toList());
    //@formatter:on
  }

  public static int getPlayed(List<Match> matches, String teamName)
  {
    //@formatter:off
    return (int) matches.stream()
        .filter(t -> teamName.equals(t.getHomeTeam()) || teamName.equals(t.getAwayTeam()))
        .count();
    //@formatter:off
  }

  public static int getWon(List<Match> matches, String teamName)
  {
    //@formatter:off
    return (int) matches.stream()
        .filter(t -> (teamName.equals(t.getHomeTeam()) && t.getHomeScore() > t.getAwayScore())
            || (teamName.equals(t.getAwayTeam()) && t.getHomeScore() < t.getAwayScore()))
        .count();
    //@formatter:on
  }

  public static int getDrawn(List<Match> matches, String teamName)
  {
    //@formatter:off
    return (int) matches.stream()
        .filter(t -> (teamName.equals(t.getHomeTeam()) || teamName.equals(t.getAwayTeam()))
            && t.getHomeScore() == t.getAwayScore())
        .count();
    //@formatter:on
  }

  public static int getLost(List<Match> matches, String teamName)
  {
    //@formatter:off
    return (int) matches.stream()
        .filter(t -> (teamName.equals(t.getHomeTeam()) && t.getHomeScore() < t.getAwayScore())
            || (teamName.equals(t.getAwayTeam()) && t.getHomeScore() > t.getAwayScore()))
        .count();
    //@formatter:on
  }

  public static int getGoalsFor(List<Match> matches, String teamName)
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

  public static int getGoalsAgainst(List<Match> matches, String teamName)
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
