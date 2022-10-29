package me.whiteship.refactoring._06_mutable_data._23_change_reference_to_value._02_after;

import me.whiteship.refactoring._06_mutable_data._23_change_reference_to_value._02_after.notUseRecord.TelephoneNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneNumberTest {

    @Test
    void testEquals() {
        TelephoneNumber telephoneNumber1 = new TelephoneNumber("123", "1234");
        TelephoneNumber telephoneNumber2 = new TelephoneNumber("123", "1234");
        assertEquals(telephoneNumber1,telephoneNumber2);
    }

}