package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager extends ParkingBoy{
    private List<ParkingBoy> manageList = new ArrayList<>();

    public ParkingLotServiceManager(List<ParkingLot> parkingLotList){
        super(parkingLotList);
    }

    public void setManageList(List<ParkingBoy> parkingBoys){
        this.manageList=parkingBoys;
    }

    public List<ParkingBoy> getManageList(){
        return manageList;
    }

    public Ticket parkingCommand(ParkingBoy parkingBoy, Car car){
        return parkingBoy.parkCar(car);
    }

    public Car fetchingCommand(ParkingBoy parkingBoy, Ticket ticket){
        return parkingBoy.fetchCar(ticket);
    }

    public void setManagementList(List<ParkingBoy> parkingBoys){
        this.manageList = parkingBoys;
    }
}
