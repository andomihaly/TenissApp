import Tennis.TennisMatch;
import Tennis.TypeOfTennisMatch;

public class TennisMatchForTest extends TennisMatch {

    public TennisMatchForTest(TypeOfTennisMatch totm) {
        super(totm);
    }
    public int[][] getNumberOfWonGameInSets(){
        return numberOfWonGamesInSets;
    }
}
