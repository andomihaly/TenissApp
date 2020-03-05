package appTest;

import app.Tennis.PlayTennisGame;
import app.Tennis.TennisMatch;
import app.Tennis.TennisPlayer;
import app.Tennis.TypeOfTennisMatch;
import org.junit.Assert;
import org.junit.Test;

public class TennisMatchSimulatorTest {

    @Test
    public void AfterNewGameScoreZero() {
        TennisMatch tennisMatch = new TennisMatch(TypeOfTennisMatch.BestOfThree);
        PlayTennisGame tennisGame = new PlayTennisGame(new FakePlayTennis());
        while (!tennisMatch.isMatchOver()) {
            tennisMatch.addGame(tennisGame.getGame());
            tennisMatch.getCurrentScore();
        }
        Assert.assertEquals(TennisPlayer.PlayerA, tennisMatch.getWinner());
    }
}
