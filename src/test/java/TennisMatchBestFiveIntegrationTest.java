import Tennis.PairTennisMatchScore;
import Tennis.TennisMatch;
import Tennis.TennisPlayer;
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
        Assert.assertFalse(tennisMatch.isMatchOver());
    }
    @Test
    public void BestOfFiveGameIsOver(){
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        Assert.assertTrue(tennisMatch.isMatchOver());
    }

    @Test
    public void GetWinnerName(){
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        Assert.assertEquals(TennisPlayer.PlayerA, tennisMatch.getWinner());
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
        addWinningGame(TennisPlayer.PlayerA);
    }

    private void addWinningSetForBPlayer() {
        addWinningGame(TennisPlayer.PlayerB);
    }

    private void addWinningGame(TennisPlayer player) {
        for (int i = 0; i< 4; i++) {
            tennisMatch.addGame(player);
        }
    }
}