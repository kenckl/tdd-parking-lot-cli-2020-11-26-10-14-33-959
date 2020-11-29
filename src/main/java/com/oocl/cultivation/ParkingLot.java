package com.oocl.cultivation;

import com.oocl.cultivation.NotEnoughPositionException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity;
    private Map<Ticket, Car> ticketCarMapping;

    public ParkingLot(){
        this(10);
    }

    public ParkingLot(int Capacity){
        this.capacity = capacity;
        ticketCarMapping = new HashMap<>();
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        ticketCarMapping.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        if (!ticketCarMapping.containsKey(ticket)){
            throw new UnrecognizedParkingTicketException();
        }

        Car parkedCar = ticketCarMapping.get(ticket);
        ticketCarMapping.remove(ticket);
        return parkedCar;

    }

    public boolean isNoCapacity(){
        return ticketCarMapping.size() >= capacity;
    }

    public Map<Ticket, Car> getTicketCarMapping(){
        return ticketCarMapping;
    }

    public int getMapping(){
        return ticketCarMapping.size();
    }

    public int getParkingLotCapacity(){
        return capacity;
    }

    public int getRemainingCapacity(){
        return capacity - ticketCarMapping.size();
    }
}
