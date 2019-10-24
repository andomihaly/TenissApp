
import Tennis.*;
import org.junit.*;

public class TennisGameTest {

    private TennisGame tennisGame;

    @org.junit.Before
    public void setUp() {
        tennisGame = new TennisGame(TypeOfTennisMatch.BestOfThree);
    }

    @Test
    public void afterInitNoWonGame(){
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[1][0]);
    }
    @Test
    public void storeGameWinsAfterSeveralGame(){
        addWinningGameForAPlayer(1);
        Assert.assertEquals(1, tennisGame.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[1][0]);
        addWinningGameForBPlayer(1);
        Assert.assertEquals(1, tennisGame.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(1, tennisGame.getNumberOfWonGameInSets()[1][0]);
        addWinningGameForAPlayer(3);
        Assert.assertEquals(4, tennisGame.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(1, tennisGame.getNumberOfWonGameInSets()[1][0]);
        addWinningGameForAPlayer(1);
        Assert.assertEquals(4, tennisGame.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(1, tennisGame.getNumberOfWonGameInSets()[0][1]);
        Assert.assertEquals(1, tennisGame.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[1][1]);
    }
    @Test
    public void FourGameToOneGameWinningSet(){
        addWinningGameForBPlayer(1);
        addWinningGameForAPlayer(1);
        addWinningGameForBPlayer(3);
        Assert.assertEquals(1, tennisGame.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(4, tennisGame.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[0][1]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[1][1]);
    }
    @Test
    public void BestFiveGame(){
        addWinningGameForBPlayer(4);
        addWinningGameForAPlayer(4);
        addWinningGameForBPlayer(4);
        addEqualGames(5);
        addWinningGameForAPlayer(2);
        addWinningGameForBPlayer(4);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(4, tennisGame.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(4, tennisGame.getNumberOfWonGameInSets()[0][1]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[1][1]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[0][2]);
        Assert.assertEquals(4, tennisGame.getNumberOfWonGameInSets()[1][2]);
        Assert.assertEquals(7, tennisGame.getNumberOfWonGameInSets()[0][3]);
        Assert.assertEquals(5, tennisGame.getNumberOfWonGameInSets()[1][3]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[0][4]);
        Assert.assertEquals(4, tennisGame.getNumberOfWonGameInSets()[1][4]);
    }

    @Test
    public void after8GameThereIsNoWinner(){
        addWinningGameForAPlayer(3);
        addWinningGameForBPlayer(4);
        addWinningGameForAPlayer(1);
        Assert.assertEquals(4, tennisGame.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(4, tennisGame.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[0][1]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[1][1]);
    }
    @Test
    public void longSetGame(){
        addWinningGameForAPlayer(3);
        addWinningGameForBPlayer(4);
        addEqualGames(4);
        addWinningGameForBPlayer(1);
        Assert.assertEquals(7, tennisGame.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(9, tennisGame.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[0][1]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[1][1]);
    }
    @Test(expected = InvalidTennisPlayer.class)
    public void invalidPlayerGetGame(){
        tennisGame.addGame("X");
    }

    @Test
    public void WinTwoSet(){
        addWinningGameForBPlayer(4);
        tennisGame.getCurrentScore();
        addWinningGameForBPlayer(4);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(4, tennisGame.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[0][1]);
        Assert.assertEquals(4, tennisGame.getNumberOfWonGameInSets()[1][1]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[0][2]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[1][2]);
    }
    @Test
    public void WinLongTwoSet(){
        addWinningGameForBPlayer(4);
        addWinningGameForBPlayer(1);
        addEqualGames(7);
        addWinningGameForBPlayer(1);
        Assert.assertEquals(4, tennisGame.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(9, tennisGame.getNumberOfWonGameInSets()[1][1]);
        Assert.assertEquals(0, tennisGame.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(7, tennisGame.getNumberOfWonGameInSets()[0][1]);
    }

    @Test
    public void GameIsNotOverYet(){
        Assert.assertFalse(tennisGame.IsMatchOver());
        addWinningGameForBPlayer(4);
        Assert.assertFalse(tennisGame.IsMatchOver());
    }

    @Test
    public void BestOfThreeGameIsOver(){
        addWinningGameForAPlayer(4);
        tennisGame.getCurrentScore();
        addWinningGameForAPlayer(4);
        tennisGame.getCurrentScore();
        Assert.assertTrue(tennisGame.IsMatchOver());
    }


    @Test
    public void GetWinnerName(){
        addWinningGameForAPlayer(4);
        addWinningGameForAPlayer(4);
        Assert.assertEquals("A", tennisGame.GetWinner());
    }
    @Test
    public void GetBWinnerName(){
        addWinningGameForBPlayer(4);
        addWinningGameForBPlayer(4);
        Assert.assertEquals("B", tennisGame.GetWinner());
    }
    @Test(expected = NoWinnerYet.class)
    public void noWinnerYet(){
        tennisGame.GetWinner();
    }

    private void addEqualGames(int numberOfEqualGame) {
        for (int i=0; i<numberOfEqualGame; i++){
            addAnEqualGame();
        }
    }
    private void addAnEqualGame() {
        addWinningGameForAPlayer(1);
        addWinningGameForBPlayer(1);
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