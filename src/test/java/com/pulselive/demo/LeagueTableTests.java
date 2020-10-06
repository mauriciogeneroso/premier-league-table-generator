package com.pulselive.demo;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class LeagueTableTests {

  private static final boolean PRINT_TABLE_ON_CONSOLE = true;

  @Test
  public void officialTest() {
    // Arrange
    List<Match> matches = Arrays.asList(
        new Match(Team.WEST_HAM.getName(), Team.NEWCASTLE.getName(), 0, 2),
        new Match(Team.LIVERPOOL.getName(), Team.LEEDS.getName(), 4, 3),
        new Match(Team.CRYSTAL_PALACE.getName(), Team.SOUTHAMPTON.getName(), 1, 0),
        new Match(Team.FULHAM.getName(), Team.ARSENAL.getName(), 0, 3),

        new Match(Team.SPURS.getName(), Team.EVERTON.getName(), 0, 1),
        new Match(Team.WEST_BROM.getName(), Team.LEICESTER.getName(), 0, 3),

        new Match(Team.BRIGHTON.getName(), Team.CHELSEA.getName(), 1, 3),
        new Match(Team.SHEFFIELD_UTD.getName(), Team.WOLVES.getName(), 0, 2),

        new Match(Team.ARSENAL.getName(), Team.WEST_HAM.getName(), 2, 1),
        new Match(Team.MAN_UTD.getName(), Team.CRYSTAL_PALACE.getName(), 1, 3),
        new Match(Team.LEEDS.getName(), Team.FULHAM.getName(), 4, 3),
        new Match(Team.EVERTON.getName(), Team.WEST_BROM.getName(), 5, 2),

        new Match(Team.LEICESTER.getName(), Team.BURNLEY.getName(), 4, 2),
        new Match(Team.CHELSEA.getName(), Team.LIVERPOOL.getName(), 0, 2),
        new Match(Team.NEWCASTLE.getName(), Team.BRIGHTON.getName(), 0, 3),
        new Match(Team.SOUTHAMPTON.getName(), Team.SPURS.getName(), 2, 5),

        new Match(Team.WOLVES.getName(), Team.MAN_CITY.getName(), 1, 3),
        new Match(Team.ASTON_VILLA.getName(), Team.SHEFFIELD_UTD.getName(), 1, 0),

        new Match(Team.BURNLEY.getName(), Team.SOUTHAMPTON.getName(), 0, 1),
        new Match(Team.WEST_BROM.getName(), Team.CHELSEA.getName(), 3, 3),
        new Match(Team.CRYSTAL_PALACE.getName(), Team.EVERTON.getName(), 1, 2),
        new Match(Team.BRIGHTON.getName(), Team.MAN_UTD.getName(), 2, 3),

        new Match(Team.WEST_HAM.getName(), Team.WOLVES.getName(), 4, 0),
        new Match(Team.MAN_CITY.getName(), Team.LEICESTER.getName(), 2, 5),
        new Match(Team.SPURS.getName(), Team.NEWCASTLE.getName(), 1, 1),
        new Match(Team.SHEFFIELD_UTD.getName(), Team.LEEDS.getName(), 0, 1),

        new Match(Team.LIVERPOOL.getName(), Team.ARSENAL.getName(), 3, 1),
        new Match(Team.FULHAM.getName(), Team.ASTON_VILLA.getName(), 0, 3),

        new Match(Team.NEWCASTLE.getName(), Team.BURNLEY.getName(), 3, 1),
        new Match(Team.LEEDS.getName(), Team.MAN_CITY.getName(), 1, 1),
        new Match(Team.EVERTON.getName(), Team.BRIGHTON.getName(), 4, 2),
        new Match(Team.CHELSEA.getName(), Team.CRYSTAL_PALACE.getName(), 4, 0),

        new Match(Team.ASTON_VILLA.getName(), Team.LIVERPOOL.getName(), 7, 2),
        new Match(Team.MAN_UTD.getName(), Team.SPURS.getName(), 1, 6),
        new Match(Team.WOLVES.getName(), Team.FULHAM.getName(), 1, 0),
        new Match(Team.ARSENAL.getName(), Team.SHEFFIELD_UTD.getName(), 2, 1),
        new Match(Team.SOUTHAMPTON.getName(), Team.WEST_BROM.getName(), 2, 0),
        new Match(Team.LEICESTER.getName(), Team.WEST_HAM.getName(), 0, 3)
    );

    LeagueTable leagueTable = new LeagueTable(matches);

    List<LeagueTableEntry> expectedTableEntries = Arrays.asList(
        new LeagueTableEntry(
            Team.EVERTON.getName(), 4, 4, 0, 0, 12, 5, 7, 12),
        new LeagueTableEntry(
            Team.ASTON_VILLA.getName(), 3, 3, 0, 0, 11, 2, 9, 9),
        new LeagueTableEntry(
            Team.LEICESTER.getName(),4, 3, 0, 1, 12, 7, 5, 9),
        new LeagueTableEntry(
            Team.ARSENAL.getName(), 4, 3, 0, 1, 8, 5, 3, 9),
        new LeagueTableEntry(
            Team.LIVERPOOL.getName(), 4, 3, 0, 1, 11, 11, 0, 9),
        new LeagueTableEntry(
            Team.SPURS.getName(),4, 2, 1, 1, 12, 5, 7, 7),
        new LeagueTableEntry(
            Team.CHELSEA.getName(), 4, 2, 1, 1, 10, 6, 4, 7),
        new LeagueTableEntry(
            Team.LEEDS.getName(), 4, 2, 1, 1, 9, 8, 1, 7),
        new LeagueTableEntry(
            Team.NEWCASTLE.getName(),4, 2, 1, 1, 6, 5, 1, 7),
        new LeagueTableEntry(
            Team.WEST_HAM.getName(), 4, 2, 0, 2, 8, 4, 4, 6),
        new LeagueTableEntry(
            Team.SOUTHAMPTON.getName(), 4, 2, 0, 2, 5, 6, -1, 6),
        new LeagueTableEntry(
            Team.CRYSTAL_PALACE.getName(), 4, 2, 0, 2, 5, 7, -2, 6),
        new LeagueTableEntry(
            Team.WOLVES.getName(), 4, 2, 0, 2, 4, 7, -3, 6),
        new LeagueTableEntry(
            Team.MAN_CITY.getName(), 3, 1, 1, 1, 6, 7, -1, 4),
        new LeagueTableEntry(
            Team.BRIGHTON.getName(), 4, 1, 0, 3, 8, 10, -2, 3),
        new LeagueTableEntry(
            Team.MAN_UTD.getName(), 3, 1, 0, 2, 5, 11, -6, 3),
        new LeagueTableEntry(
            Team.WEST_BROM.getName(), 4, 0, 1, 3, 5, 13, -8, 1),
        new LeagueTableEntry(
            Team.BURNLEY.getName(), 3, 0, 0, 3, 3, 8, -5, 0),
        new LeagueTableEntry(
            Team.SHEFFIELD_UTD.getName(), 4, 0, 0, 4, 1, 6, -5, 0),
        new LeagueTableEntry(
            Team.FULHAM.getName(), 4, 0, 0, 4, 3, 11, -8, 0)
    );

    // Act
    List<LeagueTableEntry> resultedTableEntries = leagueTable.getTableEntries();

    // Assert
    assertResultedTableEntriesWithExpectedTableEntries(expectedTableEntries, resultedTableEntries);
  }

  @Test
  public void shouldOrderLeagueTableByTotalPoints() {
    // Arrange
    List<Match> matches = Arrays.asList(
        new Match(Team.ARSENAL.getName(), Team.LIVERPOOL.getName(), 0, 3),
        new Match(Team.LIVERPOOL.getName(), Team.FULHAM.getName(), 3, 1),
        new Match(Team.LIVERPOOL.getName(), Team.SOUTHAMPTON.getName(), 1, 0),
        new Match(Team.FULHAM.getName(), Team.ARSENAL.getName(), 0, 1),
        new Match(Team.SOUTHAMPTON.getName(), Team.ARSENAL.getName(), 2, 2)
    );

    LeagueTable leagueTable = new LeagueTable(matches);

    List<LeagueTableEntry> expectedTableEntries = Arrays.asList(
        new LeagueTableEntry(
            Team.LIVERPOOL.getName(), 3, 3, 0, 0, 7, 1, 6, 9),
        new LeagueTableEntry(
            Team.ARSENAL.getName(), 3, 1, 1, 1, 3, 5, -2, 4),
        new LeagueTableEntry(
            Team.SOUTHAMPTON.getName(), 2, 0, 1, 1, 2, 3, -1, 1),
        new LeagueTableEntry(
            Team.FULHAM.getName(), 2, 0, 0, 2, 1, 4, -3, 0)
    );

    // Act
    List<LeagueTableEntry> resultedTableEntries = leagueTable.getTableEntries();

    // Assert
    assertResultedTableEntriesWithExpectedTableEntries(expectedTableEntries, resultedTableEntries);
  }

  @Test
  public void shouldOrderLeagueTableByGoalDifference() {
    // Arrange
    List<Match> matches = Arrays.asList(
        new Match(Team.WEST_HAM.getName(), Team.MAN_UTD.getName(), 2, 0),
        new Match(Team.WEST_HAM.getName(), Team.FULHAM.getName(), 1, 0),
        new Match(Team.SHEFFIELD_UTD.getName(), Team.MAN_UTD.getName(), 1, 0),
        new Match(Team.SHEFFIELD_UTD.getName(), Team.FULHAM.getName(), 1, 0)
    );

    LeagueTable leagueTable = new LeagueTable(matches);

    List<LeagueTableEntry> expectedTableEntries = Arrays.asList(
        new LeagueTableEntry(
            Team.WEST_HAM.getName(), 2, 2, 0, 0, 3, 0, 3, 6),
        new LeagueTableEntry(
            Team.SHEFFIELD_UTD.getName(), 2, 2, 0, 0, 2, 0, 2, 6),
        new LeagueTableEntry(
            Team.FULHAM.getName(), 2, 0, 0, 2, 0, 2, -2, 0),
        new LeagueTableEntry(
            Team.MAN_UTD.getName(), 2, 0, 0, 2, 0, 3, -3, 0)
    );

    // Act
    List<LeagueTableEntry> resultedTableEntries = leagueTable.getTableEntries();

    // Assert
    assertResultedTableEntriesWithExpectedTableEntries(expectedTableEntries, resultedTableEntries);
  }

  @Test
  public void shouldOrderLeagueTableByGoalsScored() {
    // Arrange
    List<Match> matches = Arrays.asList(
        new Match(Team.MAN_UTD.getName(), Team.WEST_HAM.getName(), 3, 1),
        new Match(Team.MAN_UTD.getName(), Team.FULHAM.getName(), 2, 1),
        new Match(Team.SHEFFIELD_UTD.getName(), Team.WEST_HAM.getName(), 2, 1),
        new Match(Team.SHEFFIELD_UTD.getName(), Team.FULHAM.getName(), 2, 0)
    );

    LeagueTable leagueTable = new LeagueTable(matches);

    List<LeagueTableEntry> expectedTableEntries = Arrays.asList(
        new LeagueTableEntry(
            Team.MAN_UTD.getName(), 2, 2, 0, 0, 5, 2, 3, 6),
        new LeagueTableEntry(
            Team.SHEFFIELD_UTD.getName(), 2, 2, 0, 0, 4, 1, 3, 6),
        new LeagueTableEntry(
            Team.WEST_HAM.getName(), 2, 0, 0, 2, 2, 5, -3, 0),
        new LeagueTableEntry(
            Team.FULHAM.getName(), 2, 0, 0, 2, 1, 4, -3, 0)
    );

    // Act
    List<LeagueTableEntry> resultedTableEntries = leagueTable.getTableEntries();

    // Assert
    assertResultedTableEntriesWithExpectedTableEntries(expectedTableEntries, resultedTableEntries);
  }

  @Test
  public void shouldOrderLeagueTableByTeamName() {
    // Arrange
    List<Match> matches = Arrays.asList(
        new Match(Team.FULHAM.getName(), Team.WEST_HAM.getName(), 2, 0),
        new Match(Team.FULHAM.getName(), Team.ARSENAL.getName(), 2, 0),
        new Match(Team.MAN_CITY.getName(), Team.WEST_HAM.getName(), 2, 0),
        new Match(Team.MAN_CITY.getName(), Team.ARSENAL.getName(), 2, 0)
    );

    LeagueTable leagueTable = new LeagueTable(matches);

    List<LeagueTableEntry> expectedTableEntries = Arrays.asList(
        new LeagueTableEntry(
            Team.FULHAM.getName(), 2, 2, 0, 0, 4, 0, 4, 6),
        new LeagueTableEntry(
            Team.MAN_CITY.getName(), 2, 2, 0, 0, 4, 0, 4, 6),
        new LeagueTableEntry(
            Team.ARSENAL.getName(), 2, 0, 0, 2, 0, 4, -4, 0),
        new LeagueTableEntry(
            Team.WEST_HAM.getName(), 2, 0, 0, 2, 0, 4, -4, 0)
    );

    // Act
    List<LeagueTableEntry> resultedTableEntries = leagueTable.getTableEntries();

    // Assert
    assertResultedTableEntriesWithExpectedTableEntries(expectedTableEntries, resultedTableEntries);
  }

  private void assertResultedTableEntriesWithExpectedTableEntries(
      List<LeagueTableEntry> expectedTableEntries, List<LeagueTableEntry> resultedTableEntries) {

    if (expectedTableEntries.size() != resultedTableEntries.size()) {
      Assert.fail(
          "The expected table entries and the resulted table entries don't have the same size");
    }

    if (PRINT_TABLE_ON_CONSOLE) {
      printTableResultOnConsole(resultedTableEntries);
    }

    for (int i = 0; i < expectedTableEntries.size(); i++) {
      Assert.assertEquals(expectedTableEntries.get(i).getTeamName(),
          resultedTableEntries.get(i).getTeamName());
      Assert.assertEquals(expectedTableEntries.get(i).getPlayed(), resultedTableEntries.get(i).getPlayed());
      Assert.assertEquals(expectedTableEntries.get(i).getWon(), resultedTableEntries.get(i).getWon());
      Assert.assertEquals(expectedTableEntries.get(i).getDrawn(), resultedTableEntries.get(i).getDrawn());
      Assert.assertEquals(expectedTableEntries.get(i).getLost(), resultedTableEntries.get(i).getLost());
      Assert.assertEquals(expectedTableEntries.get(i).getGoalsFor(),
          resultedTableEntries.get(i).getGoalsFor());
      Assert.assertEquals(expectedTableEntries.get(i).getGoalsAgainst(),
          resultedTableEntries.get(i).getGoalsAgainst());
      Assert.assertEquals(expectedTableEntries.get(i).getGoalDifference(),
          resultedTableEntries.get(i).getGoalDifference());
      Assert.assertEquals(expectedTableEntries.get(i).getPoints(), resultedTableEntries.get(i).getPoints());
    }
  }

  private void printTableResultOnConsole(List<LeagueTableEntry> tableEntries) {
    System.out.printf("%8s %-30s %6s %6s %6s %6s %6s %6s %6s %6s\n",
        "Position", "Club", "Played", "Won", "Drawn", "Lost", "GF", "GA", "GD", "Points");
    for (int i = 0; i < tableEntries.size(); i++) {
      LeagueTableEntry tableEntry = tableEntries.get(i);

      System.out.printf("%-8d %-30s %6d %6d %6d %6d %6d %6d %+6d %6d\n",
          (i + 1),
          tableEntry.getTeamName(),
          tableEntry.getPlayed(),
          tableEntry.getWon(),
          tableEntry.getDrawn(),
          tableEntry.getLost(),
          tableEntry.getGoalsFor(),
          tableEntry.getGoalsAgainst(),
          tableEntry.getGoalDifference(),
          tableEntry.getPoints());
    }
  }
}
