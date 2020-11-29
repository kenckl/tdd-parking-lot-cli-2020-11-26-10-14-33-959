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
}
