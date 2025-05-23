package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class FindByNameTest {
    @Test
    public void whenItemFindByNameSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();

        tracker.add(new Item("item"));
        UserAction action = new FindByName(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("item");

        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).contains(
                "=== Вывод заявок по имени ===" + ln
                        + "Item{id=1, name='item', created="
        );
    }

    @Test
    public void whenItemWasNotFindByName() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("item"));
        UserAction action = new FindByName(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("name2");

        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявок по имени ===" + ln
                        + "Заявки с именем: name2 не найдены." + ln
        );
    }
}