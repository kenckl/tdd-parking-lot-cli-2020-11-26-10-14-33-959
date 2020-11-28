package com.oocl.cultivation;
import com.oocl.cultivation.NotEnoughPositionException;

public class ParkingBoy {

    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public Ticket parkCar(Car car) throws NotEnoughPositionException{
        return this.parkingLot.park(car);
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicketException{
        return this.parkingLot.fetch(ticket);
    }
}
