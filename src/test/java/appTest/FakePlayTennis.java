package appTest;

import app.Tennis.PlayTennis;
import app.Tennis.TennisPlayer;

class FakePlayTennis implements PlayTennis {
    public TennisPlayer GetWhoWonTheGame() {
        return TennisPlayer.PlayerA;
    }
}
