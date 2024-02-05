package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {
    @Test
    public void whenException() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    factorial.calc(-5);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void whenNotException() {
        Factorial factorial = new Factorial();
        int input = 5;
        int expected = 120;
        int result = factorial.calc(input);
        assertThat(result).isEqualTo(expected);
    }
}