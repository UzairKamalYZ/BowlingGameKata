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
        for (int i = 2; i < 20; i++) {
            bowlingGame.roll(0);
        }
        assertThat(bowlingGame.getScore()).isEqualTo(10);
    }
}
