package me.whiteship.refactoring._17_message_chain._37_hide_delegate._01_before;

public class Person {

    private String name;

    private Department department;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * 이거 테스트 코드에서 getManger 메서드 뽑아 내고, person 클래스로 메서드를 옮긴 것임!!!
     * (move instance method)
     * 만약에 여기서 manager 필드가 생기면 클라이언트 코드는 변결할 필요 없이, 여기 클래스 에서 내부 코드만 변경하면 됨!!!!
     *
     * @return
     */
    public Person getManager() {
        return getDepartment().getManager();
    }
}
