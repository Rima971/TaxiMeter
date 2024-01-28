package org.taximeter;

import java.security.InvalidParameterException;

import static java.lang.Math.max;

public class Ride {
    private enum Constants {
        RUPEES_PER_MIN(2.0),
        RUPEES_PER_KM(12.0),
        METER_STEPS(0.1000),

        MINIMUM_FARE(25.0),
        BASE_FARE(2.0),
        SERVICE_TAX(0.01),
        SERVICE_TAX_COST_THRESHOLD(100.0);

        public final double value;

        private Constants(double value){this.value = value;}
    }
    private final double distanceInKm;
    private final double waitingTimeInMin;
    public Ride(double distanceInKm, double waitingTimeInMin){
        if (distanceInKm<0) throw new InvalidParameterException("Distance cannot be negative");
        if (waitingTimeInMin<0) throw new InvalidParameterException("Time cannot be negative");
        this.distanceInKm = distanceInKm;
        this.waitingTimeInMin = waitingTimeInMin;
    }
    public Bill computeFare(){
        double formattedDistanceAccordingToSteps = (int) (this.distanceInKm / Constants.METER_STEPS.value) * Constants.METER_STEPS.value;
        double travelCost = formattedDistanceAccordingToSteps * Constants.RUPEES_PER_KM.value;
        double waitingCost = this.waitingTimeInMin * Constants.RUPEES_PER_MIN.value;
        double cost = waitingCost + travelCost;
        double serviceTax = cost > Constants.SERVICE_TAX_COST_THRESHOLD.value ? cost * Constants.SERVICE_TAX.value : 0;
        double costAfterServiceTax = cost + serviceTax;
        double totalCost = max(costAfterServiceTax, Constants.MINIMUM_FARE.value) + Constants.BASE_FARE.value;
        return new Bill(travelCost, waitingCost, serviceTax, Constants.BASE_FARE.value, totalCost);
    }
}
