package Tennis;

public class CalculateTennisScore {
    private PairTennisGameScore ptgs;
    private int [][] wonSetsGames;
    private int actualSetIndex;

    public PairTennisGameScore getCurrentScore(int [] [] wonGames, int actualSetIndex) {
        ptgs = new PairTennisGameScore();
        wonSetsGames = wonGames;
        this.actualSetIndex = actualSetIndex;

        calculateSetAndGameScores();

        return ptgs;
    }

    private void calculateSetAndGameScores() {
        if (isMatchOver())
            SetGameScoreAfterMatchIsEnd();
        else
            calculatePlayersActualSetScores();
        setPlayersWonSets();
    }

    private boolean isMatchOver() {
        return actualSetIndex==wonSetsGames[0].length;
    }

    private void calculatePlayersActualSetScores() {
        ptgs.playerAScore = calculateGameScore(0, wonSetsGames[0][actualSetIndex]);
        ptgs.playerBScore = calculateGameScore(1, wonSetsGames[1][actualSetIndex]);
    }

    private void SetGameScoreAfterMatchIsEnd() {
        ptgs.playerAScore = new TennisScore();
        ptgs.playerBScore = new TennisScore();
    }

    private void setPlayersWonSets() {
        for (int i = 0; i < actualSetIndex; i++) {
            if (wonSetsGames[0][i] > wonSetsGames[1][i])
                ptgs.playerAScore.set++;
            else
                ptgs.playerBScore.set++;
        }
    }

    private TennisScore calculateGameScore(int player, int wonGameInSet) {
        TennisScore tennisScore = new TennisScore();
        if (wonGameInSet >=3){
            tennisScore.game = 40;
        }
        else if (wonGameInSet == 2){
            tennisScore.game = 30;
        }
        else if (wonGameInSet ==1){
            tennisScore.game = 15;
        }
        return tennisScore;
    }

}
