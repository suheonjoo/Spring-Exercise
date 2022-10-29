package me.whiteship.refactoring._07_divergent_change._24_split_phase._02_after;

public class PriceOrder {

    /**
     * 여기서 코드를 보삼 어마어마한 단계가 있음
     * @param product
     * @param quantity
     * @param shippingMethod
     * @return
     */
    public double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {
        /**
         * 여기서 priceData 없이 그냥 한줄로도 만들 수 있지만 강의자는 데이터타입 이름을 명시가면서 더 가독성이 좋다고 생각해서 남겼다고 함
         */
        final PriceData priceData = calculatePriceData(product, quantity);
        //그냥 팁인데 추가할 파라미터를 일단 넣고 option enter로 오류처리하는게 빠르다고 함
        return applyShipping(priceData, shippingMethod);
    }

    private PriceData calculatePriceData(Product product, int quantity) {
        final double basePrice = product.basePrice() * quantity;
        final double discount = Math.max(quantity - product.discountThreshold(), 0)
                * product.basePrice() * product.discountRate();

        /**
         * 위, 아래의 중간 역할을 하는 데이터를 만들꺼임
         */
        final PriceData priceData = new PriceData(basePrice, discount, quantity);
        return priceData;
    }

    private double applyShipping(PriceData priceData, ShippingMethod shippingMethod) {
        final double shippingPerCase = (priceData.basePrice() > shippingMethod.discountThreshold()) ?
                shippingMethod.discountedFee() : shippingMethod.feePerCase();
        final double shippingCost = priceData.quantity() * shippingPerCase;
        final double price = priceData.basePrice() - priceData.discount() + shippingCost;
        return price;
    }
}
