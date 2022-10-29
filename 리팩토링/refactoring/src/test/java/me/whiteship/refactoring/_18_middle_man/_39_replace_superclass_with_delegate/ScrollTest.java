package me.whiteship.refactoring._18_middle_man._39_replace_superclass_with_delegate;

import me.whiteship.refactoring._18_middle_man._39_replace_superclass_with_delegate._01_before.Scroll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ScrollTest {

    @Test
    void daysSinceLastCleaning() {
        Scroll scroll = new Scroll(1, "whiteship", null, LocalDate.of(2022, 1, 10));
        assertEquals(5, scroll.daysSinceLastCleaning(LocalDate.of(2022, 1, 15)));
    }

}