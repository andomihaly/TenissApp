import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayAGameTest {
    @Test
    public void CharacterisationTest1(){
        String result=
                "Play A tennis game\r\n"+
                "A Set  | B Set  | A Game | B Game |\r\n"+
                "   0   |    0   |  0     |  15    |\r\n" +
                "   0   |    0   |  15    |  15    |\r\n" +
                "   0   |    0   |  30    |  15    |\r\n" +
                "   0   |    0   |  40    |  15    |\r\n" +
                "   1   |    0   |  0     |  0     |\r\n" +
                "   1   |    0   |  0     |  15    |\r\n" +
                "   1   |    0   |  0     |  30    |\r\n" +
                "   1   |    0   |  0     |  40    |\r\n" +
                "   1   |    1   |  0     |  0     |\r\n" +
                "   1   |    1   |  15    |  0     |\r\n" +
                "   1   |    1   |  30    |  0     |\r\n" +
                "   1   |    1   |  40    |  0     |\r\n" +
                "   1   |    1   |  40    |  15    |\r\n" +
                "   2   |    1   |  0     |  0     |\r\n"+
                "Game is over A player is win the tennis match.\r\n";
        String [] input = {"B","A","A","A","A",
                            "B","B","B","B",
                            "A","A","A","B","A"};
        PlayGameKnownMatch pgkm = new PlayGameKnownMatch(input);
        TennisGame tennisGame = new TennisGame(pgkm);
        Assert.assertEquals(result, PlayAGame.PLAY(tennisGame));
    }
    @Test
    public void CharacterisationTest2(){
        String result=
                "Play A tennis game\r\n"+
                "A Set  | B Set  | A Game | B Game |\r\n" +
                "   0   |    0   |  15    |  0     |\r\n" +
                "   0   |    0   |  30    |  0     |\r\n" +
                "   0   |    0   |  30    |  15    |\r\n" +
                "   0   |    0   |  40    |  15    |\r\n" +
                "   1   |    0   |  0     |  0     |\r\n" +
                "   1   |    0   |  15    |  0     |\r\n" +
                "   1   |    0   |  30    |  0     |\r\n" +
                "   1   |    0   |  30    |  15    |\r\n" +
                "   1   |    0   |  30    |  30    |\r\n" +
                "   1   |    0   |  30    |  40    |\r\n" +
                "   1   |    0   |  40    |  40    |\r\n" +
                "   1   |    0   |  40    |  40    |\r\n" +
                "   1   |    0   |  40    |  40    |\r\n" +
                "   1   |    0   |  40    |  40    |\r\n" +
                "   2   |    0   |  0     |  0     |\r\n" +
                "Game is over A player is win the tennis match.\r\n";
        String [] input = {"A","A","B","A","A",
                            "A","A","B","B","B","A","B","A","A","A"};
        PlayGameKnownMatch pgkm = new PlayGameKnownMatch(input);
        TennisGame tennisGame = new TennisGame(pgkm);
        Assert.assertEquals(result, PlayAGame.PLAY(tennisGame));
    }

    private static class PlayGameKnownMatch implements PlayGame {
        String [] gamesWon;
        int actualGame;
        public PlayGameKnownMatch(String [] wons){
            gamesWon = wons;
            actualGame = 0;
        }
        @Override
        public String GetWhoWonTheGame() {
            return gamesWon[actualGame++];
        }
    }
}