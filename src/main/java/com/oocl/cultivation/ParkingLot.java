package com.oocl.cultivation;

import com.oocl.cultivation.NotEnoughPositionException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity;
    private Map<Ticket, Car> ticketCarMapping;

    public ParkingLot(int Capacity){
        this.capacity = capacity;
        ticketCarMapping = new HashMap<>();
    }

    public Ticket park(Car car) throws NotEnoughPositionException{
        if (this.getAvailableSpace()<=0)
            throw new NotEnoughPositionException();
        Ticket ticket = new Ticket();
        ticketCarMapping.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        if (ticketCarMapping.containsKey(ticket)){
            Car car = ticketCarMapping.get(ticket);
            ticketCarMapping.remove(ticket);
            return car;
        }
        throw new UnrecognizedParkingTicketException();
    }


    public int getAvailableSpace(){
        return capacity - ticketCarMapping.size();
    }
}
