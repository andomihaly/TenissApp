class TennisGame {

    private PairTennisGameScore ptgs;
    private TypeOfTennisMatch tennisMatchType;
    private PlayGame actualGame;
    private static final int MINIMUM_NUMBER_OF_GAME_TO_WIN_SET = 3;

    TennisGame(PlayGame realGame, TypeOfTennisMatch totm){
        ptgs = new PairTennisGameScore();
        ptgs.playerAScore = new TennisScore();
        ptgs.playerBScore = new TennisScore();
        actualGame = realGame;
        tennisMatchType = totm;
    }

    void addGame(String player) {
        if (player.equals("A"))
            ptgs.playerAScore.numberOfWonGame++;
        else if (player.equals("B"))
            ptgs.playerBScore.numberOfWonGame++;
        else
            throw new InvalidTennisPlayer();
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
        if (ptgs.playerAScore.numberOfWonGame > ptgs.playerBScore.numberOfWonGame)
            setWinnerSetScore(ptgs.playerAScore);
        else
            setWinnerSetScore(ptgs.playerBScore);
        ptgs.playerAScore.numberOfWonGame = 0;
        ptgs.playerBScore.numberOfWonGame = 0;
    }

    private void setWinnerSetScore(TennisScore player) {
        player.set++;
        player.game = 0;
    }

    public boolean IsMatchOver() {
        if (ptgs.playerAScore.set > tennisMatchType.maximumSetInGame/2 ||
                ptgs.playerBScore.set > tennisMatchType.maximumSetInGame/2)
            return true;
        return false;
    }

    public String getGame() {
        return actualGame.GetWhoWonTheGame();
    }

    public String GetWinner() {
        if (ptgs.playerAScore.set >= tennisMatchType.maximumSetInGame/2 )
            return "A";
        else if (ptgs.playerBScore.set >= tennisMatchType.maximumSetInGame/2 )
            return "B";
        else
            throw new NoWinnerYet();
    }
}

