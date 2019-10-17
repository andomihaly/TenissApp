package Starter;

import Tennis.PlayGame;

class PlayGameSimulator implements PlayGame {
    @Override
    public String GetWhoWonTheGame() {
        if (Math.random()>0.5)
            return "A";
        else
            return "B";
    }
}
