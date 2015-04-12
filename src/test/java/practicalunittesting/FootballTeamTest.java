package practicalunittesting;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sharath on 4/5/15.
 */
@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

    private static final int ANY_NUMBER = 123;

    public Object[] noOfGamesWon() {
        return $(0, 1, 2);
    }

    @Test
    @Parameters(method = "noOfGamesWon")
    public void constructorShouldSetGamesWon(int noOfGamesWon) {
        FootballTeam team = new FootballTeam(noOfGamesWon);
        assertEquals(noOfGamesWon + " games passed to constructor, but "
                + team.getGamesWon() + " were returned", noOfGamesWon, team.getGamesWon());
    }

    public Object[] invalidNoOfGamesWon() {
        return $(-10, -1);
    }

    @Parameters(method = "invalidNoOfGamesWon")
    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowIAEForInvalidNoOfGamesWon(int noOfGamesWon) {
        new FootballTeam(noOfGamesWon);
    }

    @Test
    public void shouldBePossibleToCompareTeams() {
        FootballTeam team = new FootballTeam(ANY_NUMBER);
        assertTrue("Football team should implement Comparable", team instanceof Comparable);
    }

    @Test
    public void teamsWithMoreMatchesWonShouldBeGreater() {
        FootballTeam team_2 = new FootballTeam(2);
        FootballTeam team_3 = new FootballTeam(3);

        assertTrue("Team with " + team_3.getGamesWon() + " games won should be ranked before" +
                        " the team with " + team_2.getGamesWon() + " games won",
                team_3.compareTo(team_2) > 0);
    }

    @Test
    public void teamsWithLessMatchesWonShouldBeLesser() {
        FootballTeam team_2 = new FootballTeam(2);
        FootballTeam team_3 = new FootballTeam(3);

        assertTrue("Team with " + team_2.getGamesWon() + " games won should be ranked after" +
                        " the team with " + team_3.getGamesWon() + " games won",
                team_2.compareTo(team_3) < 0);
    }

    @Test
    public void teamsWithSameNoOfMatchesWonShouldBeEqual() {
        FootballTeam teamA = new FootballTeam(2);
        FootballTeam teamB = new FootballTeam(2);

        assertTrue("both teams have won the same number of games: "
                + teamA.getGamesWon() + " vs. " + teamB.getGamesWon()
                + " and should be ranked equal",
                teamA.compareTo(teamB) == 0);
    }
}
