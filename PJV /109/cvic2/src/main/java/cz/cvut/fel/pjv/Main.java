package cz.cvut.fel.pjv;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];

        for (int i = 0; i < 10; i++){
            Scanner sc = new Scanner(System.in);
            array[i] = sc.nextInt();
        }
        for (int i = 9; i >= 0; i--){
            System.out.print(array[i] + " ");
        }
    }
}