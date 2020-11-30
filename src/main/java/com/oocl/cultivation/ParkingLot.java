package com.oocl.cultivation;

import com.oocl.cultivation.NotEnoughPositionException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity = 10;
    private Map<Ticket, Car> ticketCarMapping;

    public ParkingLot(){ }

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
        Car parkedCar = ticketCarMapping.get(ticket);
        ticketCarMapping.remove(ticket);
        return parkedCar;

    }

    public Map<Ticket, Car> getTicketCarMapping(){
        return ticketCarMapping;
    }

    public int getMapSize(){
        return ticketCarMapping.size();
    }

    public int getParkingLotCapacity(){
        return capacity;
    }

    // float or double also ok
    // remove emptySpace variable
    public float getRate(){
        float emptySpace = getRemainingCapacity();
        return emptySpace/capacity;
    }

    public int getRemainingCapacity(){
        return capacity - ticketCarMapping.size();
    }
}
