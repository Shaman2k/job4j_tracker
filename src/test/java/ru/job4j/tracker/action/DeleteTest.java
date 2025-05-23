package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class DeleteTest {
    @Test
    public void whenItemWasDeleteSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("item"));
        UserAction action = new Delete(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Удаление заявки ===" + ln
                        + "Заявка удалена успешно." + ln
        );
    }

    @Test
    public void whenItemWasNotDelete() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("item"));
        UserAction action = new Delete(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);

        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Удаление заявки ===" + ln
                        + "Ошибка удаления заявки." + ln
        );
    }
}