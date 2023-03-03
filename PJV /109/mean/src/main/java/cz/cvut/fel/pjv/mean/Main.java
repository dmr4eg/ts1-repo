package cz.cvut.fel.pjv.mean;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double sum = 0;
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()) {
            double number = sc.nextDouble();
            sum += number;
            counter++;
            System.out.println("You entered: " + number);
        }
        double mean = sum / counter;
        System.out.println("The maean is " + mean);
    }
}