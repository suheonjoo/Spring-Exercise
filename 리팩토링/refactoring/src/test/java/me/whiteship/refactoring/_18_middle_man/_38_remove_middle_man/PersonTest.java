package me.whiteship.refactoring._18_middle_man._38_remove_middle_man;

import me.whiteship.refactoring._18_middle_man._38_remove_middle_man._01_before.Department;
import me.whiteship.refactoring._18_middle_man._38_remove_middle_man._01_before.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getManager() {
        Person nick = new Person("nick", null);
        Person keesun = new Person("keesun", new Department(nick));
        assertEquals(nick, keesun.getManager());
    }

}