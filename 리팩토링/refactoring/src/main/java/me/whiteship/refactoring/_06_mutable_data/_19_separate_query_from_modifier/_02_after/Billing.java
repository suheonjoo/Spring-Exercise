package me.whiteship.refactoring._06_mutable_data._19_separate_query_from_modifier._02_after;

public class Billing {

    private Customer customer;

    private EmailGateway emailGateway;

    public Billing(Customer customer, EmailGateway emailGateway) {
        this.customer = customer;
        this.emailGateway = emailGateway;
    }

    /**
     * 여기서 getTotalOutstanding 와 sendBill 을 분리시킴 -> sendBill 은 이미 있으니깐 분리시킬 필요 없음
     * 이후 리팩토링 후 테스트 코드에서 값만 조회하지 sendBill 을 날리지 않음
     * @return
     */
    public double totalOutstanding() {
        return customer.getInvoices().stream()
                .map(Invoice::getAmount)
                .reduce((double) 0, Double::sum);
    }

    /**
     * 이것도 public 으로 변경해주고
     */
    public void sendBill() {
        emailGateway.send(formatBill(customer));
    }

    private String formatBill(Customer customer) {
        return "sending bill for " + customer.getName();
    }
}
