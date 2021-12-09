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
        bowlingGame.rollMulti(0,5);
        bowlingGame.roll(5);
        assertThat(bowlingGame.getRolls()[0]).isEqualTo(0);
        assertThat(bowlingGame.getRolls()[1]).isEqualTo(5);
    }

    @Test
    void should_return_score_of_10_when_user_have_two_rolls_of_7_and_3_while_rest_are_zero() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.rollMulti(7,3);
        assertThat(bowlingGame.getScore()).isEqualTo(10);
    }

    @Test
    void should_return_score_12_for_a_spare_and_roll_of_1() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.rollMulti(7,3,1);
        assertThat(bowlingGame.getScore()).isEqualTo(12);
    }

    @Test
    void should_return_score_20_for_a_spare_and_roll_of_5() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.rollMulti(5, 5, 5);

        assertThat(bowlingGame.getScore()).isEqualTo(20);
    }

    @Test
    void should_return_score_16_for_a_strike_followed_by_1_and_2() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.rollMulti(10,0,1,2);
        assertThat(bowlingGame.getScore()).isEqualTo(16);
    }


    @Test
    void shoudl_have_score_53_for_double_strike_followed_by_5_and_4() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.rollMulti(10,0, 10,0, 5, 4);
        assertThat(bowlingGame.getScore()).isEqualTo(53);
    }

    @Test
    void shoudl_have_score_82_for_triple_strike_followed_by_5_and_4() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.rollMulti(10,0, 10,0, 10,0, 5, 4);
        assertThat(bowlingGame.getScore()).isEqualTo(83);
    }

    @Test
    void should_return_score_42_for_a_strike_followed_by_1_and_2_and_a_spare_followed_by_1() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.rollMulti(5, 1,
                10, 0,
                1, 2,
                7, 1,
                5, 5,
                1, 0);

        // 5+1{10+1+2+1+2}+7+1+( 5+5+1)+1
        assertThat(bowlingGame.getScore()).isEqualTo(42);

    }

    @Test
    void should_return_181_for_user() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.rollMulti(
                7, 3
                , 10, 0
                , 6, 2
                , 10, 0
                , 10, 0
                , 9, 1
                , 0, 10
                , 10, 0
                , 7, 2
                , 10, 10, 8

        );
        // 5+1{10+1+2+1+2}+7+1+( 5+5+1)+1
        assertThat(bowlingGame.getScore()).isEqualTo(181);

    }


}
