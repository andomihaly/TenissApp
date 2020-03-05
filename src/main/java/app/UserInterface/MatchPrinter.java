package app.UserInterface;

public class MatchPrinter {
    public String displayActualScoreHeader(String winnerName) {
        return String.format("Game is over. %s won the tennis match.", winnerName);
    }
}
