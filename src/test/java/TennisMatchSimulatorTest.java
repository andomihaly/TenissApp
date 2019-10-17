
import Tennis.TennisGame;
import Tennis.TennisMatch;
import Tennis.TypeOfTennisMatch;
import org.junit.*;

public class TennisMatchSimulatorTest {

    @Test
    public void AfterNewGameScoreZero(){
        TennisGame tennisGame = new TennisGame(TypeOfTennisMatch.BestOfThree);
        TennisMatch tm = new TennisMatch(new FakePlayGame());
        while (!tennisGame.IsMatchOver()) {
            tennisGame.addGame(tm.getGame());
            tennisGame.getCurrentScore();
        }
        Assert.assertEquals("A", tennisGame.GetWinner());
    }
}
