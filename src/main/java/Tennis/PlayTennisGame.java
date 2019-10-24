package Tennis;

public class PlayTennisGame {
    private PlayTennis actualGame;

    public PlayTennisGame(PlayTennis realGame){
        actualGame = realGame;
    }
    public String getGame() {
        return actualGame.GetWhoWonTheGame();
    }

}
