package project.controller;

import project.dao.BetDao;
import project.dao.impl.BetDaoImpl;
import project.models.Bet;

import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Handler {
    public static void hand1() {
        Scanner sc = new Scanner(System.in);
        boolean boolVar = true;
        int i = 0;
        int valible1;
        double risk1;
        Bet objBet = new Bet();

        while (boolVar) {

            try {
                System.out.println("ввведите Курс : ");
                valible1 = sc.nextInt();
                objBet.setValible(valible1);
                System.out.println("ввведите риск : ");
                risk1 = sc.nextDouble();
                objBet.setRisk(risk1);
                System.out.println("Вы ввели курс = " + valible1 + ", и риск = " + risk1);

                BetDao betdao = new BetDaoImpl();
                betdao.add(objBet);
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


     // System.out.println(betDao);
        sc.close();
        }



    }






