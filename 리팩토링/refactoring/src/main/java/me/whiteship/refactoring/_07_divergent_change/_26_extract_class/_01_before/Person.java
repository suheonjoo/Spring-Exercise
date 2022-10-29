package me.whiteship.refactoring._07_divergent_change._26_extract_class._01_before;

public class Person {

    private String name;

    private String officeAreaCode;

    private String officeNumber;

    /**
     * 지금 보면 위에 2개 필드 조함해서 사용하는 메서드가 아래에 있음 -> 따로 클래스로 분리하고 싶음 ㅎ
     * @return
     */
    public String telephoneNumber() {
        return this.officeAreaCode + " " + this.officeNumber;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String officeAreaCode() {
        return officeAreaCode;
    }

    public void setOfficeAreaCode(String officeAreaCode) {
        this.officeAreaCode = officeAreaCode;
    }

    public String officeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}
