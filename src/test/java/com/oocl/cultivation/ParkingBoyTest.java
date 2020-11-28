package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    void should_return_parking_ticket_when_parking_given_parking_boy_park() throws NotEnoughPositionException{
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
    void should_return_correct_car_when_fetch_car_given_parking_ticket() throws NotEnoughPositionException{
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
    void should_return_multiple_tickets_when_parking_multiple_cars_given_parking_lot_with_multiple_capacity() throws NotEnoughPositionException{
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //WHEN
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Ticket ticket2 = parkingBoy.parkCar(car2);

        //THEN
        assertNotNull(ticket1);
        assertNotNull(ticket2);
    }

    @Test
    void should_return_UnrecognizedParkingTicketException_when_fetch_car_given_parking_lot_car_reused_ticket() throws UnrecognizedParkingTicketException, NotEnoughPositionException{
        //GIVEN
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.parkCar(car);

        //WHEN
        UnrecognizedParkingTicketException unrecognizedTicket = assertThrows(UnrecognizedParkingTicketException.class, () -> {
            Car actualCar = parkingBoy.fetchCar(ticket);
        });

        //THEN
        assertEquals("Unrecognized Parking Ticket", unrecognizedTicket.getLocalizedMessage());
    }

    @Test
    void should_return_only_one_ticket_when_parking_multiple_cars_given_parking_lot_with_one_capacity() throws NotEnoughPositionException{
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //WHEN
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Ticket ticket2 = parkingBoy.parkCar(car2);

        //THEN
        assertNotNull(ticket1);
        assertNotNull(ticket2);
    }

    @Test
    void should_return_null_when_fetching_given_parking_ticket_not_parked_in_parking_lot() throws NotEnoughPositionException{
        //GIVEN
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = new Ticket();

        //WHEN
        Car car = parkingBoy.fetchCar(ticket);

        //THEN
        assertNull(car);
    }

    @Test
    void should_return_NotEnoughPostionExceptionn_when_parking_given_full_capacity() throws NotEnoughPositionException{
        //GIVEN
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //WHEN + THEN
        assertThrows(NotEnoughPositionException.class, () -> {
            parkingBoy.parkCar(car);
        }, "Not Enough Position");

    }
}
