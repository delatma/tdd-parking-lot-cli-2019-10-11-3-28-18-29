package com.oocl.cultivation;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return cars.size() - capacity;
    }

    public ParkingTicket park(Car car){
        ParkingTicket ticket = new ParkingTicket();
        if(cars.size()>= capacity) {
            return null;
        }
        cars.put(ticket, car);
        return ticket;
    }

    public Car fetch(ParkingTicket ticket){
        return cars.remove(ticket);
    }
}
