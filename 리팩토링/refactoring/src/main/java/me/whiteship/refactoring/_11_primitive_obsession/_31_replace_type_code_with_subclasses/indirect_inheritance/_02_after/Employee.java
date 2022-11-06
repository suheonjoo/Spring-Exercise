package me.whiteship.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.indirect_inheritance._02_after;

public class Employee {

    private String name;

    /**
     * 여기에 EmployeeType 을 만들어서 Manager, Engineer, Salesman 이 상속함
     */
    private EmployeeType type;

    public Employee(String name, String typeValue) {
        this.name = name;
        this.type = this.employeeType(typeValue);
    }

    private EmployeeType employeeType(String typeValue) {

        return switch (typeValue) {
            case "engineer" -> new Engineer();
            case "manager" -> new Manager();
            case "salesman" -> new Salesman();
            default -> throw new IllegalArgumentException(typeValue);
        };

    }


    public String capitalizedType() {
        return this.type.capitalizedType();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
