package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    void should_return_parking_ticket_when_parking_given_parking_boy_park() {
        //GIVEN
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //WHEN
        Ticket ticket = parkingBoy.park(car);

        //THEN
        assertNotNull(ticket);
    }
}
