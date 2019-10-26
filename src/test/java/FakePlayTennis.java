import Tennis.PlayTennis;
import Tennis.TennisPlayer;

class FakePlayTennis implements PlayTennis {
    public TennisPlayer GetWhoWonTheGame() {
        return TennisPlayer.PlayerA;
    }
}
