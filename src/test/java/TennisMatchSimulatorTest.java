
import org.junit.*;

public class TennisMatchSimulatorTest {

    private TennisGame tennisGame;

    @Test
    public void AfterNewGameScoreZero(){
        tennisGame = new TennisGame(new FakePlayGame(), TypeOfTennisMatch.BestOfThree);
        while (!tennisGame.IsMatchOver()) {
            tennisGame.addGame(tennisGame.getGame());
            tennisGame.getCurrentScore();
        }
        Assert.assertEquals("A", tennisGame.GetWinner());
    }
}
