package me.whiteship.refactoring._08_shotgun_surgery._27_move_field._01_before;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Customer {

    private String name;

    private double discountRate;

    private CustomerContract contract;

    public Customer(String name, double discountRate) {
        this.name = name;
        this.discountRate = discountRate;
        /**
         * 할인률이 CustomerContract 와 관련 있다는 가정하에 리팩토링 진행
         */
        this.contract = new CustomerContract(dateToday());
    }

    /**
     * this 를 통해서 값을 변경하는 것을 setter로 접근하게 할것임
     * @return
     */

    public double getDiscountRate() {
        return discountRate;
    }

    public void becomePreferred() {
        this.discountRate += 0.03;
        // 다른 작업들
    }

    public double applyDiscount(double amount) {
        BigDecimal value = BigDecimal.valueOf(amount);
        return value.subtract(value.multiply(BigDecimal.valueOf(this.discountRate))).doubleValue();
    }

    private LocalDate dateToday() {
        return LocalDate.now();
    }
}
