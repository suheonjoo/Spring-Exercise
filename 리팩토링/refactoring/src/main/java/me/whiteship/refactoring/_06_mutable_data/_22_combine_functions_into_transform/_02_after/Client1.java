package me.whiteship.refactoring._06_mutable_data._22_combine_functions_into_transform._02_after;

public class Client1 extends ReadingClient{

    double baseCharge;

    /**
     * 여기서 반복되는 코드가 보임
     * @param reading
     */
    public Client1(Reading reading) {
        this.baseCharge = baseRate(reading.month(), reading.year()) * reading.quantity();
    }

    public double getBaseCharge() {
        return baseCharge;
    }
}
