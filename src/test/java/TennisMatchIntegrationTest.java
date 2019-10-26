import Tennis.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisMatchIntegrationTest {

    private TennisMatch tennisMatch;

    @Before
    public void setUp() {
        tennisMatch = new TennisMatch(TypeOfTennisMatch.BestOfThree);
    }

    @Test
    public void FourGameToOneGameWinningSet(){
        addWinningGameForBPlayer(1);
        addWinningGameForAPlayer(1);
        addWinningGameForBPlayer(3);
        AssertOnePlayerScore(0, 0, tennisMatch.getCurrentScore().playerAScore);
        AssertOnePlayerScore(1, 0, tennisMatch.getCurrentScore().playerBScore);
    }

    @Test
    public void after2GameScoreEquals(){
        addAnEqualGame();
        AssertOnePlayerScore(0, 15, tennisMatch.getCurrentScore().playerAScore);
        AssertOnePlayerScore(0, 15, tennisMatch.getCurrentScore().playerBScore);
    }
    @Test
    public void after8GameThereIsNoWinner(){
        addWinningGameForAPlayer(3);
        addWinningGameForBPlayer(4);
        addWinningGameForAPlayer(1);
        AssertOnePlayerScore(0, 40, tennisMatch.getCurrentScore().playerAScore);
        AssertOnePlayerScore(0, 40, tennisMatch.getCurrentScore().playerBScore);
    }
    @Test
    public void longSetGame(){
        addWinningGameForAPlayer(3);
        addWinningGameForBPlayer(4);
        addAnEqualGame(4);
        addWinningGameForBPlayer(1);
        AssertOnePlayerScore(0, 0, tennisMatch.getCurrentScore().playerAScore);
        AssertOnePlayerScore(1, 0, tennisMatch.getCurrentScore().playerBScore);
    }
    @Test
    public void WinTwoSet(){
        addWinningGameForBPlayer(4);
        tennisMatch.getCurrentScore();
        addWinningGameForBPlayer(4);
        AssertOnePlayerScore(2, 0, tennisMatch.getCurrentScore().playerBScore);
        AssertOnePlayerScore(0, 0, tennisMatch.getCurrentScore().playerAScore);
    }
    @Test
    public void BestOfFiveGameLong(){
        addWinningGameForBPlayer(4);
        addWinningGameForAPlayer(4);
        addWinningGameForBPlayer(4);
        PairTennisMatchScore ptgs = tennisMatch.getCurrentScore();
        Assert.assertEquals(0, ptgs.playerAScore.game);
        Assert.assertEquals(1, ptgs.playerAScore.set);
        Assert.assertEquals(0, ptgs.playerBScore.game);
        Assert.assertEquals(2, ptgs.playerBScore.set);
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

    private void AssertOnePlayerScore(int set, int game, PlayerActualScore ts) {
        Assert.assertEquals(game, ts.game);
        Assert.assertEquals(set, ts.set);
    }

    private void addWinningGameForAPlayer(int numberOfWonGame) {
        addWinningGame(numberOfWonGame, TennisPlayer.PlayerA);
    }

    private void addWinningGameForBPlayer(int numberOfWonGame) {
        addWinningGame(numberOfWonGame, TennisPlayer.PlayerB);
    }

    private void addWinningGame(int numberOfWonGame, TennisPlayer player) {
        for (int i=0; i<numberOfWonGame; i++) {
            tennisMatch.addGame(player);
        }
    }
}