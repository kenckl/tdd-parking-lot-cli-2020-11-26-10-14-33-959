package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public ParkingLot getAvailableParkinglot() throws NotEnoughPositionException {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.getMapSize() != parkingLot.getParkingLotCapacity())
                .max(Comparator.comparing(ParkingLot::getRate))
                .orElseThrow(() -> new NotEnoughPositionException());
    }

}
