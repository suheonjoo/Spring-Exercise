package me.whiteship.refactoring._06_mutable_data._19_separate_query_from_modifier;

import me.whiteship.refactoring._06_mutable_data._19_separate_query_from_modifier._01_before.Billing;
import me.whiteship.refactoring._06_mutable_data._19_separate_query_from_modifier._01_before.Customer;
import me.whiteship.refactoring._06_mutable_data._19_separate_query_from_modifier._01_before.EmailGateway;
import me.whiteship.refactoring._06_mutable_data._19_separate_query_from_modifier._01_before.Invoice;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BillingTest {

    @Test
    void totalOutstanding() {
        /**
         *  리팩토링 후 여기서 값만 조회하지 sendbill 을 날리지 않음
         */
        Billing billing = new Billing(new Customer("keesun", List.of(new Invoice(20), new Invoice(30))),
                new EmailGateway());
        assertEquals(50d, billing.getTotalOutstandingAndSendBill());
    }

}