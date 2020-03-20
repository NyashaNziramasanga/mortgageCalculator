package com.companyy;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

//        Get User Input
        Scanner scanner = new Scanner(System.in);

//      Q2: Principle
        System.out.print("Principle:");
        int principle = scanner.nextInt();

//      Q1: Monthly Interest
        System.out.print("Average Interest Rate (Annual):");
        float averageInterestRate = scanner.nextFloat();
        float monthlyInterest = averageInterestRate / PERCENT / MONTHS_IN_YEAR;

//      Q1: Period (Years)
        System.out.print("Period (Years):");
        byte period = scanner.nextByte();
        int numberOfPayments = period * MONTHS_IN_YEAR;

//       Using the mortgage formula
        double mortgage = principle
            * (monthlyInterest * Math.pow(1+monthlyInterest, numberOfPayments))
            / (Math.pow(1+monthlyInterest, numberOfPayments)-1);

//    Format of mortgage
       String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
       System.out.println("Mortgage (per month):" + mortgageFormatted);
    }
}
