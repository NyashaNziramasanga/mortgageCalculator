package com.companyy;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        final int MIN_PRINCIPLE = 1000;
        final int MAX_PRINCIPLE = 1_000_000;

        final float MIN_AVERAGE_INTEREST_RATE = 1;
        final float MAX_AVERAGE_INTEREST_RATE = 30;

        final byte MIN_PERIOD = 1;
        final byte MAX_PERIOD = 30;

        int principle = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

//      Get User Input
        Scanner scanner = new Scanner(System.in);

//      Q1: Principle
        while (true){
        System.out.print("Enter Principle ($1K - $1M): ");
        principle = scanner.nextInt();

        if (principle >= MIN_PRINCIPLE && principle <= MAX_PRINCIPLE)
            break;
            System.out.println("Enter a number between $1,000 and $1,000,000.");
            System.out.print("Enter Principle ($1K - $1M): ");
        };

//      Q2: Monthly Interest
        while (true) {
            System.out.print("Average Interest Rate (Annual):");
            float averageInterestRate = scanner.nextFloat();
            if (averageInterestRate >= MIN_AVERAGE_INTEREST_RATE && averageInterestRate <= MAX_AVERAGE_INTEREST_RATE){
                monthlyInterest = averageInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
        }

//      Q3: Period (Years)
        while (true){
            System.out.print("Period (Years):");
            byte period = scanner.nextByte();
            if (period >= MIN_PERIOD && period <= MAX_PERIOD){
                numberOfPayments = period * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }


//      Using the mortgage formula
        double mortgage = principle
            * (monthlyInterest * Math.pow(1+monthlyInterest, numberOfPayments))
            / (Math.pow(1+monthlyInterest, numberOfPayments)-1);

//     Format of mortgage
       String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
       System.out.println("Mortgage (per month):" + mortgageFormatted);
    }
}
