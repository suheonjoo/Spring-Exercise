package me.whiteship.refactoring._18_middle_man._39_replace_superclass_with_delegate._01_before;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * scroll 은 어떤 특정 아이템이지 카테고리가 아님 그래서 강의자는 상속하고 맞지 않다고 봄
 */
public class Scroll extends CategoryItem {

    private LocalDate dateLastCleaned;

    public Scroll(Integer id, String title, List<String> tags, LocalDate dateLastCleaned) {
        super(id, title, tags);
        this.dateLastCleaned = dateLastCleaned;
    }

    public long daysSinceLastCleaning(LocalDate targetDate) {
        return this.dateLastCleaned.until(targetDate, ChronoUnit.DAYS);
    }
}
