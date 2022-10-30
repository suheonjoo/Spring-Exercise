package me.whiteship.refactoring._11_primitive_obsession._30_replace_primitive_with_object;

import me.whiteship.refactoring._11_primitive_obsession._30_replace_primitive_with_object._01_before.Order;
import me.whiteship.refactoring._11_primitive_obsession._30_replace_primitive_with_object._01_before.OrderProcessor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderProcessorTest {

    @Test
    void numberOfHighPriorityOrders() {
        OrderProcessor orderProcessor = new OrderProcessor();
        long highPriorityOrders = orderProcessor.numberOfHighPriorityOrders(
                List.of(new Order("low"),
                        new Order("normal"),
                        new Order("high"),
                        new Order("rush")));
        assertEquals(2, highPriorityOrders);
    }

}