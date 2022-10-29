package me.whiteship.refactoring._07_divergent_change._24_split_phase._01_before;

public class PriceOrder {

    /**
     * 여기서 코드를 보삼 어마어마한 단계가 있음
     * @param product
     * @param quantity
     * @param shippingMethod
     * @return
     */
    public double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {


        final double basePrice = product.basePrice() * quantity;
        final double discount = Math.max(quantity - product.discountThreshold(), 0)
                * product.basePrice() * product.discountRate();
        final double shippingPerCase = (basePrice > shippingMethod.discountThreshold()) ?
                shippingMethod.discountedFee() : shippingMethod.feePerCase();
        final double shippingCost = quantity * shippingPerCase;
        final double price = basePrice - discount + shippingCost;
        return price;
    }
}
