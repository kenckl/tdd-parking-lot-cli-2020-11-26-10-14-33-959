package com.oocl.cultivation;
import com.oocl.cultivation.NotEnoughPositionException;

public class ParkingBoy {

    ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public Ticket parkCar(Car car) throws NotEnoughPositionException{
        return parkingLot.park(car);
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicketException{
        return parkingLot.fetch(ticket);
    }
}
