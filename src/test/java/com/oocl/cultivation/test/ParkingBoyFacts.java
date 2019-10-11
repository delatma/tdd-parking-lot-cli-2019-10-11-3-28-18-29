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

//    AC2: The parking boy can park multiple cars into the parking lot.
//    And can fetch right car using correspond ticket.
    @Test
    void should_be_able_to_park_multiple_cars_to_parking_lot_by_parking_boy() {
        //given
        Car myCar = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        ParkingTicket myparkingTicket = parkingBoy.park(myCar);
        parkingBoy.park(car2);
        Car fetchedCar = parkingBoy.fetch(myparkingTicket);

        //then
        assertEquals(fetchedCar, myCar);
    }

//    AC3: If the customer gives a wrong ticket (the parking boy did not provide the ticket) or does not give a ticket.
//    Then no car should be fetched.
    @Test
    void should_parking_boy_fetch_no_car() {
        //given
        ParkingBoy parkingboy = new ParkingBoy(new ParkingLot());

        //when
        ParkingTicket wrongTicket = new ParkingTicket();
        Car fetchedCar = parkingboy.fetch(wrongTicket);

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_parking_boy_fetch_no_car_when_ticket_is_null() {
        //given
        ParkingBoy parkingboy = new ParkingBoy(new ParkingLot());

        //when
        ParkingTicket noTicket = null;
        Car fetchedCar = parkingboy.fetch(noTicket);

        //then
        assertNull(fetchedCar);
    }

}
