package Tennis;

public class TennisMatch {


    private TypeOfTennisMatch tennisMatchType;
    private int [] [] numberOfWonGamesInSets = new int[2][5];
    private int [] numberOfWonSets = new int[2];
    private int currentSetIndex;
    private final static int PLAYER_A_INDEX = 0;
    private final static int PLAYER_B_INDEX = 1;

    private static final int MINIMUM_NUMBER_OF_GAME_TO_WIN_SET = 3;

    public TennisMatch(TypeOfTennisMatch totm){
        tennisMatchType = totm;

        initNewTennisMatch();
    }

    private void initNewTennisMatch() {
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

    public PairTennisMatchScore getCurrentScore() {
        CalculateTennisScore cts = new CalculateTennisScore();
        return  cts.getCurrentScore(numberOfWonGamesInSets, currentSetIndex);
    }

    public void addGame(TennisPlayer player) {
        if (player.equals(TennisPlayer.PlayerA)) {
            numberOfWonGamesInSets[PLAYER_A_INDEX][currentSetIndex]++;
        }
        else if (player.equals(TennisPlayer.PlayerB)) {
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



    public TennisPlayer GetWinner() {
        if (numberOfWonSets[PLAYER_A_INDEX] >= numberOfWonSetsToWinMatch())
            return TennisPlayer.PlayerA;
        else if (numberOfWonSets[PLAYER_B_INDEX] >= numberOfWonSetsToWinMatch())
            return TennisPlayer.PlayerB;
        else
            throw new NoWinnerYet();
    }

    private int numberOfWonSetsToWinMatch() {
        return tennisMatchType.maximumSetInGame / 2;
    }
}

