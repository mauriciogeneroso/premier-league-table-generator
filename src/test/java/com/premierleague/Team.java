package com.premierleague;

public enum Team {
    //@formatter:off
    ARSENAL("Arsenal"),
    ASTON_VILLA("Aston Villa"),
    BRIGHTON("Brighton And Hove Albion"),
    BURNLEY("Burnley"),
    CHELSEA("Chelsea"),
    CRYSTAL_PALACE("Crystal Palace"),
    EVERTON("Everton"),
    FULHAM("Fulham"),
    LEEDS("Leeds United"),
    LEICESTER("Leicester City"),
    LIVERPOOL("Liverpool"),
    MAN_CITY("Manchester City"),
    MAN_UTD("Manchester United"),
    NEWCASTLE("Newcastle United"),
    SHEFFIELD_UTD("Sheffield United"),
    SOUTHAMPTON("Southampton"),
    SPURS("Tottenham Hotspur"),
    WEST_BROM("West Bromwich Albion"),
    WEST_HAM("West Ham United"),
    WOLVES("Wolverhampton Wanderes");
    //@formatter:on

    private String name;

    Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
