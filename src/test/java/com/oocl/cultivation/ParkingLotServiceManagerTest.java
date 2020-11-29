package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotServiceManagerTest {
    Car car = new Car();
    private List<ParkingLot> parkingLot1 = new ArrayList<>();
    private List<ParkingLot> parkingLot2 = new ArrayList<>();
    private List<ParkingLot> parkingLot3 = new ArrayList<>();
    ParkingBoy parkingBoy = new ParkingBoy(parkingLot1);
    ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot2);
    ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot3);
    ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();

    @Test
    void should_return_manageList_when_adding_parking_boys_given_manageList(){
        //GIVEN
        parkingLot1.add(new ParkingLot());
        parkingLot2.add(new ParkingLot());
        parkingLot3.add(new ParkingLot());
        List<ParkingBoy> parkingBoyList = Arrays.asList(parkingBoy,smartParkingBoy,superSmartParkingBoy);
        parkingLotServiceManagerManager.setManageList(parkingBoy);

        //WHEN
        List<ParkingBoy> getManageList = parkingManager.getManageList();

        //THEN
        assertNotNull(getManageList);
    }
}

