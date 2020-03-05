package app.Tennis;

public class TennisMatch {

    private TypeOfTennisMatch tennisMatchType;
    protected int[][] numberOfWonGamesInSets = new int[2][6];
    private int[] numberOfWonSets = new int[2];
    private int actualSetIndex;

    private static final int PLAYER_A_INDEX = 0;
    private static final int PLAYER_B_INDEX = 1;
    private static final int MINIMUM_NUMBER_OF_GAME_TO_WIN_SET = 3;
    private static final int WON_GAMES_IN_SET_STRUCTURE_INIT_VALUE = -1;

    public TennisMatch(TypeOfTennisMatch totm) {
        tennisMatchType = totm;
        initNewTennisMatch();
    }

    public PairTennisMatchScore getCurrentScore() {
        CalculateTennisScore cts = new CalculateTennisScore();
        return cts.getCurrentScore(numberOfWonGamesInSets);
    }

    public void addGame(TennisPlayer player) {
        if (player.equals(TennisPlayer.PlayerA)) {
            numberOfWonGamesInSets[PLAYER_A_INDEX][actualSetIndex]++;
        } else if (player.equals(TennisPlayer.PlayerB)) {
            numberOfWonGamesInSets[PLAYER_B_INDEX][actualSetIndex]++;
        } else
            throw new InvalidTennisPlayer();
        if (isSomebodyWinTheCurrentSet()) {
            addWonSetToPlayer();
            initNextSet();
        }
    }

    private void initNewTennisMatch() {
        initNumberOfWonGamesInSetStructure();
        numberOfWonSets[PLAYER_A_INDEX] = 0;
        numberOfWonSets[PLAYER_B_INDEX] = 0;
    }

    private void initNumberOfWonGamesInSetStructure() {
        for (int i = 0; i < numberOfWonGamesInSets[PLAYER_A_INDEX].length; i++) {
            numberOfWonGamesInSets[PLAYER_A_INDEX][i] = WON_GAMES_IN_SET_STRUCTURE_INIT_VALUE;
            numberOfWonGamesInSets[PLAYER_B_INDEX][i] = WON_GAMES_IN_SET_STRUCTURE_INIT_VALUE;
        }
        actualSetIndex = -1;
        initNextSet();
    }

    private void initNextSet() {
        actualSetIndex++;
        numberOfWonGamesInSets[PLAYER_A_INDEX][actualSetIndex] = 0;
        numberOfWonGamesInSets[PLAYER_B_INDEX][actualSetIndex] = 0;
    }

    private boolean isSomebodyWinTheCurrentSet() {
        return (numberOfWonGamesInSets[PLAYER_A_INDEX][actualSetIndex] > MINIMUM_NUMBER_OF_GAME_TO_WIN_SET ||
                numberOfWonGamesInSets[PLAYER_B_INDEX][actualSetIndex] > MINIMUM_NUMBER_OF_GAME_TO_WIN_SET) &&
                Math.abs(numberOfWonGamesInSets[PLAYER_A_INDEX][actualSetIndex] - numberOfWonGamesInSets[PLAYER_B_INDEX][actualSetIndex]) > 1;
    }

    private void addWonSetToPlayer() {
        if (numberOfWonGamesInSets[PLAYER_A_INDEX][actualSetIndex] > numberOfWonGamesInSets[PLAYER_B_INDEX][actualSetIndex])
            numberOfWonSets[PLAYER_A_INDEX]++;
        else
            numberOfWonSets[PLAYER_B_INDEX]++;
    }

    public boolean isMatchOver() {
        if (numberOfWonSets[PLAYER_A_INDEX] > numberOfWonSetsToWinMatch() ||
                numberOfWonSets[PLAYER_B_INDEX] > numberOfWonSetsToWinMatch())
            return true;
        return false;
    }

    public TennisPlayer getWinner() {
        if (numberOfWonSets[PLAYER_A_INDEX] > numberOfWonSetsToWinMatch())
            return TennisPlayer.PlayerA;
        else if (numberOfWonSets[PLAYER_B_INDEX] > numberOfWonSetsToWinMatch())
            return TennisPlayer.PlayerB;
        else
            throw new NoWinnerYet();
    }

    private int numberOfWonSetsToWinMatch() {
        return tennisMatchType.maximumSetInGame / 2;
    }
}

