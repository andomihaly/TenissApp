public class TennisMatch {
    private PlayGame actualGame;

    TennisMatch(PlayGame realGame){
        actualGame = realGame;
    }
    public String getGame() {
        return actualGame.GetWhoWonTheGame();
    }

}
