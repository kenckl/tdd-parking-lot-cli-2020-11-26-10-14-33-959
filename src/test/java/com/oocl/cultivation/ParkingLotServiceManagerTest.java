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
    private List<ParkingLot> parkingLotList = new ArrayList<>();
    private List<ParkingBoy> parkingBoyList = new ArrayList<>();
    private ParkingBoy parkingBoy = new ParkingBoy(parkingLotForParkingBoy);
    private ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotForSmartParkingBoy);
    private ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotForSuperSmartPackingBoy);
    private ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingLotManager);

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
    void should_return_ticket_when_giving_command_given_parking_boy_manage() throws NotEnoughPositionException {
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

    @Test
    void should_return_UnrecognizedParkingTicketExcpetion_when_giving_command_to_fetch_car_given_invalid_ticket() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
        //GIVEN
        parkingLotList.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Ticket ticket = parkingBoy.parkCar(car);
        parkingBoy.fetchCar(ticket);
        parkingBoyList.add(parkingBoy);

        //WHEN

        //THEN
        UnrecognizedParkingTicketException exception = assertThrows(UnrecognizedParkingTicketException.class,
                ()->{parkingLotServiceManager.fetchingCommand(parkingBoy,ticket);});
        assertSame("Unrecognized Parking Ticket",exception);

    }

    @Test
    void should_return_NotEnoughPositionException_when_giving_commands_to_park_given_parking_lot_is_full_capacity() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        parkingLotList.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        parkingBoy.parkCar(car1);

        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        parkingLotServiceManager.setManagementList(parkingBoys);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()->{parkingLotServiceManager.parkingCommand(parkingBoy,car2); });
        //THEN
        assertSame("Not Enough Position", exception);
    }
}
