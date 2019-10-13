class TennisGame {

    private PairTennisGameScore ptgs;
    private static final int MINIMUM_NUMBER_OF_GAME_TO_WIN_SET = 3;

    TennisGame(){
        ptgs = new PairTennisGameScore();
        ptgs.playerAScore = new TennisScore();
        ptgs.playerBScore = new TennisScore();
    }

    void addGame(String player) {
        if (player.equals("A"))
            ptgs.playerAScore.numberOfWonGame++;
        else if (player.equals("B"))
            ptgs.playerBScore.numberOfWonGame++;
    }

    PairTennisGameScore getCurrentScore() {

        calculateGameScore(ptgs.playerAScore);
        calculateGameScore(ptgs.playerBScore);
        if (isSomebodyWinTheCurrentSet())
        {
            setWinningScores();
        }

        return ptgs;
    }

    private void calculateGameScore(TennisScore tennisScore) {
        if (tennisScore.numberOfWonGame >=3){
            tennisScore.game = 40;
        }
        else if (tennisScore.numberOfWonGame ==2){
            tennisScore.game = 30;
        }
        else if (tennisScore.numberOfWonGame ==1){
            tennisScore.game = 15;
        }
    }

    private boolean isSomebodyWinTheCurrentSet() {
        return (ptgs.playerAScore.numberOfWonGame > MINIMUM_NUMBER_OF_GAME_TO_WIN_SET ||
                                    ptgs.playerBScore.numberOfWonGame > MINIMUM_NUMBER_OF_GAME_TO_WIN_SET)
                && Math.abs(ptgs.playerAScore.numberOfWonGame -ptgs.playerBScore.numberOfWonGame)>1;
    }

    private void setWinningScores() {
        if (ptgs.playerAScore.numberOfWonGame > MINIMUM_NUMBER_OF_GAME_TO_WIN_SET){
            setWinnerSetScore(ptgs.playerAScore);
        }
        if (ptgs.playerBScore.numberOfWonGame > MINIMUM_NUMBER_OF_GAME_TO_WIN_SET){
            setWinnerSetScore(ptgs.playerBScore);
        }
    }

    private void setWinnerSetScore(TennisScore player) {
        player.set = 1;
        player.game = 0;
    }

}
