package me.whiteship.refactoring._06_mutable_data._22_combine_functions_into_transform._02_after;

public class Client2 extends ReadingClient{

    private double base;
    private double taxableCharge;

    /**
     * 다형성으로 부모의 enrichReading() 메서드를 쓸수 있음
     * @param reading
     */
    public Client2(Reading reading) {
        EnrichReading enrichReading = enrichReading(reading);
        this.base = enrichReading(reading).baseCharge();
        this.taxableCharge = enrichReading.taxableCharge();
    }

    public double getBase() {
        return base;
    }

    public double getTaxableCharge() {
        return taxableCharge;
    }
}
