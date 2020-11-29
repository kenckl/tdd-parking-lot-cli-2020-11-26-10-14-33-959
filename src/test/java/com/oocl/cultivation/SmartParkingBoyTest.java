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

}
