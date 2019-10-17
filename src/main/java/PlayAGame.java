public class PlayAGame {
    public static void main(String [] args)
    {
        System.out.println("Play A tennis game");
        TennisGame tennisGame = new TennisGame(TypeOfTennisMatch.BestOfFive);
        System.out.printf("GameNo. | A Set  | B Set  | A Game | B Game |%n");
        int numberOfGame=0;
        TennisMatch tm = new TennisMatch(new PlayGameSimulator());
        while (!tennisGame.IsMatchOver()) {
            tennisGame.addGame(tm.getGame());
            PairTennisGameScore ptgs = tennisGame.getCurrentScore();
            System.out.printf("  %-3s   |", numberOfGame++);
            System.out.printf("   %d   |    %d   |",ptgs.playerAScore.set,ptgs.playerBScore.set );
            System.out.printf("  %-5d  |  %-5d |%n",ptgs.playerAScore.game,ptgs.playerBScore.game );
        }
        System.out.printf("Game is over %s player is win the tennis match after %d games. %n", tennisGame.GetWinner(),numberOfGame);
    }
}
