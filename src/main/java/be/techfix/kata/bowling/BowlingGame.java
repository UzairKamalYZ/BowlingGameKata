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
        for (int rol = 0; rol < rolls.length; rol++) {
            if (isNextRollAvailable(rol)) {
                int frameScore = rolls[rol] + rolls[rol + 1];
                if (frameScore == 10) {
                    score += 10 + rolls[rol + 2];
                    rol++;
                } else {
                    score += rolls[rol];
                }

            }
        }
        return score;
    }

    private boolean isNextRollAvailable(int rol) {
        int i = rol + 1;
        return (i < rolls.length);
    }
}
