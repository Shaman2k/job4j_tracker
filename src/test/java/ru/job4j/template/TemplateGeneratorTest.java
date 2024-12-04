package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class TemplateGeneratorTest {
    @Test
    public void whenAllKeysPresentThenGenerateString() {
        Generator generator = new TemplateGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String expected = "I am a Petr Arsentev, Who are you? ";
        assertThat(generator.produce(template, map))
                .isEqualTo(expected);
    }

    @Test
    public void whenMapContainExtraKeyThenGetException() {
        Generator generator = new TemplateGenerator();
        String template = "I am a ${name}, Who are you? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenMissingKeyThenGetException() {
        Generator generator = new TemplateGenerator();
        String template = "I am a ${name}, Who are you? ";
        Map<String, String> map = new HashMap<>();
        map.put("subject", "you");
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenTemplateWithoutKeysThenReturnTemplate() {
        Generator generator = new TemplateGenerator();
        String template = "I am a Petr, Who are you? ";
        Map<String, String> map = new HashMap<>();
        assertThat(generator.produce(template, map))
                .isEqualTo(template);
    }
}