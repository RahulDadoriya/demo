package com.citiustech.demo.utilities;

/*
* Utilities class for calculating tax based on tax percentage*
* */
public class CalculateTax {
    private final static double taxPercentage = 4.3;

    // Simple calculate method of calculating tax based on original amount
    public static double calculateTaxAmount(double originalAmount) {
        double tempAmount = (originalAmount * taxPercentage)/100;
        tempAmount = originalAmount + tempAmount;
        return  round(tempAmount, 2);
    }

    // This method is for rounding off value to given places afer decimal like here is 2
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
