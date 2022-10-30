package me.whiteship.refactoring._22_data_class._42_encapsulate_record._02_after;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationTest {

    @Test
    void name() {
        Organization organization = new Organization("suhoen", "USA");
//        organization.name = "kesun";// record로 된것은 변경 불가임

    }


}