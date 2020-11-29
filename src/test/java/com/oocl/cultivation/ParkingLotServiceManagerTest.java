package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotServiceManagerTest {
    Car car = new Car();
    private List<ParkingLot> parkingLotForParkingBoy = new ArrayList<>();
    private List<ParkingLot> parkingLotForSmartParkingBoy = new ArrayList<>();
    private List<ParkingLot> parkingLotForSuperSmartPackingBoy = new ArrayList<>();
    private List<ParkingLot> parkingLotManager = new ArrayList<>();
    ParkingBoy parkingBoy = new ParkingBoy(parkingLotForParkingBoy);
    ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotForSmartParkingBoy);
    ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotForSuperSmartPackingBoy);
    ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingLotManager);

    @Test
    void should_return_manageList_when_adding_parking_boys_given_manageList(){
        //GIVEN
        parkingLotForParkingBoy.add(new ParkingLot());
        parkingLotForSmartParkingBoy.add(new ParkingLot());
        parkingLotForSuperSmartPackingBoy.add(new ParkingLot());
        parkingLotManager.add(new ParkingLot());
        List<ParkingBoy> parkingBoyList = Arrays.asList(parkingBoy, smartParkingBoy, superSmartParkingBoy);
        parkingLotServiceManager.setManageList(parkingBoyList);

        //WHEN
        List<ParkingBoy> getManageList = parkingLotServiceManager.getManageList();

        //THEN
        assertNotNull(getManageList);
    }

    @Test
    void should_return_ticket_when_giving_command_given_parking_boy_manage(){
        //GIVEN
        parkingLotForParkingBoy.add(new ParkingLot());
        parkingLotForSmartParkingBoy.add(new ParkingLot());
        parkingLotForSuperSmartPackingBoy.add(new ParkingLot());
        List<ParkingBoy> parkingBoyList = Arrays.asList(parkingBoy, smartParkingBoy, superSmartParkingBoy);
        parkingLotServiceManager.setManageList(parkingBoyList);

        //WHEN
        Ticket ticket = parkingLotServiceManager.parkingCommand(parkingBoy,car);

        //THEN
        assertNotNull(ticket);
    }
}
