package com.pulselive.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class LeagueTableUtilityTests
{

  @Test
  public void shouldReturnUnduplicatedTeamNamesWithHomeAndAwayMatches()
  {
    // Arrange
    List<Match> matches = Arrays
        .asList(new Match(Team.LIVERPOOL.getName(), Team.FULHAM.getName(), 0, 0),
            new Match(Team.LEEDS.getName(), Team.LIVERPOOL.getName(), 0, 0),
            new Match(Team.FULHAM.getName(), Team.LEEDS.getName(), 0, 0),
            new Match(Team.MAN_UTD.getName(), Team.MAN_CITY.getName(), 0, 0));

    // Act
    List<String> teamNames = LeagueTableUtility.getUniqueTeamNames(matches);

    // Assert
    assertEquals(5, teamNames.size());
    assertTrue(teamNames.contains(Team.LIVERPOOL.getName()));
    assertTrue(teamNames.contains(Team.FULHAM.getName()));
    assertTrue(teamNames.contains(Team.LEEDS.getName()));
    assertTrue(teamNames.contains(Team.MAN_UTD.getName()));
    assertTrue(teamNames.contains(Team.MAN_CITY.getName()));
  }

  @Test
  public void shouldReturnTheAmountOfPlayedMatchesAtHomeAndAway()
  {
    // Arrange
    List<Match> matches = Arrays
        .asList(new Match(Team.LIVERPOOL.getName(), Team.FULHAM.getName(), 0, 0),
            new Match(Team.LEEDS.getName(), Team.LIVERPOOL.getName(), 0, 0),
            new Match(Team.FULHAM.getName(), Team.LEEDS.getName(), 0, 0),
            new Match(Team.MAN_UTD.getName(), Team.MAN_CITY.getName(), 0, 0));

    // Act
    int played = LeagueTableUtility.getPlayed(matches, Team.LIVERPOOL.getName());

    // Assert
    assertEquals(2, played);
  }

  @Test
  public void shouldReturnTheAmountOfWonMatchesAtHomeAndAway()
  {
    // Arrange
    List<Match> matches = Arrays
        .asList(new Match(Team.LIVERPOOL.getName(), Team.FULHAM.getName(), 2, 0),
            new Match(Team.LEEDS.getName(), Team.LIVERPOOL.getName(), 0, 2),
            new Match(Team.LIVERPOOL.getName(), Team.LEEDS.getName(), 1, 2),
            new Match(Team.SOUTHAMPTON.getName(), Team.LIVERPOOL.getName(), 2, 1),
            new Match(Team.SPURS.getName(), Team.LIVERPOOL.getName(), 1, 0));

    // Act
    int won = LeagueTableUtility.getWon(matches, Team.LIVERPOOL.getName());

    // Assert
    assertEquals(2, won);
  }

  @Test
  public void shouldReturnTheAmountOfDrawnMatchesAtHomeAndAway()
  {
    // Arrange
    List<Match> matches = Arrays
        .asList(new Match(Team.LIVERPOOL.getName(), Team.FULHAM.getName(), 0, 0),
            new Match(Team.LEEDS.getName(), Team.LIVERPOOL.getName(), 0, 0),
            new Match(Team.LIVERPOOL.getName(), Team.LEEDS.getName(), 1, 2),
            new Match(Team.SOUTHAMPTON.getName(), Team.LIVERPOOL.getName(), 0, 0),
            new Match(Team.SPURS.getName(), Team.LIVERPOOL.getName(), 0, 0));

    // Act
    int drawn = LeagueTableUtility.getDrawn(matches, Team.LIVERPOOL.getName());

    // Assert
    assertEquals(4, drawn);
  }

  @Test
  public void shouldReturnTheAmountOfLostMatchesAtHomeAndAway()
  {
    // Arrange
    List<Match> matches = Arrays
        .asList(new Match(Team.LIVERPOOL.getName(), Team.FULHAM.getName(), 0, 2),
            new Match(Team.LEEDS.getName(), Team.LIVERPOOL.getName(), 2, 0),
            new Match(Team.LIVERPOOL.getName(), Team.LEEDS.getName(), 1, 2),
            new Match(Team.SOUTHAMPTON.getName(), Team.LIVERPOOL.getName(), 1, 2),
            new Match(Team.SPURS.getName(), Team.LIVERPOOL.getName(), 0, 1));

    // Act
    int lost = LeagueTableUtility.getLost(matches, Team.LIVERPOOL.getName());

    // Assert
    assertEquals(3, lost);
  }

  @Test
  public void shouldReturnTheAmountOfGoalsForAtHomeAndAwayMatches()
  {
    // Arrange
    List<Match> matches = Arrays
        .asList(new Match(Team.LIVERPOOL.getName(), Team.FULHAM.getName(), 3, 2),
            new Match(Team.LEEDS.getName(), Team.LIVERPOOL.getName(), 2, 3),
            new Match(Team.LIVERPOOL.getName(), Team.LEEDS.getName(), 1, 2),
            new Match(Team.SOUTHAMPTON.getName(), Team.LIVERPOOL.getName(), 1, 1),
            new Match(Team.SPURS.getName(), Team.LIVERPOOL.getName(), 2, 2));

    // Act
    int goalsFor = LeagueTableUtility.getGoalsFor(matches, Team.LIVERPOOL.getName());

    // Assert
    assertEquals(10, goalsFor);
  }

  @Test
  public void shouldReturnTheAmountOfGoalsAgainstAtHomeAndAwayMatches()
  {
    // Arrange
    List<Match> matches = Arrays
        .asList(new Match(Team.LIVERPOOL.getName(), Team.FULHAM.getName(), 3, 2),
            new Match(Team.LEEDS.getName(), Team.LIVERPOOL.getName(), 2, 3),
            new Match(Team.LIVERPOOL.getName(), Team.LEEDS.getName(), 1, 2),
            new Match(Team.SOUTHAMPTON.getName(), Team.LIVERPOOL.getName(), 1, 1),
            new Match(Team.SPURS.getName(), Team.LIVERPOOL.getName(), 2, 2));

    // Act
    int goalsAgainst = LeagueTableUtility.getGoalsAgainst(matches, Team.LIVERPOOL.getName());

    // Assert
    assertEquals(9, goalsAgainst);
  }
}
