package ru.job4j.ood.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {
    @Test
    public void whenInputModThreeEqualsZeroThenFizz() {
        String expected = "Fizz";
        int input = 6;
        assertThat(Fool.correctAnswer(input)).isEqualTo(expected);
    }

    @Test
    public void whenInputModFiveEqualsZeroThenBuzz() {
        String expected = "Buzz";
        int input = 10;
        assertThat(Fool.correctAnswer(input)).isEqualTo(expected);
    }

    @Test
    public void whenInputModThreeAndFiveEqualsZeroThenFizzBuzz() {
        String expected = "FizzBuzz";
        int input = 15;
        assertThat(Fool.correctAnswer(input)).isEqualTo(expected);
    }

    @Test
    public void whenInputModThreeOrFiveNotEqualsZeroThenNum() {
        String expected = "13";
        int input = 13;
        assertThat(Fool.correctAnswer(input)).isEqualTo(expected);
    }
}