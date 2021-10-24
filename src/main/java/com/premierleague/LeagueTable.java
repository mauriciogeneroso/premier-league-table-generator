package com.premierleague;

import java.util.*;
import java.util.stream.Collectors;

public class LeagueTable {

    private final static int WIN_POINTS = 3;
    private final static int DRAWN_POINTS = 1;

    private final List<Match> matches;

    public LeagueTable(final List<Match> matches) {
        this.matches = matches;
    }

    /**
     * Get the ordered list of league table entries for this league table.
     *
     * @return
     */
    public List<LeagueTableEntry> getTableEntries() {
        Map<String, LeagueTableEntry> leagueTableEntries = new HashMap<>();

        matches.forEach(match -> {
            var homeTeam = getOrCreate(leagueTableEntries, match.getHomeTeam());
            var awayTeam = getOrCreate(leagueTableEntries, match.getAwayTeam());

            homeTeam.increasePlayed();
            awayTeam.increasePlayed();
            countScores(match, homeTeam, awayTeam);
            countMatchResult(match, homeTeam, awayTeam);
        });

        return leagueTableEntries.values().stream()
                .sorted(Comparator.comparing(LeagueTableEntry::getPoints).reversed()
                        .thenComparing(LeagueTableEntry::getGoalDifference, Comparator.reverseOrder())
                        .thenComparing(LeagueTableEntry::getGoalsFor, Comparator.reverseOrder())
                        .thenComparing(LeagueTableEntry::getTeamName)).collect(Collectors.toList());
    }

    private LeagueTableEntry getOrCreate(Map<String, LeagueTableEntry> leagueTableEntries, String teamName) {
        var leagueTableEntry = leagueTableEntries.get(teamName);
        if (leagueTableEntry != null) {
            return leagueTableEntry;
        }

        leagueTableEntries.put(teamName, new LeagueTableEntry(teamName));
        return leagueTableEntries.get(teamName);
    }

    private void countScores(Match match, LeagueTableEntry homeTeam, LeagueTableEntry awayTeam) {
        homeTeam.increaseGoalsFor(match.getHomeScore());
        awayTeam.increaseGoalsFor(match.getAwayScore());
        homeTeam.increaseGoalsAgainst(match.getAwayScore());
        awayTeam.increaseGoalsAgainst(match.getHomeScore());
    }

    private void countMatchResult(Match match, LeagueTableEntry homeTeam, LeagueTableEntry awayTeam) {
        if (match.getHomeScore() > match.getAwayScore()) {
            homeTeam.increaseWon();
            homeTeam.increasePoints(WIN_POINTS);
            awayTeam.increaseLost();
        } else if (match.getHomeScore() < match.getAwayScore()) {
            homeTeam.increaseLost();
            awayTeam.increaseWon();
            awayTeam.increasePoints(WIN_POINTS);
        } else {
            homeTeam.increaseDrawn();
            homeTeam.increasePoints(DRAWN_POINTS);
            awayTeam.increaseDrawn();
            awayTeam.increasePoints(DRAWN_POINTS);
        }
    }
}