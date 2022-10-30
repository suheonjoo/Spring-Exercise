package me.whiteship.refactoring._11_primitive_obsession._30_replace_primitive_with_object._02_after;

public class Order {

    private Priority  priority;

    public Order(String value) {
        this(new Priority(value));
    }

    public Order(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }
}
