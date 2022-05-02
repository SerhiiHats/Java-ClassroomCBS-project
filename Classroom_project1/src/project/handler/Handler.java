package project.handler;

import project.db.Storage;
import project.models.Bet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Handler {
    public static void hand1() {
        Scanner sc = new Scanner(System.in);
        boolean boolVar = true;
        int i = 0;

        while (boolVar) {

            try {
                System.out.println("ввведите Курс : ");
                int valible = sc.nextInt();
                System.out.println("ввведите риск : ");
                double risk = sc.nextDouble();
                System.out.println("Вы ввели курс = " + valible + ", и риск = " + risk);
//                Bet first = new Bet(valible, risk);
//                Storage.bets(new Bet(valible, risk));


            } catch (InputMismatchException e) {
                System.out.println((char) 27 + "[1;31m" + "Вы ввели некоректные данные, проверте еще раз: Курс - только целое число, риск - пишется через \",\" - если число вещественное!" + "\u001B[0m");
                System.out.println("Введите снова предыдущие данные, но внимательней проверте, поехали!");
                hand1();
            }

                System.out.println("Продолжить ввод данных? введите любой символ - для прекращения введите \"q\"");
            String vichVvod = sc.next();
              if (vichVvod.equalsIgnoreCase("q")) {
                  boolVar = false;
                  return;
              }


            }
        sc.close();
        }



    }






