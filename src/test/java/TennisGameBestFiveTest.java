import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisGameBestFiveTest {

    private TennisGame tennisGame;

    @Before
    public void setUp() {

        tennisGame = new TennisGame(TypeOfTennisMatch.BestOfFive);
    }
    @Test
    public void BestOfFiveGameIsNotOver(){
        addWinningSetForAPlayer();
        tennisGame.getCurrentScore();
        addWinningSetForAPlayer();
        tennisGame.getCurrentScore();
        Assert.assertFalse(tennisGame.IsMatchOver());
    }
    @Test
    public void BestOfFiveGameIsOver(){
        addWinningSetForAPlayer();
        tennisGame.getCurrentScore();
        addWinningSetForAPlayer();
        tennisGame.getCurrentScore();
        addWinningSetForAPlayer();
        tennisGame.getCurrentScore();
        Assert.assertTrue(tennisGame.IsMatchOver());
    }

    @Test
    public void GetWinnerName(){
        addWinningSetForAPlayer();
        tennisGame.getCurrentScore();
        addWinningSetForAPlayer();
        tennisGame.getCurrentScore();
        addWinningSetForAPlayer();
        tennisGame.getCurrentScore();
        Assert.assertEquals("A", tennisGame.GetWinner());
    }

    private void addWinningSetForAPlayer() {
        addWinningGame();
    }
    

    private void addWinningGame() {
        for (int i = 0; i< 4; i++) {
            tennisGame.addGame("A");
        }
    }
}