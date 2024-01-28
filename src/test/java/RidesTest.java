import org.taximeter.Bill;
import org.taximeter.Ride;
import org.taximeter.Rides;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class RidesTest {
    @Test
    public void ableToAddRides(){
        Ride[] ridesList = {new Ride(0,0), new Ride(1,12)};
        Rides rides = new Rides(ridesList);
        assertEquals(2, rides.getRidesCount());

        rides.addRide(new Ride(2,3));
        assertEquals(3, rides.getRidesCount(), 1);

        rides.addRide(new Ride(0,1));
        assertEquals(4, rides.getRidesCount());

        rides.addRide(new Ride(0,0));
        assertEquals(5, rides.getRidesCount());
    }

    @Test
    public void returnsCorrectSumOfFaresOfAllRides(){
        Rides rides = new Rides();

        Bill accumulatorBill = new Bill();
        assertTrue(accumulatorBill.equalsInValue(rides.getTotalFareOfAllRides()));

        rides.addRide(new Ride(0, 2));
        accumulatorBill = accumulatorBill.add(new Bill(0,2*2,0,2,25+2));
        assertTrue(accumulatorBill.equalsInValue(rides.getTotalFareOfAllRides()));

        rides.addRide(new Ride(3, 0));
        accumulatorBill = accumulatorBill.add(new Bill(12*3,0,0,2,(12*3)+2));
        assertTrue(accumulatorBill.equalsInValue(rides.getTotalFareOfAllRides()));

        rides.addRide(new Ride(20, 5));
        accumulatorBill = accumulatorBill.add(new Bill(12*20,2*5,(12*20 + 2*5)*0.01,2,((12*20)+(2*5))*1.01+2));
        assertTrue(accumulatorBill.equalsInValue(rides.getTotalFareOfAllRides()));
    }

    @Test
    public void returnsCorrectBillForTheLastRide(){
        Rides rides = new Rides();

        assertThrows(EmptyStackException.class, rides::getLastRideBill);

        rides.addRide(new Ride(0, 2));
        Bill mockBill = new Bill(12*0,2*2,0,2,25+2);
        assertTrue(mockBill.equalsInValue(rides.getLastRideBill()));

        rides.addRide(new Ride(3, 0));
        mockBill = new Bill(12*3,2*0,0,2,36+2);
        assertTrue(mockBill.equalsInValue(rides.getLastRideBill()));

        rides.addRide(new Ride(20, 5));
        mockBill = new Bill(12*20,2*5,((12*20)+(2*5))*0.01,2,((12*20)+(2*5))*1.01+2);
        assertTrue(mockBill.equalsInValue(rides.getLastRideBill()));
    }
}
