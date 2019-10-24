
import Tennis.TennisMatch;
import Tennis.PlayTennisGame;
import Tennis.TypeOfTennisMatch;
import org.junit.*;

public class TennisMatchSimulatorTest {

    @Test
    public void AfterNewGameScoreZero(){
        TennisMatch tennisMatch = new TennisMatch(TypeOfTennisMatch.BestOfThree);
        PlayTennisGame tennisGame = new PlayTennisGame(new FakePlayTennis());
        while (!tennisMatch.IsMatchOver()) {
            tennisMatch.addGame(tennisGame.getGame());
            tennisMatch.getCurrentScore();
        }
        Assert.assertEquals("A", tennisMatch.GetWinner());
    }
}
