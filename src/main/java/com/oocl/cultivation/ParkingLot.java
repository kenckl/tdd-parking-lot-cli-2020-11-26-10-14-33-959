package com.oocl.cultivation;

import com.oocl.cultivation.NotEnoughPositionException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity;
    private Map<Ticket, Car> ticketCarMapping;

    public ParkingLot(){
        capacity = 10;
    }

    public ParkingLot(int Capacity){
        this.capacity = capacity;
        ticketCarMapping = new HashMap<>();
    }

    public int getCapacity(){
        return capacity;
    }

    public Ticket park(Car car) throws NotEnoughPositionException{
        if (!hasCapacity())
            throw new NotEnoughPositionException();
        Ticket ticket = new Ticket();
        ticketCarMapping.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car car = ticketCarMapping.get(ticket);
        ticketCarMapping.remove(ticket);
        return car;
    }

    private boolean hasCapacity() {
        return ticketCarMapping.size() < capacity;
    }
}
