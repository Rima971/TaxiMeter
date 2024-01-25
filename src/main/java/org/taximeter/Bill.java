package org.taximeter;

import java.util.Date;

public class Bill {
    private final double travelCost;
    private final double waitingCost;
    private final double serviceTax;
    private final double baseCharge;
    private final double totalFare;

    private final Date timeStamp;
    public Bill(double travelCost, double waitingCost, double serviceTax, double baseCharge, double totalFare){
        this.travelCost = travelCost;
        this.waitingCost = waitingCost;
        this.serviceTax = serviceTax;
        this.baseCharge = baseCharge;
        this.totalFare = totalFare;
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
                && Double.compare(this.baseCharge, bill.baseCharge) == 0
                && Double.compare(this.totalFare, bill.totalFare) == 0;
    }

    public void print(){
        System.out.println(this);
    }

    public Bill add(Bill bill){
        return new Bill(this.travelCost + bill.travelCost,
                this.waitingCost+bill.waitingCost,
                this.serviceTax+bill.serviceTax,
                this.baseCharge+bill.baseCharge,
                this.totalFare+bill.totalFare);
    }
}
