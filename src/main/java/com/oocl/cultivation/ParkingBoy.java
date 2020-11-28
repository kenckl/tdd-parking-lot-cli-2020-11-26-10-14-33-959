package com.oocl.cultivation;

import java.util.List;
import java.util.ArrayList;

public class ParkingBoy {

    private List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLots = new ArrayList<>();
        this.parkingLots.add(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) throws NotEnoughPositionException{
        ParkingLot parkingLot = getParkinglot();
        return this.parkingLots.park(car);
    }

    public ParkingLot getParkinglot() throws NotEnoughPositionException {
        for (ParkingLot parkingLot: parkingLots){
            if(!parkingLot.isNoCapacity()){
                return parkingLot;
            }
        }
        throw new NotEnoughPositionException();
    }

    public void setParkingLots(List<ParkingLot> parkingLotList){
        this.parkingLots = parkingLotList;
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicketException{
        Car actualCar = new Car();
        if (checkValidTicket(ticket)){
            for (ParkingLot parkingLot : parkingLots){
                actualCar = parkingLot.fetch(ticket);
            }
            return actualCar;
        } else {
            throw new UnrecognizedParkingTicketException();
        }
    }

    public boolean checkValidTicket(Ticket ticket){
        if (ticket == null){
            throw new UnrecognizedParkingTicketException();
        }
        return parkingLots.stream().anyMatch(parkingLots ->
                parkingLots.getMapping().containsKey(ticket));
    }

    public List<ParkingLot> getParkingLots(){
        return parkingLots;
    }
}
