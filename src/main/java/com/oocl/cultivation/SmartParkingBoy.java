package com.oocl.cultivation;

import com.oocl.cultivation.NotEnoughPositionException;
import java.util.Comparator;
import java.util.List;


public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLotList){
        super(parkingLotList);
    }

    @Override
    public ParkingLot getParkinglot() {
        return  parkingLots.stream()
                .filter(parkingLot -> parkingLot.getMapSize()!=parkingLot.getParkingLotCapacity())
                .max(Comparator.comparing(ParkingLot::getRemainingCapacity))
                .orElseThrow(() -> new NotEnoughPositionException());
}

