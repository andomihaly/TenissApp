package Tennis;

public class CalculateTennisScore {
    public PairTennisGameScore ptgs;

    public PairTennisGameScore getCurrentScore(int [] [] wonGames, int actualSetIndex) {
        ptgs = new PairTennisGameScore();
        ptgs.playerAScore = calculateGameScore(0, wonGames[0][actualSetIndex]);
        ptgs.playerBScore = calculateGameScore(1, wonGames[1][actualSetIndex]);
        setPlayersWonSets(wonGames, actualSetIndex);
        return ptgs;
    }

    private void setPlayersWonSets(int[][] wonGames, int actualSetIndex) {
        for (int i = 0; i < actualSetIndex; i++) {
            if (wonGames[0][i] > wonGames[1][i])
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
