package org.taximeter;

import java.text.DecimalFormat;
import java.util.Date;

public class Bill {
    private final double travelCost;
    private final double waitingCost;
    private final double serviceTax;
    private final double baseCharge;
    private final double totalFare;

    private final Date timeStamp;
    public Bill(double travelCost, double waitingCost, double serviceTax, double baseCharge, double totalFare){
        this.travelCost = convertToTwoDecimalPlaces(travelCost);
        this.waitingCost = convertToTwoDecimalPlaces(waitingCost);
        this.serviceTax = convertToTwoDecimalPlaces(serviceTax);
        this.baseCharge = baseCharge;
        this.totalFare = convertToTwoDecimalPlaces(totalFare);
        this.timeStamp = new Date();
    }

    public Bill(){
        this.travelCost = 0;
        this.waitingCost = 0;
        this.serviceTax = 0;
        this.baseCharge = 0;
        this.totalFare = 0;
        this.timeStamp = new Date();
    }

    private double convertToTwoDecimalPlaces(double value){
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(value));
    }

    public boolean equalsInValue(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Bill bill)) {
            return false;
        }
        return Double.compare(this.travelCost, bill.travelCost) == 0
                && Double.compare(this.waitingCost, bill.waitingCost) == 0
                && Double.compare(this.serviceTax, bill.serviceTax) == 0
                && Double.compare(this.totalFare, bill.totalFare) == 0;
    }

    public void print(){
        System.out.println("waiting cost: "+this.waitingCost);
        System.out.println("travel cost: "+this.travelCost);
        System.out.println("service tax: "+this.serviceTax);
        System.out.println("total fare: "+this.totalFare);
    }

    public Bill add(Bill bill){
        return new Bill(this.travelCost + bill.travelCost,
                this.waitingCost+bill.waitingCost,
                this.serviceTax+bill.serviceTax,
                this.baseCharge+bill.baseCharge,
                this.totalFare+bill.totalFare);
    }

}
