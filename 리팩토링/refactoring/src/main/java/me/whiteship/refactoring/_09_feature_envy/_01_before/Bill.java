package me.whiteship.refactoring._09_feature_envy._01_before;

public class Bill {

    private ElectricityUsage electricityUsage;

    private GasUsage gasUsage;

    public double calculateBill() {
        /**
         * 여기서 기능 욕심을 내요 있는 것임
         * electricityUsage 를 참조해서
         */
        var electicityBill = electricityUsage.getAmount() * electricityUsage.getPricePerUnit();
        var gasBill = gasUsage.getAmount() * gasUsage.getPricePerUnit();
        return electicityBill + gasBill;
    }

}
