package app.Starter;

import app.Tennis.PairTennisMatchScore;
import app.Tennis.TennisMatch;
import app.UserInterface.ScorePrinter;
import app.Tennis.PlayTennisGame;
import app.Tennis.TypeOfTennisMatch;
import app.UserInterface.MatchPrinter;

public class TennisMatchGUI {
    public void playOneMatch() {
        System.out.println("Play A tennis game");
        TennisMatch tennisGame = new TennisMatch(TypeOfTennisMatch.BestOfFive);
        ScorePrinter sp = new ScorePrinter();
        System.out.printf("GameNo. ");
        System.out.printf(sp.displayActualScoreHeader());
        System.out.printf("%n");
        int numberOfGame = 0;
        PlayTennisGame tm = new PlayTennisGame(new PlayTennisSimulator());
        while (!tennisGame.isMatchOver()) {
            tennisGame.addGame(tm.getGame());
            PairTennisMatchScore ptgs = tennisGame.getCurrentScore();
            System.out.printf("  %-3s   ", numberOfGame++);
            System.out.printf(sp.displayActualScore(ptgs));
            System.out.printf("%n");
        }
        MatchPrinter pm = new MatchPrinter();
        System.out.printf(pm.displayActualScoreHeader(tennisGame.getWinner().toString()));
        System.out.printf(" The match contains %d games. %n", numberOfGame - 1);
    }
}
