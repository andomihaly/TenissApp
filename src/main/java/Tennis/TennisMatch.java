package Tennis;

public class TennisMatch {
    private PlayGame actualGame;

    public TennisMatch(PlayGame realGame){
        actualGame = realGame;
    }
    public String getGame() {
        return actualGame.GetWhoWonTheGame();
    }

}
