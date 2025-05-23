package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
class FindByIdTest {
    @Test
    public void whenItemFindByIdSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();

        tracker.add(new Item("item"));
        UserAction action = new FindById(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).contains(
                "=== Вывод заявки по id ===" + ln
                        + "Item{id=1, name='item', created="
        );
    }

    @Test
    public void whenItemWasNotFindById() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("item"));
        UserAction action = new FindById(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);

        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявки по id ===" + ln
                        + "Заявка с введенным id: 2 не найдена." + ln
        );
    }
}