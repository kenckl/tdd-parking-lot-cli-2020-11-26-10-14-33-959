package com.oocl.cultivation;

public class ParkingBoy {

    ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public Ticket parkCar(Car car){
        return parkingLot.park(car);
    }

    public Car fetchCar(Ticket ticket){
        return null;
    }
}
