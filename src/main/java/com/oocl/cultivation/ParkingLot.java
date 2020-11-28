package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity = 10;
    private final Map<Ticket, Car> ticketCarMapping = new HashMap<>();

    public ParkingLot(){ }

    public ParkingLot(int maxCapacity){
        this.capacity = maxCapacity;
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
}
