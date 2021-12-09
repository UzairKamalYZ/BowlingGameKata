package be.techfix.kata.bowling;

import java.util.Arrays;

public class BowlingGame {
    private int[] rolls = new int[21];
    private int roll;

    public BowlingGame() {
        Arrays.fill(rolls, 0);
    }

    public void roll(int pins) {

//        if (roll == 20) {
//            int frameScore = rolls[18] + rolls[19];
//            if (frameScore == 10) {
//                rolls[20] = pins;
//            }
//        } else if (roll < 20) {
//            rolls[roll++] = pins;
//            if (pins == 10 && roll%2!=0) {
//                roll++;
//            }
//        }


    }

    public void rollMulti(int... pins) {
        int count = 0;
        for (int p : pins) {
            rolls[count++] = p;
        }
    }

    public int[] getRolls() {
        return rolls;
    }

    public int getScore() {
        int score = 0;
        for (int rol = 0; rol < rolls.length - 1; rol = rol + 2) {

            int rolScore = rolls[rol];
            int secondRole = rol + 1;
            int nextFrame1stRol = rol + 2;
            int nextFrame2ndRol = rol + 3;
            int nextToNextFrame1stRoll = rol + 4;
            int frameScore = 0;

            if (secondRole < rolls.length) {
                frameScore = rolScore + rolls[secondRole];
            } else {
                frameScore += rolScore;
            }
            score += frameScore;


            if (rolScore == 10) {

                if (isNextFrameAvailable(nextFrame1stRol)) {
                    int strikeBonus = 0;
                    if (isNextFrameHasStrike(nextFrame1stRol)) {
                        strikeBonus = rolls[nextFrame1stRol] + getNextToNextFrame1stRole(nextToNextFrame1stRoll);
                    } else {
                        strikeBonus = getRoll(nextFrame1stRol) + getRoll(nextFrame2ndRol);
                    }
                    score += strikeBonus;
                }
            } else if (frameScore == 10) {
                int spareBonus = rolls[nextFrame1stRol];
                score += spareBonus;
            }
        }
        return score;
    }

    private int getRoll(int nextFrame1stRol) {
        if (nextFrame1stRol >= rolls.length) return 0;
        else
            return rolls[nextFrame1stRol];
    }

    private int getNextToNextFrame1stRole(int nextToNextFrame1stRoll) {
        if (nextToNextFrame1stRoll >= rolls.length) return 0;
        return rolls[nextToNextFrame1stRoll];
    }

    private boolean isNextFrameAvailable(int rol) {

        return (rol < rolls.length);
    }

    private boolean isNextFrameHasStrike(int index) {
        return rolls[index] == 10;
    }
}
