package Tennis;

public class PlayTennisGame {
    private PlayTennis actualGame;

    public PlayTennisGame(PlayTennis realGame){
        actualGame = realGame;
    }
    public TennisPlayer getGame() {
        return actualGame.GetWhoWonTheGame();
    }

}
