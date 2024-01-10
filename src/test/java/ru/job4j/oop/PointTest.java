package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PointTest {
    @Test
    void when000to222then3Dot46() {
        double expected = 3.46;
        Point a = new Point(0, 0, 0);
        Point b = new Point(2, 2, 2);
        double out = a.distance3D(b);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenMinus52Minus1to3Minus35then11Dot18() {
        double expected = 11.18;
        Point a = new Point(-5, 2, -1);
        Point b = new Point(3, -3, 5);
        double out = a.distance3D(b);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }
}