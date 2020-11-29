package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoyTest {

    @Test
    public void should_return_parking_ticket_when_parking_given_car(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
        parkingLot.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new SmartParkingBoy(parkingLot);

        //WHEN
        Ticket ticket = parkingBoy.parkCar(car);

        //THEN
        assertNotNull(ticket);
    }

    @Test
    public void should_return_correct_car_when_fetching_given_correct_ticket(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
        parkingLot.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new SmartParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.park(car);

        //WHEN
        Car actualCar = parkingBoy.fetchCar(ticket);

        //THEN
        assertSame(actualCar, car);
    }

    public void should_park_in_lot1_and_return_car_ticket_when_parking_given_lot1_more_capacity_than_lot2(){_
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        parkingLot.add(parkingLot1);
        parkingLot.add(parkingLot2);
        smartParkingBoy.parkCar(car1);

        //WHEN
        smartParkingBoy.parkCar(car2);

        //THEN
        assertEquals(1, parkingLot2.getTicketCarMapping().size());
    }

    @Test
    public void should_return_correct_car_when_fetching_given_multiple_tickets(){
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
        parkingLot.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Ticket t1 = smartParkingBoy.park(car1);
        Ticket t2 = smartParkingBoy.park(car2);

        //WHEN
        Car actualCar1 = smartParkingBoy.fetchCar(t1);
        Car actualCar2 = smartParkingBoy.fetchCar(t2);

        //THEN
        assertSame(car1, actualCar1);
        assertSame(car2, actualCar2);
    }

    @Test
    public void should_return_exception_when_fetching_given_used_parking_ticket_to_parking_boy() {
        //GIVEN
        Car car1 = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        parkingLot.add(new ParkingLot());
        Ticket ticket = smartParkingBoy.park(car1);
        smartParkingBoy.fetchCar(ticket);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> {
                    smartParkingBoy.fetchCar(ticket);
                });
        //THEN
        assertSame("Unrecognized Parking Ticket.", exception);
    }

}
