package hackerrank.cases.currencyformat;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        double payment = scanner.nextDouble();
        double payment = 8278792364d;
        scanner.close();
        
        System.out.println("US: " + NumberFormat.getCurrencyInstance(Locale.US).format(payment)); // Estados Unidos
        System.out.println("India: " + NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment)); // India
        System.out.println("China: " + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment)); // China
        System.out.println("France: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment)); // Francia
    }
}