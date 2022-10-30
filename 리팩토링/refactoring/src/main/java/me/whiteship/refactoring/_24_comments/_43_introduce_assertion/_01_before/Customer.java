package me.whiteship.refactoring._24_comments._43_introduce_assertion._01_before;

public class Customer {

    private Double discountRate;

    /**
     * 여기서 amount 가 음수가 아니라고 가정을 하는 것임
     * @param amount
     * @return
     */
    public double applyDiscount(double amount) {
        return (this.discountRate != null) ? amount - (this.discountRate * amount) : amount;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }
}
