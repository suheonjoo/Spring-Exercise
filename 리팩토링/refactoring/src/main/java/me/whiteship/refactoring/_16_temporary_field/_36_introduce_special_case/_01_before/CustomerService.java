package me.whiteship.refactoring._16_temporary_field._36_introduce_special_case._01_before;

public class CustomerService {

    public String customerName(Site site) {
        Customer customer = site.getCustomer();

        String customerName;
        if (customer.getName().equals("unknown")) {
            customerName = "occupant";
        } else {
            customerName = customer.getName();
        }

        return customerName;
    }

    /**
     * 여기 코드를 보면 unknown 을 체크하는 조건들이 많이 있음 밑에 weeksDelinquent 메서드 에도 있음
     * @param site
     * @return
     */
    public BillingPlan billingPlan(Site site) {
        Customer customer = site.getCustomer();
        return customer.getName().equals("unknown") ? new BasicBillingPlan() : customer.getBillingPlan();
    }

    public int weeksDelinquent(Site site) {
        Customer customer = site.getCustomer();
        return customer.getName().equals("unknown") ? 0 : customer.getPaymentHistory().getWeeksDelinquentInLastYear();
    }

}
