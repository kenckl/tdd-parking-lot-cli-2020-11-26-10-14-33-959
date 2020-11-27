package com.oocl.cultivation;

public class ParkingBoy {

    ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car){
        return parkingLot.park(car);
    }

    public Car fetchCar(Ticket ticket){
        return null;
    }
}
