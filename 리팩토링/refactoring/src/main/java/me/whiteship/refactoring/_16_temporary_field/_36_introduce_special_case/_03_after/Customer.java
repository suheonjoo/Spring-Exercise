package me.whiteship.refactoring._16_temporary_field._36_introduce_special_case._03_after;

public class Customer {

    private String name;

    private BillingPlan billingPlan;

    private PaymentHistory paymentHistory;

    public Customer(String name, BillingPlan billingPlan, PaymentHistory paymentHistory) {
        this.name = name;
        this.billingPlan = billingPlan;
        this.paymentHistory = paymentHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BillingPlan getBillingPlan() {
        return billingPlan;
    }

    public void setBillingPlan(BillingPlan billingPlan) {
        this.billingPlan = billingPlan;
    }

    public PaymentHistory getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(PaymentHistory paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    /**
     * 따로 Unknown 판단 로직을 따로 빼줌
     * 근데 보면 customer 클래스 소속으로 넣는게 낫다고 생각해서 customer 로 클래스 옮김
     * @return
     */
    public boolean isUnknown() {
        return false; //여기서는 false 로 반환하고 unknown 클래스 에서는 true를 반환하도록 오버라이드 함
    }
}
