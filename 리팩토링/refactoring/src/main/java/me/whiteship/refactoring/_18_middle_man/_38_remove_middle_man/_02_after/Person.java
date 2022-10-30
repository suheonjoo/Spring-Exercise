package me.whiteship.refactoring._18_middle_man._38_remove_middle_man._02_after;

public class Person {

    private Department department;

    private String name;

    public Person(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Person getManager() {
        return this.department.getManager();
    }

    /**
     * 여기서 department 접근을 허용해 줌
     * @return
     */
    public Department getDepartment() {
        return department;
    }
}
