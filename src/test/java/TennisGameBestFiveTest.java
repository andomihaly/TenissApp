import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisGameBestFiveTest {

    private TennisGame tennisGame;

    @Before
    public void setUp() {

        tennisGame = new TennisGame(new FakePlayGame(), TypeOfTennisMatch.BestOfFive);
    }
    @Test
    public void BestOfFiveGameIsNotOver(){
        addWinningGameForAPlayer(4);
        tennisGame.getCurrentScore();
        addWinningGameForAPlayer(4);
        tennisGame.getCurrentScore();
        Assert.assertEquals(false, tennisGame.IsMatchOver());
    }
    @Test
    public void BestOfFiveGameIsOver(){
        addWinningGameForAPlayer(4);
        tennisGame.getCurrentScore();
        addWinningGameForAPlayer(4);
        tennisGame.getCurrentScore();
        addWinningGameForAPlayer(4);
        tennisGame.getCurrentScore();
        Assert.assertEquals(true, tennisGame.IsMatchOver());
    }

    private void addAnEqualGame(int numberOfEqualGame) {
        for (int i=0; i<numberOfEqualGame; i++){
            addAnEqualGame();
        }
    }
    private void addAnEqualGame() {
        addWinningGameForAPlayer(1);
        addWinningGameForBPlayer(1);
    }

    private void AssertOnePlayerScore(int set, int game, TennisScore ts) {
        Assert.assertEquals(game, ts.game);
        Assert.assertEquals(set, ts.set);
    }

    @Test
    public void GetWinnerName(){
        addWinningGameForAPlayer(4);
        tennisGame.getCurrentScore();
        addWinningGameForAPlayer(4);
        tennisGame.getCurrentScore();
        addWinningGameForAPlayer(4);
        tennisGame.getCurrentScore();
        Assert.assertEquals("A", tennisGame.GetWinner());
    }

    private void addWinningGameForAPlayer(int numberOfWonGame) {
        addWinningGame(numberOfWonGame, "A");
    }

    private void addWinningGameForBPlayer(int numberOfWonGame) {
        addWinningGame(numberOfWonGame, "B");
    }

    private void addWinningGame(int numberOfWonGame, String player) {
        for (int i=0; i<numberOfWonGame; i++) {
            tennisGame.addGame(player);
        }
    }
}