package com.oocl.cultivation;

import com.oocl.cultivation.NotEnoughPositionException;
import java.util.List;
import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy{
    private List<ParkingLot> parkingLotList;
    public SmartParkingBoy(List<ParkingLot> parkingLot){
        super(parkingLot);
    }


    public void setParkingLot(List<ParkingLot> parkingLots){
        this.parkingLotList = parkingLots;
    }

    public Ticket park(Car car){
        ParkingLot lot= getParkinglot(super.getParkingLots());
        return lot.park(car);
    }

    public ParkingLot getParkinglot(List<ParkingLot> parkingLotList) {
        return  parkingLotList.stream().max(Comparator.comparing(ParkingLot::getEmpty))
                .filter(c -> c.getTickatCarMapSize()!=c.getCapacity())
                .orElseThrow(() -> new FullParkingException("Not enough position."));
}

