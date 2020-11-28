package com.oocl.cultivation;

import com.oocl.cultivation.NotEnoughPositionException;
import java.util.List;
import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy{
    private List<ParkingLot> parkingLotList;
    public SmartParkingBoy(ParkingLot parkingLot){
        super(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLotList){
        super(parkingLotList);
    }

    public void setParkingLot(List<ParkingLot> parkingLots){
        this.parkingLotList = parkingLots;
    }

    public ParkingLot getParkingLot(){
        return parkingLotList.stream().max(Comparator.comparing(ParkingLot::countEmpty))
                .orElseThrow(()->new NotEnoughPositionException());

    }
}
