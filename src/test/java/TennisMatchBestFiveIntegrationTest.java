import Tennis.PairTennisMatchScore;
import Tennis.TennisMatch;
import Tennis.TypeOfTennisMatch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisMatchBestFiveIntegrationTest {

    private TennisMatch tennisMatch;

    @Before
    public void setUp() {

        tennisMatch = new TennisMatch(TypeOfTennisMatch.BestOfFive);
    }
    @Test
    public void BestOfFiveGameIsNotOver(){
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        Assert.assertFalse(tennisMatch.IsMatchOver());
    }
    @Test
    public void BestOfFiveGameIsOver(){
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        Assert.assertTrue(tennisMatch.IsMatchOver());
    }

    @Test
    public void GetWinnerName(){
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        Assert.assertEquals("A", tennisMatch.GetWinner());
    }
    @Test
    public void BestOfFiveGameLong(){
        addWinningSetForAPlayer();
        addWinningSetForBPlayer();
        addWinningSetForAPlayer();
        addWinningSetForBPlayer();
        addWinningSetForAPlayer();
        PairTennisMatchScore ptgs = tennisMatch.getCurrentScore();
        Assert.assertEquals(0, ptgs.playerAScore.game);
        Assert.assertEquals(3, ptgs.playerAScore.set);
        Assert.assertEquals(0, ptgs.playerBScore.game);
        Assert.assertEquals(2, ptgs.playerBScore.set);
    }

    private void addWinningSetForAPlayer() {
        addWinningGame("A");
    }

    private void addWinningSetForBPlayer() {
        addWinningGame("B");
    }

    private void addWinningGame(String player) {
        for (int i = 0; i< 4; i++) {
            tennisMatch.addGame(player);
        }
    }
}