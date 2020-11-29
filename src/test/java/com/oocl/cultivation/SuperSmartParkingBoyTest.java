package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class SuperSmartParkingBoyTest {

    @Test
    public void should_return_a_parking_ticket_when_parking_given_car(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
        parkingLot.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();

        //WHEN
        Ticket ticket = superSmartParkingBoy.parkCar(car);

        //THEN
        assertNotNull(ticket);
    }

    @Test
    public void should_return_a_car_when_fetching_given_a_valid_parking_ticket() {
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
        SuperSmartParkingBoy superSmartParkingBoy= new SuperSmartParkingBoy(parkingLot);
        parkingLot.add(new ParkingLot());
        Ticket ticket = superSmartParkingBoy.parkCar(car);

        //WHEN
        Car fetchedCar = superSmartParkingBoy.fetchCar(ticket);

        //THEN
        assertSame(car, fetchedCar);
    }

    @Test
    public void should_return_correct_car_when_fetching_given_multiple_tickets(){
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
        SuperSmartParkingBoy superSmartParkingBoy= new SuperSmartParkingBoy(parkingLot);
        Ticket ticket1 = superSmartParkingBoy.parkCar(car1);
        Ticket ticket2 = superSmartParkingBoy.parkCar(car2);

        //WHEN
        Car actualCar1 = superSmartParkingBoy.fetchCar(ticket1);
        Car actualCar2 = superSmartParkingBoy.fetchCar(ticket2);
        
        //THEN
        assertSame(car1, actualCar1);
        assertSame(car2, actualCar2);
    }


}
