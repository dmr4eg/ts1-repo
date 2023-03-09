package cz.cvut.fel.pjv;

import java.util.Scanner;

public class Lab01 {
   static Scanner sc = new Scanner(System.in);

   public void start(String[] args) {
      homework();
   }

   public static void homework() {
      System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");
      int operace = sc.nextInt();
      if (operace == 1) {
         soucet();
      } else if (operace == 2) {
         rozdil();
      } else if (operace == 3) {
         soucin();
      } else if (operace == 4) {
         podil();
      } else {
         System.out.println("Chybna volba!");
      }
   }

   private static void soucet() {
      System.out.println("Zadej scitanec: ");
      double oper1 = sc.nextDouble();
      System.out.println("Zadej scitanec: ");
      double oper2 = sc.nextDouble();
      double result = oper1 + oper2;
      int intRes = (int) result;
      System.out.println("Zadej pocet desetinnych mist: ");
      int desetinne = sc.nextInt();
      String konec = null;
      String o1 = null;
      String o2 = null;
      if (desetinne < 0) {
         System.out.println("Chyba - musi byt zadane kladne cislo!");
      } else {
         o1 = String.format("%." + desetinne + "f", oper1);
         o2 = String.format("%." + desetinne + "f", oper2);
         konec = String.format("%." + desetinne + "f", result);
         System.out.println(o1 + " + " + o2 + " = " + konec);
      }

   }

   private static void rozdil() {
      System.out.println("Zadej mensenec: ");
      double oper1 = sc.nextDouble();
      System.out.println("Zadej mensitel: ");
      double oper2 = sc.nextDouble();
      double result = oper1 - oper2;
      int intRes = (int) result;
      System.out.println("Zadej pocet desetinnych mist: ");
      int desetinne = sc.nextInt();
      String konec = null;
      String o1 = null;
      String o2 = null;
      if (desetinne < 0) {
         System.out.println("Chyba - musi byt zadane kladne cislo!");
      } else {
         o1 = String.format("%." + desetinne + "f", oper1);
         o2 = String.format("%." + desetinne + "f", oper2);
         konec = String.format("%." + desetinne + "f", result);
         System.out.println(o1 + " - " + o2 + " = " + konec);
      }
   }

   private static void soucin() {
      System.out.println("Zadej cinitel: ");
      double oper1 = sc.nextDouble();
      System.out.println("Zadej cinitel: ");
      double oper2 = sc.nextDouble();
      double result = oper1 * oper2;
      int intRes = (int) result;
      System.out.println("Zadej pocet desetinnych mist: ");
      int desetinne = sc.nextInt();
      String konec = null;
      String o1 = null;
      String o2 = null;
      if (desetinne < 0) {
         System.out.println("Chyba - musi byt zadane kladne cislo!");
      } else {
         o1 = String.format("%." + desetinne + "f", oper1);
         o2 = String.format("%." + desetinne + "f", oper2);
         konec = String.format("%." + desetinne + "f", result);
         System.out.println(o1 + " * " + o2 + " = " + konec);
      }
   }

   private static void podil() {
      System.out.println("Zadej delenec: ");
      double oper1 = sc.nextDouble();
      System.out.println("Zadej delitel: ");
      double oper2 = sc.nextDouble();
      if (oper2 == 0) {
         System.out.println("Pokus o deleni nulou!");
         return;
      }
      double result = oper1 / oper2;
      int intRes = (int) result;
      System.out.println("Zadej pocet desetinnych mist: ");
      int desetinne = sc.nextInt();
      String konec = null;
      String o1 = null;
      String o2 = null;
      if (desetinne < 0) {
         System.out.println("Chyba - musi byt zadane kladne cislo!");
      } else {
         o1 = String.format("%." + desetinne + "f", oper1);
         o2 = String.format("%." + desetinne + "f", oper2);
         konec = String.format("%." + desetinne + "f", result);
         System.out.println(o1 + " / " + o2 + " = " + konec);
      }
   }
}