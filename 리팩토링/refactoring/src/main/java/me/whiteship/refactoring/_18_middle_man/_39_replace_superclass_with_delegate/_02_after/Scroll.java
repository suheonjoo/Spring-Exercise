package me.whiteship.refactoring._18_middle_man._39_replace_superclass_with_delegate._02_after;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * 지금 보면 Scroll 의 상속구조를 깨버림, 원래 CategoryItem 을 상속했었음
 */
public class Scroll {

    private LocalDate dateLastCleaned;

    /**
     * 이 필드를 추가해줌 (여기가 before 하고 다른 부분임)
     */
    private CategoryItem categoryItem;


    public Scroll(Integer id, String title, List<String> tags, LocalDate dateLastCleaned) {
        this.dateLastCleaned = dateLastCleaned;
        this.categoryItem = new CategoryItem(id, title, tags);
    }

    public long daysSinceLastCleaning(LocalDate targetDate) {
        return this.dateLastCleaned.until(targetDate, ChronoUnit.DAYS);
    }
}
