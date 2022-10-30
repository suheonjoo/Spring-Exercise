package me.whiteship.refactoring._24_comments._43_introduce_assertion._02_after;

public class Customer {

    private Double discountRate;

    public double applyDiscount(double amount) {
        return (this.discountRate != null) ? amount - (this.discountRate * amount) : amount;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        /**
         * 어디서 assert 를 선언한느게 좋냐? 최초의 값이 설정되때 assert 로 검사하는게 강의자가 좋다고 함
         *
         * 근데 사실 이 옵션은 잘못된 값이 들어온것이니깐 assert보다는 if 문을 통해 검사하느게 더 좋음!!
         */
        //assert discountRate != null && discountRate > 0;
        if (discountRate != null && discountRate > 0) {
            throw new IllegalArgumentException(discountRate + " can't be minus");
        }
        this.discountRate = discountRate;
    }
}
