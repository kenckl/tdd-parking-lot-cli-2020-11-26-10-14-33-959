package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final Map<Ticket, Car> ticketCarMapping = new HashMap<>();

    public Ticket park(Car car){
        Ticket ticket = new Ticket();
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car car = ticketCarMapping.get(ticket);
        ticketCarMapping.remove(ticket);
        return car;
    }
}
