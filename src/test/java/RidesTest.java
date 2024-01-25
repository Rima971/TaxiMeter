import org.example.Ride;
import org.example.Rides;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RidesTest {
    @Test
    public void ableToAddRides(){
        Rides rides = new Rides();

        rides.addRide(new Ride(0,0));
        assertEquals(1, rides.getRidesCount(), 1);

        rides.addRide(new Ride(0,1));
        assertEquals(2, rides.getRidesCount(), 1);

        rides.addRide(new Ride(0,0));
        assertEquals(3, rides.getRidesCount(), 1);
    }

//    @Test
//    public void returnsCorrectSumOfFaresOfAllRides(){
//        Rides rides = new Rides();
//
//        double counter = 0;
//        assertEquals(0, rides.getTotalFareOfAllRides(), 0.001);
//
//        rides.addRide(new Ride(0, 2));
//        counter += 25+2;
//        assertEquals(counter, rides.getTotalFareOfAllRides(), 0.001);
//
//        rides.addRide(new Ride(3, 0));
//        counter += (12*3)+2;
//        assertEquals(counter, rides.getTotalFareOfAllRides(), 0.001);
//
//        rides.addRide(new Ride(20, 5));
//        counter += ((12*20)+(2*5))*1.01+2;
//        assertEquals(counter, rides.getTotalFareOfAllRides(), 0.001);
//    }
//
//    @Test
//    public void returnsCorrectBillForTheLastRide(){
//        Rides rides = new Rides();
//
//        assertThrows(EmptyStackException.class, rides::getLastRideBill);
//
//        rides.addRide(new Ride(0, 2));
//        Bill bill = rides.getLastRideBill();
//        assertEquals(12*0, bill.travelCost, 0.001);
//        assertEquals(2*2, bill.waitingCost, 0.001);
//        assertEquals(0, bill.serviceTax, 0.001);
//        assertEquals(25+2, bill.totalFare, 0.001);
//
//        rides.addRide(new Ride(3, 0));
//        bill = rides.getLastRideBill();
//        assertEquals(12*3, bill.travelCost, 0.001);
//        assertEquals(2*0, bill.waitingCost, 0.001);
//        assertEquals(0, bill.serviceTax, 0.001);
//        assertEquals(36+2, bill.totalFare, 0.001);
//
//        rides.addRide(new Ride(20, 5));
//        bill = rides.getLastRideBill();
//        assertEquals(12*20, bill.travelCost, 0.001);
//        assertEquals(2*5, bill.waitingCost, 0.001);
//        assertEquals(((12*20)+(2*5))*0.01, bill.serviceTax, 0.001);
//        assertEquals(((12*20)+(2*5))*1.01+2, bill.totalFare, 0.001);
//    }
}
