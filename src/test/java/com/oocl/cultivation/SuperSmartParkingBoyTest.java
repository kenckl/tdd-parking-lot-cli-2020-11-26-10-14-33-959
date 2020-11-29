package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class SuperSmartParkingBoyTest {

    @Test
    public void should_return_a_parking_ticket_when_parking_given_car() throws NotEnoughPositionException {
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
        parkingLot.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot);

        //WHEN
        Ticket ticket = superSmartParkingBoy.parkCar(car);

        //THEN
        assertNotNull(ticket);
    }

    @Test
    public void should_return_a_car_when_fetching_given_a_valid_parking_ticket() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
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
    public void should_return_correct_car_when_fetching_given_multiple_tickets() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
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


    @Test
    public void should_return_UnrecognizedParkingTicketException_when_fetching_given_reused_ticket() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
        SuperSmartParkingBoy superSmartParkingBoy= new SuperSmartParkingBoy(parkingLot);
        parkingLot.add(new ParkingLot());
        Ticket ticket = superSmartParkingBoy.parkCar(car);
        superSmartParkingBoy.fetchCar(ticket);

        //WHEN
        UnrecognizedParkingTicketException exception = assertThrows(UnrecognizedParkingTicketException.class,
                ()->{superSmartParkingBoy.fetchCar(ticket); });

        //THEN
        assertSame("Unrecognized Parking Ticket", exception);

    }

    @Test
    public void should_return_NotEnoughPositionException_when_parking_given_car_and_parking_lot_full_capacity() throws NotEnoughPositionException {
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        List<ParkingLot> parkingLot = new ArrayList<>();
        SuperSmartParkingBoy superSmartParkingBoy= new SuperSmartParkingBoy(parkingLot);
        parkingLot.add(new ParkingLot());
        superSmartParkingBoy.parkCar(car1);

        //WHEN
        NotEnoughPositionException exception = assertThrows(NotEnoughPositionException.class,
                ()->{superSmartParkingBoy.parkCar(car2); });

        //THEN
        assertSame("Not Enough Position", exception);
    }

    @Test
    public void should_return_ticket_from_parking_lot2_when_parking_given_lot2_has_more_space_ratio() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(3);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy= new SuperSmartParkingBoy(parkingLotList);

        //WHEN
        superSmartParkingBoy.parkCar(car1);
        Ticket ticket2 = superSmartParkingBoy.parkCar(car2);


        //THEN
        assertNotNull(ticket2);
        assertEquals(car2, parkingLot2.fetch(ticket2));
    }


}
