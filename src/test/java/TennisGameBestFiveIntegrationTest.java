import Tennis.PairTennisGameScore;
import Tennis.TennisGame;
import Tennis.TypeOfTennisMatch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisGameBestFiveIntegrationTest {

    private TennisGame tennisGame;

    @Before
    public void setUp() {

        tennisGame = new TennisGame(TypeOfTennisMatch.BestOfFive);
    }
    @Test
    public void BestOfFiveGameIsNotOver(){
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        Assert.assertFalse(tennisGame.IsMatchOver());
    }
    @Test
    public void BestOfFiveGameIsOver(){
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        Assert.assertTrue(tennisGame.IsMatchOver());
    }

    @Test
    public void GetWinnerName(){
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        addWinningSetForAPlayer();
        Assert.assertEquals("A", tennisGame.GetWinner());
    }
    @Test
    public void BestOfFiveGameLong(){
        addWinningSetForAPlayer();
        addWinningSetForBPlayer();
        addWinningSetForAPlayer();
        addWinningSetForBPlayer();
        addWinningSetForAPlayer();
        PairTennisGameScore ptgs = tennisGame.getCurrentScore();
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
            tennisGame.addGame(player);
        }
    }
}