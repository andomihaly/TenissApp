public class PlayAGame {
    public static void main(String [] args)
    {
        TennisGame tennisGame = new TennisGame(new PlayGameSimulator());
        System.out.printf(PLAY(tennisGame));

    }

    public static String PLAY(TennisGame tennisGame) {
        String row="";
        row += String.format("Play A tennis game%n");
        row += String.format("A Set  | B Set  | A Game | B Game |%n");
        while (!tennisGame.IsMatchOver(3)) {
            tennisGame.addGame(tennisGame.getGame());
            PairTennisGameScore ptgs = tennisGame.getCurrentScore();
            row += String.format("   %d   |    %d   |",ptgs.playerAScore.set,ptgs.playerBScore.set );
            row += String.format("  %-5d |  %-5d |%n",ptgs.playerAScore.game,ptgs.playerBScore.game );
        }
        row += String.format("Game is over %s player is win the tennis match.%n", tennisGame.GetWinner(2));
        return row;
    }

    private static class PlayGameSimulator implements PlayGame {
        @Override
        public String GetWhoWonTheGame() {
            if (Math.random()>0.5)
                return "A";
            else
                return "B";
        }
    }
}
