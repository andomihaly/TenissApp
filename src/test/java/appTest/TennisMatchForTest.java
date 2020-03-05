package appTest;

import app.Tennis.TennisMatch;
import app.Tennis.TypeOfTennisMatch;

public class TennisMatchForTest extends TennisMatch {

    public TennisMatchForTest(TypeOfTennisMatch totm) {
        super(totm);
    }

    public int[][] getNumberOfWonGameInSets() {
        return numberOfWonGamesInSets;
    }
}
