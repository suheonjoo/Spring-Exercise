package me.whiteship.refactoring._17_message_chain._37_hide_delegate;

import me.whiteship.refactoring._17_message_chain._37_hide_delegate._01_before.Department;
import me.whiteship.refactoring._17_message_chain._37_hide_delegate._01_before.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void manager() {
        Person keesun = new Person("keesun");
        Person nick = new Person("nick");
        keesun.setDepartment(new Department("m365deploy", nick));

        Person manager = keesun.getDepartment().getManager();
        assertEquals(nick, manager);
    }

}