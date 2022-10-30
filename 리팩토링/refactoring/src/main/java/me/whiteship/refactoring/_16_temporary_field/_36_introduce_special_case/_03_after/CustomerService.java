package me.whiteship.refactoring._16_temporary_field._36_introduce_special_case._03_after;

public class CustomerService {

    public String customerName(Site site) {
        /**
         * 이미 site 를 통해 customer가 unknown 인 것 알려주도록 리팩토링해서 아래 주석과 같은 로직이 필요 없음
         */
        return site.getCustomer().getName();
//
//        String customerName;
//        if (customer.isUnknown()) {
//            customerName = "occupant";
//        } else {
//            customerName = customer.getName();
//        }
//
//        return customerName;
    }

    public BillingPlan billingPlan(Site site) {
        return site.getCustomer().getBillingPlan();
    }

    public int weeksDelinquent(Site site) {

        /**
         * 여기에 null object 패턴 적용함 ******************* 여기 중요함 코드가 엄청 까끔해짐
         */
        //return customer.isUnknown() ? 0 : customer.getPaymentHistory().getWeeksDelinquentInLastYear();
        return site.getCustomer().getPaymentHistory().getWeeksDelinquentInLastYear();
    }

}
