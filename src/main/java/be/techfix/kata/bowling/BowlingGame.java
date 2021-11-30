package be.techfix.kata.bowling;

public class BowlingGame {
    private final int[] rolls = new int[21];
    private int roll;

    public void roll(int pins) {

        rolls[roll++] = pins;
        if (pins == 10) {
            roll++;
        }
    }

    public int[] getRolls() {
        return rolls;
    }

    public int getScore() {
        int score = 0;
        for (int rol = 0; rol < rolls.length; rol = rol + 2) {

            int rolScore = rolls[rol];
            int secondRole = rol + 1;
            int nextFrame1stRol = rol + 2;
            int nextFrame2ndRol = rol + 3;
            int frameScore = 0;

            if (secondRole < rolls.length) {
                frameScore = rolScore + rolls[secondRole];
            } else {
                frameScore += rolScore;
            }
            score += frameScore;


            if (rolScore == 10) {
                if (isNextFrameAvailable(nextFrame1stRol)) {
                    int strikeBonus = rolls[nextFrame1stRol] + rolls[nextFrame2ndRol];
                    score += strikeBonus;
                }
            } else if (frameScore == 10) {
                int spareBonus = rolls[nextFrame1stRol];
                score += spareBonus;
            }
        }
        return score;
    }

    private boolean isNextFrameAvailable(int rol) {

        return (rol < rolls.length);
    }
}
