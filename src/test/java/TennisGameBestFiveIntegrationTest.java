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

    private void addWinningSetForAPlayer() {
        addWinningGame();
    }
    

    private void addWinningGame() {
        for (int i = 0; i< 4; i++) {
            tennisGame.addGame("A");
        }
    }
}