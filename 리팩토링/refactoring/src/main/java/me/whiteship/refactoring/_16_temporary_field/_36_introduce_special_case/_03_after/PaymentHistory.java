package me.whiteship.refactoring._16_temporary_field._36_introduce_special_case._03_after;

public class PaymentHistory {

    private int weeksDelinquentInLastYear;

    public PaymentHistory(int weeksDelinquentInLastYear) {
        this.weeksDelinquentInLastYear = weeksDelinquentInLastYear;
    }

    public int getWeeksDelinquentInLastYear() {
        return this.weeksDelinquentInLastYear;
    }
}
