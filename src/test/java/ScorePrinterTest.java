import Tennis.*;
import UserInterface.ScorePrinter;
import org.junit.Assert;
import org.junit.Test;

public class ScorePrinterTest {

    private PairTennisMatchScore pairTennisMatchScore;
    private ScorePrinter scorePrinter;
    @org.junit.Before
    public void setUp() {
        pairTennisMatchScore = new PairTennisMatchScore();
        pairTennisMatchScore.playerAScore = new PlayerActualScore();
        pairTennisMatchScore.playerBScore = new PlayerActualScore();
        scorePrinter = new ScorePrinter();
    }

    @Test
    public void GetActualScoreHeader()
    {
        String outText="| A Set | B Set | A Game | B Game |";
        Assert.assertEquals(outText, scorePrinter.displayActualScoreHeader());
    }
    @Test
    public void GetActualScoreWithSingleDigitNumber(){
        String outText = "|   0   |   0   |   0    |   0    |";
        Assert.assertEquals(outText, scorePrinter.displayActualScore(pairTennisMatchScore));
    }
    @Test
    public void GetActualScoreWithDoubleDigitNumber(){
        pairTennisMatchScore.playerAScore.set = 1;
        pairTennisMatchScore.playerAScore.game = 15;
        pairTennisMatchScore.playerBScore.set=2;
        pairTennisMatchScore.playerBScore.game=40;
        String outText = "|   1   |   2   |   15   |   40   |";
        Assert.assertEquals(outText, scorePrinter.displayActualScore(pairTennisMatchScore));
    }
}
