package me.whiteship.refactoring._20_large_class._41_extract_superclass._02_after;

import java.util.List;

public class Department extends Party{


    private List<Employee> staff;

    public Department(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public List<Employee> getStaff() {
        return staff;
    }

    @Override
    public double monthlyCost() {
        return this.staff.stream().mapToDouble(e -> e.annualCost()).sum();
    }

    public int headCount() {
        return this.staff.size();
    }
}
