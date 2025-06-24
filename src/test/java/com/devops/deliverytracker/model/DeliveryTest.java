
package com.devops.deliverytracker.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeliveryTest {

    @Test
    public void testGetDelayDays_PositiveDelay() {
        Delivery d = new Delivery(1L, "PKG001", "Rahul", 3, 5);
        assertEquals(2, d.getDelayDays());
    }

    @Test
    public void testGetDelayDays_NoDelay() {
        Delivery d = new Delivery(2L, "PKG002", "Arjun", 4, 4);
        assertEquals(0, d.getDelayDays());
    }

    @Test
    public void testGetDelayDays_EarlyDelivery() {
        Delivery d = new Delivery(3L, "PKG003", "Meera", 6, 4);
        assertEquals(-2, d.getDelayDays());  // Delivered 2 days early
    }
}
