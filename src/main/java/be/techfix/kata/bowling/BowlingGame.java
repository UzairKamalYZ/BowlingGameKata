package be.techfix.kata.bowling;

public class BowlingGame {
    private final int[] rolls = new int[21];
    private int roll;

    public void roll(int pins) {
        rolls[roll++] = pins;
    }

    public int[] getRolls() {
        return rolls;
    }

    public int getScore() {
        int score = 0;
        for (int j : rolls) {
            score += j;
        }
        return score;
    }
}
