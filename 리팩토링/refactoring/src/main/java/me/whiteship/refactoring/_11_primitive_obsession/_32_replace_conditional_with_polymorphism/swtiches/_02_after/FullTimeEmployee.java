package me.whiteship.refactoring._11_primitive_obsession._32_replace_conditional_with_polymorphism.swtiches._02_after;

import java.util.List;

public class FullTimeEmployee extends Employee{

    public FullTimeEmployee(List<String> availableProjects) {
        super(availableProjects);
    }

    @Override
    public int vacationHours() {
        return 120;
    }
}
