package Tennis;

public class CalculateTennisScore {
    private PairTennisMatchScore ptgs;
    private int [][] wonSetsGames;
    private int actualSetIndex;

    public PairTennisMatchScore getCurrentScore(int [] [] wonGames, int actualSetIndex) {
        ptgs = new PairTennisMatchScore();
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
        ptgs.playerAScore = new PlayerActualScore();
        ptgs.playerBScore = new PlayerActualScore();
    }

    private void setPlayersWonSets() {
        for (int i = 0; i < actualSetIndex; i++) {
            if (wonSetsGames[0][i] > wonSetsGames[1][i])
                ptgs.playerAScore.set++;
            else
                ptgs.playerBScore.set++;
        }
    }

    private PlayerActualScore calculateGameScore(int player, int wonGameInSet) {
        PlayerActualScore actualGameScore = new PlayerActualScore();
        if (wonGameInSet >=3){
            actualGameScore.game = 40;
        }
        else if (wonGameInSet == 2){
            actualGameScore.game = 30;
        }
        else if (wonGameInSet ==1){
            actualGameScore.game = 15;
        }
        return actualGameScore;
    }

}
