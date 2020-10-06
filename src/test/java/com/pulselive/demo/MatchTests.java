package com.pulselive.demo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MatchTests {

  @Test
  public void test() {
    // Arrange
    Match match1 = new Match(Team.WEST_HAM.getName(), Team.NEWCASTLE.getName(), 0, 2);
    Match match2 = new Match(Team.LIVERPOOL.getName(), Team.LEEDS.getName(), 4, 3);
    Match match3 = new Match(Team.CRYSTAL_PALACE.getName(), Team.SOUTHAMPTON.getName(), 1, 0);
    Match match4 = new Match(Team.FULHAM.getName(), Team.ARSENAL.getName(), 0, 3);

    Match match5 = new Match(Team.SPURS.getName(), Team.EVERTON.getName(), 0, 1);
    Match match6 = new Match(Team.WEST_BROM.getName(), Team.LEICESTER.getName(), 0, 3);

    Match match7 = new Match(Team.BRIGHTON.getName(), Team.CHELSEA.getName(), 1, 3);
    Match match8 = new Match(Team.SHEFFIELD_UTD.getName(), Team.WOLVES.getName(), 0, 2);

    Match match9 = new Match(Team.ARSENAL.getName(), Team.WEST_HAM.getName(), 2, 1);
    Match match10 = new Match(Team.MAN_UTD.getName(), Team.CRYSTAL_PALACE.getName(), 1, 3);
    Match match11 = new Match(Team.LEEDS.getName(), Team.FULHAM.getName(), 4, 3);
    Match match12 = new Match(Team.EVERTON.getName(), Team.WEST_BROM.getName(), 5, 2);

    Match match13 = new Match(Team.LEICESTER.getName(), Team.BURNLEY.getName(), 4, 2);
    Match match14 = new Match(Team.CHELSEA.getName(), Team.LIVERPOOL.getName(), 0, 2);
    Match match15 = new Match(Team.NEWCASTLE.getName(), Team.BRIGHTON.getName(), 0, 3);
    Match match16 = new Match(Team.SOUTHAMPTON.getName(), Team.SPURS.getName(), 2, 5);

    Match match17 = new Match(Team.WOLVES.getName(), Team.MAN_CITY.getName(), 1, 3);
    Match match18 = new Match(Team.ASTON_VILLA.getName(), Team.SHEFFIELD_UTD.getName(), 1, 0);

    Match match19 = new Match(Team.BURNLEY.getName(), Team.SOUTHAMPTON.getName(), 0, 1);
    Match match20 = new Match(Team.WEST_BROM.getName(), Team.CHELSEA.getName(), 3, 3);
    Match match21 = new Match(Team.CRYSTAL_PALACE.getName(), Team.EVERTON.getName(), 1, 2);
    Match match22 = new Match(Team.BRIGHTON.getName(), Team.MAN_UTD.getName(), 2, 3);

    Match match23 = new Match(Team.WEST_HAM.getName(), Team.WOLVES.getName(), 4, 0);
    Match match24 = new Match(Team.MAN_CITY.getName(), Team.LEICESTER.getName(), 2, 5);
    Match match25 = new Match(Team.SPURS.getName(), Team.NEWCASTLE.getName(), 1, 1);
    Match match26 = new Match(Team.SHEFFIELD_UTD.getName(), Team.LEEDS.getName(), 0, 1);

    Match match27 = new Match(Team.LIVERPOOL.getName(), Team.ARSENAL.getName(), 3, 1);
    Match match28 = new Match(Team.FULHAM.getName(), Team.ASTON_VILLA.getName(), 0, 3);

    Match match29 = new Match(Team.NEWCASTLE.getName(), Team.BURNLEY.getName(), 3, 1);
    Match match30 = new Match(Team.LEEDS.getName(), Team.MAN_CITY.getName(), 1, 1);
    Match match31 = new Match(Team.EVERTON.getName(), Team.BRIGHTON.getName(), 4, 2);
    Match match32 = new Match(Team.CHELSEA.getName(), Team.CRYSTAL_PALACE.getName(), 4, 0);

    Match match33 = new Match(Team.ASTON_VILLA.getName(), Team.LIVERPOOL.getName(), 7, 2);
    Match match34 = new Match(Team.MAN_UTD.getName(), Team.SPURS.getName(), 1, 6);
    Match match35 = new Match(Team.WOLVES.getName(), Team.FULHAM.getName(), 1, 0);
    Match match36 = new Match(Team.ARSENAL.getName(), Team.SHEFFIELD_UTD.getName(), 2, 1);
    Match match37 = new Match(Team.SOUTHAMPTON.getName(), Team.WEST_BROM.getName(), 2, 0);
    Match match38 = new Match(Team.LEICESTER.getName(), Team.WEST_HAM.getName(), 0, 3);

    List<Match> matches = new ArrayList<>();
    matches.add(match1);
    matches.add(match2);
    matches.add(match3);
    matches.add(match4);
    matches.add(match5);
    matches.add(match6);
    matches.add(match7);
    matches.add(match8);
    matches.add(match9);
    matches.add(match10);
    matches.add(match11);
    matches.add(match12);
    matches.add(match13);
    matches.add(match14);
    matches.add(match15);
    matches.add(match16);
    matches.add(match17);
    matches.add(match18);
    matches.add(match19);
    matches.add(match20);
    matches.add(match21);
    matches.add(match22);
    matches.add(match23);
    matches.add(match24);
    matches.add(match25);
    matches.add(match26);
    matches.add(match27);
    matches.add(match28);
    matches.add(match29);
    matches.add(match30);
    matches.add(match31);
    matches.add(match32);
    matches.add(match33);
    matches.add(match34);
    matches.add(match35);
    matches.add(match36);
    matches.add(match37);
    matches.add(match38);

    LeagueTable leagueTable = new LeagueTable(matches);

    // Act
    List<LeagueTableEntry> tableEntries = leagueTable.getTableEntries();

    // Assert
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
