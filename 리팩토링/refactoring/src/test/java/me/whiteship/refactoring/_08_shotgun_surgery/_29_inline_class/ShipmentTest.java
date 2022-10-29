package me.whiteship.refactoring._08_shotgun_surgery._29_inline_class;

import me.whiteship.refactoring._08_shotgun_surgery._29_inline_class._01_before.Shipment;
import me.whiteship.refactoring._08_shotgun_surgery._29_inline_class._01_before.TrackingInformation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipmentTest {

    @Test
    void trackingInfo() {
        Shipment shipment = new Shipment(new TrackingInformation("UPS", "12345"));
        assertEquals("UPS: 12345", shipment.getTrackingInfo());
    }

}