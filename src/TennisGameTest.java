
import org.junit.*;

public class TennisGameTest {

    private TennisGame tennisGame;

    @org.junit.Before
    public void setUp() {
        tennisGame = new TennisGame();
    }
    @Test
    public void AfterNewGameScoreZero(){
        TennisGame tg = new TennisGame();
        AssertOnePlayerScore(0, 0, tennisGame.getCurrentScore().playerAScore);

    }
    @Test
    public void AfterOneGame15point(){
        addWinningGameForAPlayer(1);
        AssertOnePlayerScore(0, 15, tennisGame.getCurrentScore().playerAScore);
    }
    @Test
    public void AfterTwoGame30point(){
        addWinningGameForAPlayer(2);
        AssertOnePlayerScore(0, 30, tennisGame.getCurrentScore().playerAScore);
    }

    @Test
    public void AfterThreeGame40point(){
        addWinningGameForAPlayer(3);
        AssertOnePlayerScore(0, 40, tennisGame.getCurrentScore().playerAScore);
    }

    @Test
    public void EasyWinningSet(){
        addWinningGameForAPlayer(4);
        AssertOnePlayerScore(1, 0, tennisGame.getCurrentScore().playerAScore);
    }
    @Test
    public void FourGameToOneGameWinningSet(){
        addWinningGameForBPlayer(1);
        addWinningGameForAPlayer(1);
        addWinningGameForBPlayer(3);
        AssertOnePlayerScore(0, 15, tennisGame.getCurrentScore().playerAScore);
        AssertOnePlayerScore(1, 0, tennisGame.getCurrentScore().playerBScore);
    }

    @Test
    public void after2GameScoreEquals(){
        addWinningGameForAPlayer(1);
        addWinningGameForBPlayer(1);
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