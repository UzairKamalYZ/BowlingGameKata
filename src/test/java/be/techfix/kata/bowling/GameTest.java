package be.techfix.kata.bowling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameTest {

    @Test
    void should_be_able_to_roll_zero_to_10_pins() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        assertThat(bowlingGame.getRolls()[0]).isEqualTo(0);
        assertThat(bowlingGame.getRolls()[1]).isEqualTo(5);
    }

    @Test
    void should_return_score_of_10_when_user_have_two_rolls_of_7_and_3_while_rest_are_zero() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(7);
        bowlingGame.roll(3);
        assertThat(bowlingGame.getScore()).isEqualTo(10);
    }

    @Test
    void should_return_score_12_for_a_spare_and_roll_of_1() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(7);
        bowlingGame.roll(3);//spare
        bowlingGame.roll(1);
        assertThat(bowlingGame.getScore()).isEqualTo(12);
    }

    @Test
    void should_return_score_20_for_a_spare_and_roll_of_5() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(5);
        bowlingGame.roll(5);//spare
        bowlingGame.roll(5);
        assertThat(bowlingGame.getScore()).isEqualTo(20);
    }

    @Test
    void should_return_score_16_for_a_strike_followed_by_1_and_2() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(10);
        bowlingGame.roll(1);//spare
        bowlingGame.roll(2);
        assertThat(bowlingGame.getScore()).isEqualTo(16);
    }


    @Test
    void should_not_have_frame_of_3_rolls_when_strike_or_spare_doesnot_happens_at_10th_frame() {
        BowlingGame bowlingGame = new BowlingGame();
        rollTill10thFrameWithValue(bowlingGame, 3);
        bowlingGame.roll(3); // strike so eligible for last roll
        bowlingGame.roll(5);
        bowlingGame.roll(7);

        assertThat(bowlingGame.getRolls()[20]).isEqualTo(0);

    }

    @Test
    void should_have_frame_of_3_rolls_when_strike_happens_at_10th_frame() {
        BowlingGame bowlingGame = new BowlingGame();
        rollTill10thFrameWithValue(bowlingGame, 3);
        bowlingGame.roll(10); // strike so eligible for last roll
        bowlingGame.roll(5);
        assertThat(bowlingGame.getRolls()[20]).isEqualTo(5);
    }

    @Test
    void shoudl_have_score_53_for_double_strike_followed_by_5_and_4() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.rollMulti(10,10,5,4);
        assertThat(bowlingGame.getScore()).isEqualTo(53);
    }

    @Test
    void shoudl_have_score_82_for_triple_strike_followed_by_5_and_4() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.rollMulti(10,10,10,5,4);
        assertThat(bowlingGame.getScore()).isEqualTo(83);
    }

    @Test
    void should_return_score_42_for_a_strike_followed_by_1_and_2_and_a_spare_followed_by_1() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.rollMulti(5,1,10,1,2,7,1,5,5,1);

        // 5+1{10+1+2+1+2}+7+1+( 5+5+1)+1
        assertThat(bowlingGame.getScore()).isEqualTo(42);

    }


    private void rollTill10thFrameWithValue(BowlingGame bowlingGame, int pins) {
        bowlingGame.roll(pins);
        bowlingGame.rollMulti(3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3);
    }


}
