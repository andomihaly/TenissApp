package app.UserInterface;

import app.Tennis.PairTennisMatchScore;

public class ScorePrinter {
    public String displayActualScoreHeader() {
        return "| A Set | B Set | A Game | B Game |";
    }

    public String displayActualScore(PairTennisMatchScore ptms) {
        String out = "";
        out = String.format("|   %d   |   %d   |", ptms.playerAScore.set, ptms.playerBScore.set);
        out += String.format("   %-5d|   %-5d|", ptms.playerAScore.game, ptms.playerBScore.game);
        return out;
    }
}
