package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
//import com.sun.tools.javac.util.DefinedBy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void should_parking_boy_park_a_car_to_parking_lot() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_be_able_to_fetch_a_car_from_parking_lot_by_parking_boy() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        
        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        //then
        assertNotNull(fetchedCar);
    }

    @Test
    void should_parking_boy_fetch_the_correct_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        //then
        assertNotNull(fetchedCar);
    }


}
