package me.whiteship.refactoring._16_temporary_field._36_introduce_special_case._02_after;

/**
 * _after 3_ 에버 이 코드를 엄청 간추릴 것임
 */
public class CustomerService {

    public String customerName(Site site) {
        Customer customer = site.getCustomer();

        String customerName;
        if (customer.isUnknown()) {
            customerName = "occupant";
        } else {
            customerName = customer.getName();
        }

        return customerName;
    }

    public BillingPlan billingPlan(Site site) {
        Customer customer = site.getCustomer();
        return customer.isUnknown() ? new BasicBillingPlan() : customer.getBillingPlan();
    }

    public int weeksDelinquent(Site site) {
        Customer customer = site.getCustomer();
        return customer.isUnknown() ? 0 : customer.getPaymentHistory().getWeeksDelinquentInLastYear();
    }

}
