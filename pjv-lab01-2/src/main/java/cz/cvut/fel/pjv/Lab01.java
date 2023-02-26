package cz.cvut.fel.pjv;

import java.util.Scanner;
import java.math.BigDecimal;
public class Lab01 {
   private static final Scanner sc = new Scanner(System.in);
   private static int desetinne = 0;


   public void homework() {
      System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");
   }
   public void soucet(){
      System.out.println("Zadej scitanec: ");
      oper1 = sc.nextDouble();
      System.out.println("Zadej scitanec: ");
      oper2 = sc.nextDouble();
   }
   public void rozdil(){
      System.out.println("Zadej mensenec: ");
      oper1 = sc.nextDouble();
      System.out.println("Zadej mensitel: ");
      oper2 = sc.nextDouble();
   }
   public void soucin(){
      System.out.println("Zadej cinitel: ");
      oper1 = sc.nextDouble();
      System.out.println("Zadej cinitel: ");
      oper2 = sc.nextDouble();
   }
   public void podil(){
      System.out.println("Zadej delenec: ");
      oper1 = sc.nextDouble();
      System.out.println("Zadej delitel: ");
      oper2 = sc.nextDouble();
   }
   public void start(String[] args) {
      homework();
   }
//   public void homework(String[] args){
//      Scanner sc = new Scanner(System.in);
//      System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");
//      int operator = sc.nextInt();
//      double oper1 = 0;
//      double oper2 = 0;
//      double result = 0;
//      if (operator == 1){        // soucet
//         System.out.println("Zadej scitanec: ");
//         oper1 = sc.nextDouble();
//         System.out.println("Zadej scitanec: ");
//         oper2 = sc.nextDouble();
//         result = oper1 + oper2;
//      } else if(operator == 2){        // rozdil
//         System.out.println("Zadej mensenec: ");
//         oper1 = sc.nextDouble();
//         System.out.println("Zadej mensitel: ");
//         oper2 = sc.nextDouble();
//         result = oper1 - oper2;
//      } else if(operator == 3){        // soucin
//         System.out.println("Zadej cinitel: ");
//         oper1 = sc.nextDouble();
//         System.out.println("Zadej cinitel: ");
//         oper2 = sc.nextDouble();
//         result = oper1 * oper2;
//      } else if(operator == 4){        // podil
//         System.out.println("Zadej delenec: ");
//         oper1 = sc.nextDouble();
//         System.out.println("Zadej delitel: ");
//         oper2 = sc.nextDouble();
//         if (oper2 == 0){
//            System.out.println("Pokus o deleni nulou!");
//            return;
//         }
//         result = oper1 / oper2;
//      } else{
//         System.out.println("Chybna Volba!");
//         return;
//      }
//      System.out.println("Zadej pocet desetinnych mist:");
//      int desetinne = sc.nextInt();
//      int intResult = (int) result;
//      if (desetinne < 0) {
//         System.out.println("Chyba - musi byt zadane kladne cislo!");
//      } else if (desetinne == 0){
//         System.out.println(intResult);
//      } else{
//         System.out.println("bruh");
//      }
//   }
}