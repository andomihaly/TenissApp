import Tennis.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateTennisScoreTest {

    private CalculateTennisScore calculateTennisScore;


    @Before
    public void setUp() {
        calculateTennisScore = new CalculateTennisScore();
    }
    @Test
    public void AfterNewGameScoreZero(){
        int [][] wonGame = {{0},{0}};
        AssertOnePlayerScore(0, 0, calculateTennisScore.getCurrentScore(wonGame,0).playerAScore);

    }
    @Test
    public void AfterOneGame15point(){
        int [][] wonGame = {{1},{0}};
        AssertOnePlayerScore(0, 15, calculateTennisScore.getCurrentScore(wonGame,0).playerAScore);
    }
    @Test
    public void AfterTwoGame30point(){
        int [][] wonGame = {{2},{0}};
        AssertOnePlayerScore(0, 30, calculateTennisScore.getCurrentScore(wonGame,0).playerAScore);
    }

    @Test
    public void AfterThreeGame40point(){
        int [][] wonGame = {{3},{0}};
        AssertOnePlayerScore(0, 40, calculateTennisScore.getCurrentScore(wonGame,0).playerAScore);
    }

    @Test
    public void EasyWinningSet(){
        int [][] wonGame = {{4,0},{0,0}};
        AssertOnePlayerScore(1, 0, calculateTennisScore.getCurrentScore(wonGame,1).playerAScore);
    }

    @Test
    public void after8GameThereIsNoWinner(){
        int [][] wonGame = {{4,0},{4,0}};
        PairTennisGameScore ptgs= calculateTennisScore.getCurrentScore(wonGame , 0);
        AssertOnePlayerScore(0, 40, ptgs.playerAScore);
        AssertOnePlayerScore(0, 40, ptgs.playerBScore);
    }

    @Test
    public void longSetGame(){
        int [][] wonGame = {{8,0},{7,0}};
        PairTennisGameScore ptgs= calculateTennisScore.getCurrentScore(wonGame , 0);
        AssertOnePlayerScore(0, 40, ptgs.playerAScore);
        AssertOnePlayerScore(0, 40, ptgs.playerBScore);

    }
    @Test
    public void WonSetButNewSetNotStarted(){
        int [][] wonGame = {{5,0},{7,4}};
        PairTennisGameScore ptgs= calculateTennisScore.getCurrentScore(wonGame , 1);
        AssertOnePlayerScore(0, 0, ptgs.playerAScore);
        AssertOnePlayerScore(1, 40, ptgs.playerBScore);
    }
    @Test
    public void WinTwoSet(){
        int [][] wonGame = {{5,0,0},{7,4,0}};
        PairTennisGameScore ptgs= calculateTennisScore.getCurrentScore(wonGame , 2);
        AssertOnePlayerScore(0, 0, ptgs.playerAScore);
        AssertOnePlayerScore(2, 0, ptgs.playerBScore);
    }
    @Test
    public void MaxGame(){
        int [][] wonGame = {{0,4,4,0,0},{4,0,0,4,4}};
        PairTennisGameScore ptgs= calculateTennisScore.getCurrentScore(wonGame , 4);
        AssertOnePlayerScore(2, 0, ptgs.playerAScore);
        AssertOnePlayerScore(2, 40, ptgs.playerBScore);
    }
    private void AssertOnePlayerScore(int set, int game, TennisScore ts) {
        Assert.assertEquals(game, ts.game);
        Assert.assertEquals(set, ts.set);
    }
}