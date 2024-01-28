package org.taximeter;

import java.util.Stack;

public class Rides {
    private final Stack<Ride> rides;
    public Rides(){
        this.rides = new Stack<Ride>();
    }

    public Rides(Ride[] rides){
        this.rides = new Stack<Ride>();
        for (Ride ride : rides) {
            this.rides.push(ride);
        }
    }

    public void addRide(Ride ride){
        this.rides.push(ride);
    }

    public Bill getTotalFareOfAllRides(){
        var ref = new Object() {
            Bill accumulatorBill = new Bill();
        };
        this.rides.forEach(ride-> ref.accumulatorBill = ref.accumulatorBill.add(ride.computeFare()));
        return ref.accumulatorBill;
    }

    public int getRidesCount(){
        return this.rides.size();
    }

    public Bill getLastRideBill(){
        return this.rides.peek().computeFare();
    }


}
