package me.whiteship.refactoring._06_mutable_data._20_remove_setting_method;

import me.whiteship.refactoring._06_mutable_data._20_remove_setting_method._02_after.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    /**
     * person 을 보면 id 는 바뀌어 하고 싶지 않은 값임 그래서 차라리 setter 보다는 생성자를 통해서 설정하는게 좋음
     */
    @Test
    void person() {
        Person person = new Person(10);
        //person.setId(10);

        person.setName("keesun");
        assertEquals(10, person.getId());
        assertEquals("keesun", person.getName());
        person.setName("whiteship");
        assertEquals("whiteship", person.getName());
    }

}