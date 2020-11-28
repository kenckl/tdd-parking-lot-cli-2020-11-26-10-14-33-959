package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity;
    private final Map<Ticket, Car> ticketCarMapping = new HashMap<>();

    public ParkingLot(){
        capacity = 10;
    }

    public ParkingLot(int Capacity){
        this.capacity = capacity;
    }

    public int getCapacity(){
        return capacity;
    }

    public Ticket park(Car car){
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
        return capacity == ticketCarMapping.size();
    }
}
