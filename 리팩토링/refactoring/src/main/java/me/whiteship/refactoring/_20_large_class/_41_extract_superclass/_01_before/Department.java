package me.whiteship.refactoring._20_large_class._41_extract_superclass._01_before;

import java.util.List;

/**
 * Department 와 Employee 를 보면 공통으로 사용되는 필드, 메서드들이 보임 이걸 따로 뺄것임 이때 위임 또는 상속을 고려해야 겠지!
 */
public class Department {

    private String name;

    private List<Employee> staff;

    public String getName() {
        return name;
    }

    public List<Employee> getStaff() {
        return staff;
    }

    public double totalMonthlyCost() {
        return this.staff.stream().mapToDouble(e -> e.getMonthlyCost()).sum();
    }

    public double totalAnnualCost() {
        return this.totalMonthlyCost() * 12;
    }

    public int headCount() {
        return this.staff.size();
    }
}
