import org.taximeter.Bill;
import org.taximeter.Ride;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

/*
* Calculate the fair for a given cab ride assumming 12rs for every kilometer
* The meter steps every .1 km
* 2rs/min for waiting time
* 25 is the minimum fare
* The fare should also add a 2rs base charge to all rides and a 1% service fee on fares above 100 RS
* As a user I should be able to get the total fare for a list of rides I have completed
* As a User I should also be able to get a break up of total service fee paid and total waiting time along with the total fare
* I should still be able to get the fare for an individual ride ( inclusive of base price & fee)
* */

public class RideTest {

    @Test
    public void NegativeParameterException(){
        assertThrows(InvalidParameterException.class, () -> new Ride(-1, 0));
        assertThrows(InvalidParameterException.class, () -> new Ride(-1, -2));
        assertThrows(InvalidParameterException.class, () -> new Ride(0, -2));
    }

    @Test
    public void ReturnsMinimumFareForNoDistanceAndWaitingTime(){
        Ride ride = new Ride(0,0);
        Bill mockBill = new Bill(0,0,0,0,25+2);
        assertTrue(mockBill.equalsInValue(ride.computeFare()));
    }

    @Test
    public void ReturnsCorrectFareForNoDistanceButDifferentWaitingTimes(){
        Ride ride = new Ride(0,5);
        Bill mockBill = new Bill(0,2*5,0,2,25+2);
        assertTrue(mockBill.equalsInValue(ride.computeFare()));

        ride = new Ride(0,60);
        mockBill = new Bill(0,2*60,2*60*0.01,2,(2*60*1.01)+2);
        assertTrue(mockBill.equalsInValue(ride.computeFare()));

        ride = new Ride(0,12);
        mockBill = new Bill(0,2*12,0,2,25+2);
        assertTrue(mockBill.equalsInValue(ride.computeFare()));

        ride = new Ride(0,13);
        mockBill = new Bill(0,2*13,0,2,(2*13)+2);
        assertTrue(mockBill.equalsInValue(ride.computeFare()));
    }

    @Test
    public void ReturnsCorrectFareForDifferentDistancesButNoWaitingTimes(){
        Ride ride = new Ride(5,0);
        Bill mockBill = new Bill(12*5,0,0,2,(12*5)+2);
        assertTrue(mockBill.equalsInValue(ride.computeFare()));

        ride = new Ride(60,0);
        mockBill = new Bill(12*60,0,12*60*0.01,2,(60*12*1.01)+2);
        assertTrue(mockBill.equalsInValue(ride.computeFare()));

        ride = new Ride(0,0);
        mockBill = new Bill(0,0,0,2,25+2);
        assertTrue(mockBill.equalsInValue(ride.computeFare()));
    }

//    @Test
//    public void ReturnsCorrectFareForDifferentDistancesAndDifferentWaitingTimes(){
//        Ride ride = new Ride(5,12);
//        assertEquals((12*5)+(2*12)+2, ride.computeFare().totalFare, PRECISION);
//
//        ride = new Ride(60, 13);
//        assertEquals(((12*60)+(2*13))*1.01+2, ride.computeFare().totalFare, PRECISION);
//
//        ride = new Ride(12, 14);
//        assertEquals(((12*12)+(2*14))*1.01+2, ride.computeFare().totalFare, PRECISION);
//    }
//
//    @Test
//    public void DoesNotChargeServiceTaxForFaresBelow100Rs(){
//        Ride ride = new Ride(1, 12);
//        assertEquals((12*1)+(2*12)+2, ride.computeFare().totalFare, PRECISION);
//
//        ride = new Ride(2, 12);
//        assertEquals((12*2)+(2*12)+2, ride.computeFare().totalFare, PRECISION);
//
//        ride = new Ride(3, 12);
//        assertEquals((12*3)+(2*12)+2, ride.computeFare().totalFare, PRECISION);
//    }
//
//    @Test
//    public void ChargesServiceTaxForFaresAbove100Rs(){
//        Ride ride = new Ride(60, 13);
//        assertEquals(((12*60)+(2*13))*1.01+2, ride.computeFare().totalFare, PRECISION);
//
//        ride = new Ride(13, 14);
//        assertEquals(((12*13)+(2*14))*1.01+2, ride.computeFare().totalFare, PRECISION);
//    }
//
//    @Test
//    public void ReturnsCorrectFareForDistancesWithDifferentPrecision(){
//        Ride ride = new Ride(50.1, 0);
//        assertEquals((12*50.1)*1.01+2, ride.computeFare().totalFare, PRECISION);
//
//        ride = new Ride(60.02, 0);
//        assertEquals((12*60.0)*1.01+2, ride.computeFare().totalFare, PRECISION);
//
//        ride = new Ride(12.19, 0);
//        assertEquals((12*12.1)*1.01+2, ride.computeFare().totalFare, PRECISION);
//    }



}
