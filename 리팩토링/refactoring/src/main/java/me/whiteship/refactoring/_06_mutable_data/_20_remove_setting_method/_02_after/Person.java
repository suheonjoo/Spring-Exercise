package me.whiteship.refactoring._06_mutable_data._20_remove_setting_method._02_after;

public class Person {

    private String name;

    /**
     * person 을 보면 id 는 바뀌어 하고 싶지 않은 값임 그래서 차라리 setter 보다는 생성자를 통해서 설정하는게 좋음
     */
    private int id;

    public Person(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
