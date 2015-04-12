package practicalunittesting;

/**
 * Created by sharath on 4/5/15.
 */
public class FootballTeam implements Comparable<FootballTeam>{
    private int gamesWon;

    public FootballTeam(int gamesWon) {
        if(gamesWon < 0)
            throw new IllegalArgumentException();
        this.gamesWon = gamesWon;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    @Override
    public int compareTo(FootballTeam otherTeam) {
        return this.getGamesWon() - otherTeam.getGamesWon();
    }
}
