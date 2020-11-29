package com.oocl.cultivation;


import java.util.List;
import java.util.ArrayList;
import com.oocl.cultivation.UnrecognizedParkingTicketException;

public class ParkingBoy {

    public List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car){
        ParkingLot parkingLot = getParkinglot();
        return parkingLot.park(car);
    }

    public ParkingLot getParkinglot() {
        for (ParkingLot parkingLot: parkingLots){
            if(parkingLot.getTicketCarMapping().size()!=parkingLot.getParkingLotCapacity()){
                return parkingLot;
            }
        }
        return null;
    }

    public void setParkingLots(List<ParkingLot> parkingLotList){
        this.parkingLots = parkingLotList;
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicketException {
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

    public boolean checkValidTicket(Ticket ticket) throws UnrecognizedParkingTicketException {
        if (ticket == null){
            throw new UnrecognizedParkingTicketException();
        }
        return parkingLots.stream().anyMatch(parkingLots ->
                parkingLots.getTicketCarMapping().containsKey(ticket));
    }

}
