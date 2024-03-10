package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    void whenSortAsc() {
        List<Item> list = new ArrayList<>();
        list.add(new Item("ddd"));
        list.add(new Item("aaa"));
        list.add(new Item("ccc"));
        list.add(new Item("1aa"));
        list.add(new Item("bbbb"));
        list.sort(new ItemAscByName());
        List<Item> excepted = new ArrayList<>();
        excepted.add(new Item("1aa"));
        excepted.add(new Item("aaa"));
        excepted.add(new Item("bbbb"));
        excepted.add(new Item("ccc"));
        excepted.add(new Item("ddd"));
        assertThat(list).isEqualTo(excepted);
    }

    @Test
    void whenSortDesc() {
        List<Item> list = new ArrayList<>();
        list.add(new Item("ddd"));
        list.add(new Item("aaa"));
        list.add(new Item("ccc"));
        list.add(new Item("1aa"));
        list.add(new Item("bbbb"));
        list.sort(new ItemDescByName());
        List<Item> excepted = new ArrayList<>();
        excepted.add(new Item("ddd"));
        excepted.add(new Item("ccc"));
        excepted.add(new Item("bbbb"));
        excepted.add(new Item("aaa"));
        excepted.add(new Item("1aa"));
        assertThat(list).isEqualTo(excepted);
    }
}