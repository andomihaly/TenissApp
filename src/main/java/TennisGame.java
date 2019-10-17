class TennisGame {

    private PairTennisGameScore ptgs;
    private TypeOfTennisMatch tennisMatchType;

    private static final int MINIMUM_NUMBER_OF_GAME_TO_WIN_SET = 3;

    TennisGame(TypeOfTennisMatch totm){
        ptgs = new PairTennisGameScore();
        ptgs.playerAScore = new TennisScore();
        ptgs.playerBScore = new TennisScore();
        tennisMatchType = totm;
    }

    void addGame(String player) {
        if (player.equals("A"))
            ptgs.playerAScore.numberOfWonGame++;
        else if (player.equals("B"))
            ptgs.playerBScore.numberOfWonGame++;
        else
            throw new InvalidTennisPlayer();
        if (isSomebodyWinTheCurrentSet()) {
            setSetScore();
            prepareNewSet();
        }
    }

    PairTennisGameScore getCurrentScore() {
        calculateGameScore(ptgs.playerAScore);
        calculateGameScore(ptgs.playerBScore);
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

    private void setSetScore() {
        if (ptgs.playerAScore.numberOfWonGame > ptgs.playerBScore.numberOfWonGame)
            setWinnerSetScore(ptgs.playerAScore);
        else
            setWinnerSetScore(ptgs.playerBScore);
    }
    private void prepareNewSet(){
        ptgs.playerAScore.numberOfWonGame = 0;
        ptgs.playerBScore.numberOfWonGame = 0;
    }

    private void setWinnerSetScore(TennisScore player) {
        player.set++;
        player.game = 0;
    }

    public boolean IsMatchOver() {
        if (ptgs.playerAScore.set > numberOfWonSetsToWinMatch() ||
                ptgs.playerBScore.set > numberOfWonSetsToWinMatch())
            return true;
        return false;
    }



    public String GetWinner() {
        if (ptgs.playerAScore.set >= numberOfWonSetsToWinMatch())
            return "A";
        else if (ptgs.playerBScore.set >= numberOfWonSetsToWinMatch())
            return "B";
        else
            throw new NoWinnerYet();
    }

    private int numberOfWonSetsToWinMatch() {
        return tennisMatchType.maximumSetInGame / 2;
    }
}

