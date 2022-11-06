package me.whiteship.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.direct_inheritance._02_after;

public abstract class Employee {

    private String name;

    protected Employee(String name) {
        this.name = name;
    }

    public static Employee createEmployee(String name, String type) {
        return switch (type) {
            case "engineer" -> new Engineer(name);
            case "manager" -> new Manager(name);
            case "salesman" -> new Salesman(name);
            default -> throw new IllegalArgumentException(type);
        };
        /**
         * 아래 switch 문을 "위"와 같이 대체할 수 있음
         */
//        switch (type) {
//            case "engineer":
//                return new Engineer(name, type);
//            case "manager":
//                return new Manager(name, type);
//            default:
//                return new Employee(name, type);
//        }

    }

    protected abstract String getType();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", type='" + getType() + '\'' +
                '}';
    }
}
