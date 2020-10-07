package com.pulselive.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
    List<String> teamNames = LeagueTableUtility.getUniqueTeamNames(matches);
    List<LeagueTableEntry> leagueTableEntries = new ArrayList<>();

    for (String teamName : teamNames)
    {
      int played = LeagueTableUtility.getPlayed(matches, teamName);
      int won = LeagueTableUtility.getWon(matches, teamName);
      int drawn = LeagueTableUtility.getDrawn(matches, teamName);
      int lost = LeagueTableUtility.getLost(matches, teamName);
      int goalsFor = LeagueTableUtility.getGoalsFor(matches, teamName);
      int goalsAgainst = LeagueTableUtility.getGoalsAgainst(matches, teamName);
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
}
