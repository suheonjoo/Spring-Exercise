package me.whiteship.refactoring._22_data_class._42_encapsulate_record._01_before;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationTest {

    @Test
    void name() {
        Organization organization = new Organization();
        organization.name = "kesun";
    }


}