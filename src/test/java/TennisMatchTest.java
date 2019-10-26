
import Tennis.*;
import org.junit.*;

public class TennisMatchTest {

    private TennisMatch tennisMatch;

    @org.junit.Before
    public void setUp() {
        tennisMatch = new TennisMatch(TypeOfTennisMatch.BestOfThree);
    }

    @Test
    public void afterInitNoWonGame(){
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[1][0]);
    }
    @Test
    public void storeGameWinsAfterSeveralGame(){
        addWinningGameForAPlayer(1);
        Assert.assertEquals(1, tennisMatch.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[1][0]);
        addWinningGameForBPlayer(1);
        Assert.assertEquals(1, tennisMatch.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(1, tennisMatch.getNumberOfWonGameInSets()[1][0]);
        addWinningGameForAPlayer(3);
        Assert.assertEquals(4, tennisMatch.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(1, tennisMatch.getNumberOfWonGameInSets()[1][0]);
        addWinningGameForAPlayer(1);
        Assert.assertEquals(4, tennisMatch.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(1, tennisMatch.getNumberOfWonGameInSets()[0][1]);
        Assert.assertEquals(1, tennisMatch.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[1][1]);
    }
    @Test
    public void FourGameToOneGameWinningSet(){
        addWinningGameForBPlayer(1);
        addWinningGameForAPlayer(1);
        addWinningGameForBPlayer(3);
        Assert.assertEquals(1, tennisMatch.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(4, tennisMatch.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[0][1]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[1][1]);
    }
    @Test
    public void BestFiveGame(){
        addWinningGameForBPlayer(4);
        addWinningGameForAPlayer(4);
        addWinningGameForBPlayer(4);
        addEqualGames(5);
        addWinningGameForAPlayer(2);
        addWinningGameForBPlayer(4);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(4, tennisMatch.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(4, tennisMatch.getNumberOfWonGameInSets()[0][1]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[1][1]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[0][2]);
        Assert.assertEquals(4, tennisMatch.getNumberOfWonGameInSets()[1][2]);
        Assert.assertEquals(7, tennisMatch.getNumberOfWonGameInSets()[0][3]);
        Assert.assertEquals(5, tennisMatch.getNumberOfWonGameInSets()[1][3]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[0][4]);
        Assert.assertEquals(4, tennisMatch.getNumberOfWonGameInSets()[1][4]);
    }

    @Test
    public void after8GameThereIsNoWinner(){
        addWinningGameForAPlayer(3);
        addWinningGameForBPlayer(4);
        addWinningGameForAPlayer(1);
        Assert.assertEquals(4, tennisMatch.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(4, tennisMatch.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[0][1]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[1][1]);
    }
    @Test
    public void longSetGame(){
        addWinningGameForAPlayer(3);
        addWinningGameForBPlayer(4);
        addEqualGames(4);
        addWinningGameForBPlayer(1);
        Assert.assertEquals(7, tennisMatch.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(9, tennisMatch.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[0][1]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[1][1]);
    }

    @Test
    public void WinTwoSet(){
        addWinningGameForBPlayer(4);
        tennisMatch.getCurrentScore();
        addWinningGameForBPlayer(4);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(4, tennisMatch.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[0][1]);
        Assert.assertEquals(4, tennisMatch.getNumberOfWonGameInSets()[1][1]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[0][2]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[1][2]);
    }
    @Test
    public void WinLongTwoSet(){
        addWinningGameForBPlayer(4);
        addWinningGameForBPlayer(1);
        addEqualGames(7);
        addWinningGameForBPlayer(1);
        Assert.assertEquals(4, tennisMatch.getNumberOfWonGameInSets()[1][0]);
        Assert.assertEquals(9, tennisMatch.getNumberOfWonGameInSets()[1][1]);
        Assert.assertEquals(0, tennisMatch.getNumberOfWonGameInSets()[0][0]);
        Assert.assertEquals(7, tennisMatch.getNumberOfWonGameInSets()[0][1]);
    }

    @Test
    public void GameIsNotOverYet(){
        Assert.assertFalse(tennisMatch.IsMatchOver());
        addWinningGameForBPlayer(4);
        Assert.assertFalse(tennisMatch.IsMatchOver());
    }

    @Test
    public void BestOfThreeGameIsOver(){
        addWinningGameForAPlayer(4);
        tennisMatch.getCurrentScore();
        addWinningGameForAPlayer(4);
        tennisMatch.getCurrentScore();
        Assert.assertTrue(tennisMatch.IsMatchOver());
    }


    @Test
    public void GetWinnerName(){
        addWinningGameForAPlayer(4);
        addWinningGameForAPlayer(4);
        Assert.assertEquals(TennisPlayer.PlayerA, tennisMatch.GetWinner());
    }
    @Test
    public void GetBWinnerName(){
        addWinningGameForBPlayer(4);
        addWinningGameForBPlayer(4);
        Assert.assertEquals(TennisPlayer.PlayerB, tennisMatch.GetWinner());
    }
    @Test(expected = NoWinnerYet.class)
    public void noWinnerYet(){
        tennisMatch.GetWinner();
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