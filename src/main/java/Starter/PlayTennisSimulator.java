package Starter;

import Tennis.PlayTennis;

class PlayTennisSimulator implements PlayTennis {
    @Override
    public String GetWhoWonTheGame() {
        if (Math.random()>0.5)
            return "A";
        else
            return "B";
    }
}
