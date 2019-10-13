
import org.junit.*;

public class TennisMatchSimulatorTest {

    private TennisGame tennisGame;

    @Test
    public void AfterNewGameScoreZero(){
        tennisGame = new TennisGame(new TennisGameTest.FakePlayGame());
        while (!tennisGame.IsMatchOver(TypeOfTennisMatch.BestOfThree)) {
            tennisGame.addGame(tennisGame.getGame());
            tennisGame.getCurrentScore();
        }
        Assert.assertEquals("A", tennisGame.GetWinner(2));
    }
}
