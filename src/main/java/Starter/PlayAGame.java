package Starter;

import Tennis.*;
import UserInterface.ScorePrinter;

public class PlayAGame {
    public static void main(String [] args)
    {
        System.out.println("Play A tennis game");
        TennisMatch tennisGame = new TennisMatch(TypeOfTennisMatch.BestOfFive);
        ScorePrinter sp = new ScorePrinter();
        System.out.printf("GameNo. ");
        System.out.printf(sp.displayActualScoreHeader());
        System.out.printf("%n");
        int numberOfGame=0;
        PlayTennisGame tm = new PlayTennisGame(new PlayTennisSimulator());
        while (!tennisGame.isMatchOver()) {
            tennisGame.addGame(tm.getGame());
            PairTennisMatchScore ptgs = tennisGame.getCurrentScore();
            System.out.printf("  %-3s   ", numberOfGame++);
            System.out.printf(sp.displayActualScore(ptgs));
            System.out.printf("%n");
        }
        System.out.printf("Game is over %s player is win the tennis match after %d games. %n", tennisGame.getWinner(),numberOfGame);
    }
}
