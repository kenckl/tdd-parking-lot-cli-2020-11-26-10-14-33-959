package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList){
        super(parkingLotList);
    }

    @Override
    public ParkingLot getParkingLot(){
        return parkingLots.stream().max(Comparator.comparing(ParkingLot::getRate))
                .filter(c -> c.getMapSize() != c.getParkingLotCapacity())
                .orElseThrow(() -> new NotEnoughPositionException());
    }
    }
}
