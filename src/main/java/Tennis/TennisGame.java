package Tennis;

public class TennisGame {

    public PairTennisGameScore ptgs;
    private TypeOfTennisMatch tennisMatchType;
    private int [] [] numberOfWonGamesInSets = new int[2][5];
    private int [] numberOfWonSets = new int[2];
    private int currentSetIndex;
    private final static int PLAYER_A_INDEX = 0;
    private final static int PLAYER_B_INDEX = 1;

    private static final int MINIMUM_NUMBER_OF_GAME_TO_WIN_SET = 3;

    public TennisGame(TypeOfTennisMatch totm){
        ptgs = new PairTennisGameScore();
        ptgs.playerAScore = new TennisScore();
        ptgs.playerBScore = new TennisScore();
        tennisMatchType = totm;
        currentSetIndex = 0;
        for (int i=0; i<5; i++)
        {
            numberOfWonGamesInSets[PLAYER_A_INDEX][i]=0;
            numberOfWonGamesInSets[PLAYER_B_INDEX][i]=0;
        }
        numberOfWonSets[PLAYER_A_INDEX]=0;
        numberOfWonSets[PLAYER_B_INDEX]=0;
    }
    public int[][] getNumberOfWonGameInSets(){
        return numberOfWonGamesInSets;
    }

    public PairTennisGameScore getCurrentScore() {
        ptgs.playerAScore = calculateGameScore(PLAYER_A_INDEX);
        ptgs.playerBScore = calculateGameScore(PLAYER_B_INDEX);
        for (int i=0; i<currentSetIndex; i++) {
            if (numberOfWonGamesInSets[PLAYER_A_INDEX][i]>numberOfWonGamesInSets[PLAYER_B_INDEX][i])
                ptgs.playerAScore.set++;
            else
                ptgs.playerBScore.set++;
        }
        return ptgs;
    }

    private TennisScore calculateGameScore(int player) {
        TennisScore tennisScore = new TennisScore();
        if (numberOfWonGamesInSets[player][currentSetIndex] >=3){
            tennisScore.game = 40;
        }
        else if (numberOfWonGamesInSets[player][currentSetIndex] == 2){
            tennisScore.game = 30;
        }
        else if (numberOfWonGamesInSets[player][currentSetIndex] ==1){
            tennisScore.game = 15;
        }
        return tennisScore;
    }

    public void addGame(String player) {
        if (player.equals("A")) {
            numberOfWonGamesInSets[PLAYER_A_INDEX][currentSetIndex]++;
        }
        else if (player.equals("B")) {
            numberOfWonGamesInSets[PLAYER_B_INDEX][currentSetIndex]++;
        }
        else
            throw new InvalidTennisPlayer();
        if (isSomebodyWinTheCurrentSet()) {
            addWonSetToPlayer();
            initNextSet();
        }
    }

    private boolean isSomebodyWinTheCurrentSet() {
        return (numberOfWonGamesInSets[PLAYER_A_INDEX][currentSetIndex] > MINIMUM_NUMBER_OF_GAME_TO_WIN_SET ||
                numberOfWonGamesInSets[PLAYER_B_INDEX][currentSetIndex] > MINIMUM_NUMBER_OF_GAME_TO_WIN_SET ) &&
                Math.abs(numberOfWonGamesInSets[PLAYER_A_INDEX][currentSetIndex] - numberOfWonGamesInSets[PLAYER_B_INDEX][currentSetIndex])>1;
    }
    private void addWonSetToPlayer(){
        if (numberOfWonGamesInSets[PLAYER_A_INDEX][currentSetIndex]> numberOfWonGamesInSets[PLAYER_B_INDEX][currentSetIndex])
            numberOfWonSets[PLAYER_A_INDEX]++;
        else
            numberOfWonSets[PLAYER_B_INDEX]++;
    }
    private void initNextSet() {
        currentSetIndex++;
    }


    public boolean IsMatchOver() {
        if (numberOfWonSets[PLAYER_A_INDEX] > numberOfWonSetsToWinMatch() ||
                numberOfWonSets[PLAYER_B_INDEX] > numberOfWonSetsToWinMatch())
            return true;
        return false;
    }



    public String GetWinner() {
        if (numberOfWonSets[PLAYER_A_INDEX] >= numberOfWonSetsToWinMatch())
            return "A";
        else if (numberOfWonSets[PLAYER_B_INDEX] >= numberOfWonSetsToWinMatch())
            return "B";
        else
            throw new NoWinnerYet();
    }

    private int numberOfWonSetsToWinMatch() {
        return tennisMatchType.maximumSetInGame / 2;
    }
}

