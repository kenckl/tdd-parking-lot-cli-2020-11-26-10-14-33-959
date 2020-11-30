package com.oocl.cultivation;


import java.util.List;

public class ParkingBoy {

    public List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) throws NotEnoughPositionException {
        ParkingLot parkingLot = getAvailableParkinglot();
        return parkingLot.park(car);
    }

    //todo place in parking lot class
    public ParkingLot getAvailableParkinglot() throws NotEnoughPositionException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getTicketCarMapping().size() != parkingLot.getParkingLotCapacity()) {
                return parkingLot;
            }
        }
        return null;
    }

    public void setParkingLots(List<ParkingLot> parkingLotList) {
        this.parkingLots = parkingLotList;
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicketException {
        Car actualCar = new Car();
        if (checkValidTicket(ticket)) {
            for (ParkingLot parkingLot : parkingLots) {
                actualCar = parkingLot.fetch(ticket);
            }
            return actualCar;
        }
        throw new UnrecognizedParkingTicketException();

    }

    // todo place in parking lot class
    public boolean checkValidTicket(Ticket ticket) throws UnrecognizedParkingTicketException {
        if (ticket == null) {
            throw new UnrecognizedParkingTicketException();
        }
        return parkingLots.stream().anyMatch(parkingLots ->
                parkingLots.getTicketCarMapping().containsKey(ticket));
    }

}
