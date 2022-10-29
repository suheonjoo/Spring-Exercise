package me.whiteship.refactoring._06_mutable_data._19_separate_query_from_modifier;

import me.whiteship.refactoring._06_mutable_data._19_separate_query_from_modifier._02_after.Criminal;
import me.whiteship.refactoring._06_mutable_data._19_separate_query_from_modifier._02_after.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CriminalTest {

    /**
     * 테스트 코드에서 보면 어디서 알람 메세지 출력이 되었는건지 알기 어려움
     * 질의와 변경이 한번에 함쳐져서 발생하는 문제임
     */
    @Test
    void alertForMiscreant() {
        Criminal criminal = new Criminal();
        //String found = criminal.alertForMiscreant(List.of(new Person("Keesun"), new Person("Don")));
        String found = criminal.findMiscreant(List.of(new Person("Keesun"), new Person("Don")));
        assertEquals("Don", found);

//        found = criminal.alertForMiscreant(List.of(new Person("John"), new Person("Don")));
        found = criminal.findMiscreant(List.of(new Person("John"), new Person("Don")));
        assertEquals("John", found);
    }

}