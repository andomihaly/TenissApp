package app.Tennis;

public enum TypeOfTennisMatch {
    BestOfThree(3),
    BestOfFive(5);

    public final int maximumSetInGame;

    private TypeOfTennisMatch(int maximumSetInGame) {
        this.maximumSetInGame = maximumSetInGame;
    }
}
