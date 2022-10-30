package me.whiteship.refactoring._11_primitive_obsession._32_replace_conditional_with_polymorphism.swtiches._01_before;

import java.util.List;


public class Employee {

    /**
     * 타입에 따라 로직이 달라니지는 클래스 임
     */
    private String type;

    private List<String> availableProjects;

    public Employee(String type, List<String> availableProjects) {
        this.type = type;
        this.availableProjects = availableProjects;
    }

    public int vacationHours() {
        return switch (type) {
            case "full-time" -> 120;
            case "part-time" -> 80;
            case "temporal" -> 32;
            default -> 0;
        };
    }

    public boolean canAccessTo(String project) {
        return switch (type) {
            case "full-time" -> true;
            case "part-time", "temporal" -> this.availableProjects.contains(project);
            default -> false;
        };
    }
}
