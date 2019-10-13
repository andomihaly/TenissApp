public class PlayAGame {
    public static void main(String [] args)
    {
        System.out.println("Play A tennis game");
        TennisGame tennisGame = new TennisGame(new PlayGameSimulator());
        System.out.printf("A Set  | B Set  | A Game | B Game |%n");
        while (!tennisGame.IsMatchOver(3)) {
            tennisGame.addGame(tennisGame.getGame());
            PairTennisGameScore ptgs = tennisGame.getCurrentScore();
            System.out.printf("   %d   |    %d   |",ptgs.playerAScore.set,ptgs.playerBScore.set );
            System.out.printf("  %-5d |  %-5d |%n",ptgs.playerAScore.game,ptgs.playerBScore.game );
        }
        System.out.printf("Game is over %s player is win the tennis match.%n", tennisGame.GetWinner(2));
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
