package com.oocl.cultivation;

import java.util.List;
import com.oocl.cultivation.NotEnoughPositionException;

public class ParkingBoy {

    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) throws NotEnoughPositionException{
        return this.parkingLots.park(car);
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicketException{
        return this.parkingLots.fetch(ticket);
    }
}
