import Tennis.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisGameIntegrationTest {

    private TennisGame tennisGame;

    @Before
    public void setUp() {
        tennisGame = new TennisGame(TypeOfTennisMatch.BestOfThree);
    }

    @Test
    public void FourGameToOneGameWinningSet(){
        addWinningGameForBPlayer(1);
        addWinningGameForAPlayer(1);
        addWinningGameForBPlayer(3);
        AssertOnePlayerScore(0, 0, tennisGame.getCurrentScore().playerAScore);
        AssertOnePlayerScore(1, 0, tennisGame.getCurrentScore().playerBScore);
    }

    @Test
    public void after2GameScoreEquals(){
        addAnEqualGame();
        AssertOnePlayerScore(0, 15, tennisGame.getCurrentScore().playerAScore);
        AssertOnePlayerScore(0, 15, tennisGame.getCurrentScore().playerBScore);
    }
    @Test
    public void after8GameThereIsNoWinner(){
        addWinningGameForAPlayer(3);
        addWinningGameForBPlayer(4);
        addWinningGameForAPlayer(1);
        AssertOnePlayerScore(0, 40, tennisGame.getCurrentScore().playerAScore);
        AssertOnePlayerScore(0, 40, tennisGame.getCurrentScore().playerBScore);
    }
    @Test
    public void longSetGame(){
        addWinningGameForAPlayer(3);
        addWinningGameForBPlayer(4);
        addAnEqualGame(4);
        addWinningGameForBPlayer(1);
        AssertOnePlayerScore(0, 0, tennisGame.getCurrentScore().playerAScore);
        AssertOnePlayerScore(1, 0, tennisGame.getCurrentScore().playerBScore);
    }
    @Test
    public void WinTwoSet(){
        addWinningGameForBPlayer(4);
        tennisGame.getCurrentScore();
        addWinningGameForBPlayer(4);
        AssertOnePlayerScore(2, 0, tennisGame.getCurrentScore().playerBScore);
        AssertOnePlayerScore(0, 0, tennisGame.getCurrentScore().playerAScore);
    }
    @Test
    public void BestOfFiveGameLong(){
        addWinningGameForBPlayer(4);
        addWinningGameForAPlayer(4);
        addWinningGameForBPlayer(4);
        PairTennisGameScore ptgs = tennisGame.getCurrentScore();
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

    private void AssertOnePlayerScore(int set, int game, TennisScore ts) {
        Assert.assertEquals(game, ts.game);
        Assert.assertEquals(set, ts.set);
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