
import org.junit.*;

public class TennisMatchSimulatorTest {

    private TennisGame tennisGame;

    @Test
    public void AfterNewGameScoreZero(){
        tennisGame = new TennisGame(TypeOfTennisMatch.BestOfThree);
        TennisMatch tm = new TennisMatch(new FakePlayGame());
        while (!tennisGame.IsMatchOver()) {
            tennisGame.addGame(tm.getGame());
            tennisGame.getCurrentScore();
        }
        Assert.assertEquals("A", tennisGame.GetWinner());
    }
}
