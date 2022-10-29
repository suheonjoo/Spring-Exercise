package me.whiteship.refactoring._06_mutable_data._18_split_variable._02_after;

public class Order {

    /**
     * 개꿀 단축키 commnad shift t 로 테스트 생성 뿐만 아니라 이동 까지 해줌
     * @param inputValue
     * @param quantity
     * @return
     */
    public double discount(double inputValue, int quantity) {
        /**
         * 여기서 도 역할 나눠줌 inputValue 에서 한번에 해결하지 말고 result 변수 만들어줌
         */
        double result = inputValue;
        if (result > 50) result = result - 2;
        if (quantity > 100) result = result - 1;
        return result;
    }
}
