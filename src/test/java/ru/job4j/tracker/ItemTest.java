package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    void whenSortAsc() {
        List<Item> list = Arrays.asList(new Item("ddd"),
                new Item("aaa"), new Item("ccc"),
                new Item("1aa"), new Item("bbbb"));
        list.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item("1aa"),
                new Item("aaa"), new Item("bbbb"),
                new Item("ccc"), new Item("ddd"));
        assertThat(list).isEqualTo(expected);
    }

    @Test
    void whenSortDesc() {
        List<Item> list = Arrays.asList(new Item("ddd"),
                new Item("aaa"), new Item("ccc"),
                new Item("1aa"), new Item("bbbb"));
        list.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item("ddd"),
                new Item("ccc"), new Item("bbbb"),
                new Item("aaa"), new Item("1aa"));
        assertThat(list).isEqualTo(expected);
    }
}