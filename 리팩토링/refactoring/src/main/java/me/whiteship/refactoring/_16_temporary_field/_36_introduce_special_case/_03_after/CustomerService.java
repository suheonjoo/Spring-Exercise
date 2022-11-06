package me.whiteship.refactoring._16_temporary_field._36_introduce_special_case._03_after;

public class CustomerService {

    public String customerName(Site site) {
        /**
         * 이미 site 의 .getCustomer().getName() 를 통해 customer 가 unknown 인 것 알려주도록 리팩토링해서 아래 주석과 같은 로직이 필요 없음
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
        /**
         * 이것도 이미 site 의 .getCustomer().getBillingPlan() 를 통해서 customer 의 Billing plane을 가져 올수 있음
         *
         * UnknownCustomer 클래스 생성자에서 new BillingPlan 을 넣어 줘서 가능한 거 ㅋ
         */
        return site.getCustomer().getBillingPlan();

//        Customer customer = site.getCustomer();
//        return customer.isUnknown() ? new BasicBillingPlan() : customer.getBillingPlan();

    }

    public int weeksDelinquent(Site site) {

        /**
         * 여기에 null object 패턴 적용함 ******************* 여기 중요함 코드가 엄청 까끔해짐
         *
         * NullPaymentHistory 를 만들고 UnknownCustomer 클래스 생성자에서 PaymentHistory 자리에 해당 클래스를 넣어줘서 해당 패터을 만듦
         */
        //return customer.isUnknown() ? 0 : customer.getPaymentHistory().getWeeksDelinquentInLastYear();
        return site.getCustomer().getPaymentHistory().getWeeksDelinquentInLastYear();
    }

}
