package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager extends ParkingBoy{
    private List<ParkingBoy> manageList = new ArrayList<>();

    public ParkingLotServiceManager(List<ParkingLot> parkingLotList){
        super(parkingLotList);
    }
}