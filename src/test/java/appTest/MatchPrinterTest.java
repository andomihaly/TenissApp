package appTest;

import app.UserInterface.MatchPrinter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatchPrinterTest {

    @Test
    public void displayActualScoreHeader() {
        MatchPrinter mp = new MatchPrinter();
        Assert.assertEquals("Game is over. Misi won the tennis match.", mp.displayActualScoreHeader("Misi"));
    }
}