package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    void should_return_parking_ticket_when_parking_given_parking_boy_park() throws NotEnoughPositionException{
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //WHEN
        Ticket ticket = parkingBoy.parkCar(car);

        //THEN
        assertNotNull(ticket);
    }

    @Test
    void should_return_correct_car_when_fetch_car_given_parking_ticket() throws NotEnoughPositionException, UnrecognizedParkingTicketException{
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.parkCar(car);

        //WHEN
        Car actualCar = parkingBoy.fetchCar(ticket);

        //THEN
        assertSame(car,actualCar);
    }

    @Test
    void should_return_multiple_tickets_when_parking_multiple_cars_given_parking_lot_with_multiple_capacity() throws NotEnoughPositionException{
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
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
        List<ParkingLot> parkingLot = new ArrayList<>();
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
        List<ParkingLot> parkingLot = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //WHEN
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Ticket ticket2 = parkingBoy.parkCar(car2);

        //THEN
        assertNotNull(ticket1);
        assertNotNull(ticket2);
    }

    @Test
    void should_return_UnrecognizedParkingTicketException_when_fetching_given_parking_lot_invalid_ticket() throws UnrecognizedParkingTicketException, NotEnoughPositionException{
        //GIVEN
        List<ParkingLot> parkingLot = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.parkCar(car);

        //WHEN
        UnrecognizedParkingTicketException unrecognizedTicket = assertThrows(UnrecognizedParkingTicketException.class, () -> {
            Car actualCar = parkingBoy.fetchCar(ticket);
        });

        //THEN
        assertEquals("Unrecognized Parking Target", unrecognizedTicket.getLocalizedMessage());
    }

    @Test
    void should_return_NotEnoughPostionExceptionn_when_parking_given_full_capacity() throws NotEnoughPositionException{
        //GIVEN
        List<ParkingLot> parkingLot = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //WHEN + THEN
        assertThrows(NotEnoughPositionException.class, () -> {
            parkingBoy.parkCar(car);
        }, "Not Enough Position");

    }

    @Test
    void should_park_first_parking_lot_return_car_ticket_when_park_two_cars_given_both_lots_have_capacity() throws NotEnoughPositionException{
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        //when
        parkingBoy.parkCar(car1);
        parkingBoy.parkCar(car2);
        Ticket ticket = parkingBoy.parkCar(car1);

        //then
        assertEquals(0,parkingLot1.getAvailableSpace());
        assertEquals(1,parkingLot2.getAvailableSpace());
        assertNotNull(ticket);
    }
}
