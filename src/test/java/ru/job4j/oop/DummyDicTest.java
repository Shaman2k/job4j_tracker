package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class DummyDicTest {

    @Test
    void engToRusMap() {
        DummyDic dummyDic = new DummyDic();
        String result = dummyDic.engToRus("map");
        String expected = "Неизвестное слово. map";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void engToRusEmpty() {
        DummyDic dummyDic = new DummyDic();
        String result = dummyDic.engToRus("");
        String expected = "Неизвестное слово. ";
        assertThat(result).isEqualTo(expected);
    }
}