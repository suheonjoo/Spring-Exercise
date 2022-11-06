package me.whiteship.refactoring._16_temporary_field._36_introduce_special_case._02_after;

public class Site {

    private Customer customer;

    /**
     * Site 에서 unknown 판단 로직을 넣어줌
     * @param customer
     */
    public Site(Customer customer) {
        this.customer = customer.getName().equals("unknown") ? new UnknownCustomer() : customer ;
    }

    public Customer getCustomer() {
        return customer;
    }
}
