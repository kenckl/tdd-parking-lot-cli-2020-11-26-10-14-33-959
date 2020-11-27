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
        Ticket ticket = parkingBoy.parkCar(car);

        //THEN
        assertNotNull(ticket);
    }

    @Test
    void should_return_correct_car_when_fetch_car_given_parking_ticket() {
        //GIVEN
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.parkCar(car);

        //WHEN
        Car actualCar = parkingBoy.fetchCar(ticket);

        //THEN
        assertEquals(car, actualCar);
    }

    @Test
    void should_return_multiple_cars_when_parking_multiple_cars_given_parking_lot_with_multiple_capacity() {
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(10);

        //WHEN
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        //THEN
        assertNotNull(ticket1);
        assertNotNull(ticket2);
    }

    

}
