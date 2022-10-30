package me.whiteship.refactoring._16_temporary_field._36_introduce_special_case._02_after;

public class Site {

    private Customer customer;

    public Site(Customer customer) {
        this.customer = customer.getName().equals("unknown") ? new UnknownCustomer() : customer ;
    }

    public Customer getCustomer() {
        return customer;
    }
}
