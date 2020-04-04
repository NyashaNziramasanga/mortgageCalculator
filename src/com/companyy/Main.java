package com.companyy;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int MIN_PRINCIPLE = 1000;
        final int MAX_PRINCIPLE = 1_000_000;

        final float MIN_AVERAGE_INTEREST_RATE = 1;
        final float MAX_AVERAGE_INTEREST_RATE = 30;

        final byte MIN_PERIOD = 1;
        final byte MAX_PERIOD = 30;

//      Q1: Principle
        int  principle = (int) readNumber("Enter Principle ($1K - $1M): ",MIN_PRINCIPLE, MAX_PRINCIPLE );

//      Q2: Monthly Interest
        float averageInterestRate = (float) readNumber("Average Interest Rate (Annual): ",MIN_AVERAGE_INTEREST_RATE,MAX_AVERAGE_INTEREST_RATE );

//      Q3: Period (Years)
        byte period = (byte) readNumber("Period (Years): ",MIN_PERIOD, MAX_PERIOD);

        double mortgage = calculateMortgage(principle,averageInterestRate,period);

//      Format of mortgage
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage (per month):" + mortgageFormatted);
    }

    public static double readNumber(String prompt, double min, double max) {
        //      Get User Input
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max){
                break;
            }
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

//    Public method which returns a double
    public static double calculateMortgage(int principle, float averageInterestRate, byte period){

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = averageInterestRate / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(period * MONTHS_IN_YEAR);

        // Using the mortgage formula
        double mortgage = principle
                * (monthlyInterest * Math.pow(1+monthlyInterest, numberOfPayments))
                / (Math.pow(1+monthlyInterest, numberOfPayments)-1);
        return mortgage;
    }
}
