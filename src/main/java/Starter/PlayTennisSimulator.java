package Starter;

import Tennis.PlayTennis;
import Tennis.TennisPlayer;

class PlayTennisSimulator implements PlayTennis {
    @Override
    public TennisPlayer GetWhoWonTheGame() {
        if (Math.random()>0.5)
            return TennisPlayer.PlayerA;
        else
            return TennisPlayer.PlayerB;
    }
}
