package project.controller;

import project.dao.BetDao;
import project.dao.impl.BetDaoImpl;
import project.models.Bet;

import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Handler {
    public static void hand1() {
        Scanner sc = new Scanner(System.in);
        boolean boolVar = true;
        int i = 0;
        int valible1;
        double risk1;
        Bet objBet = new Bet();
        BetDao objBDI = new BetDaoImpl();       // objBDI переменная типа интерфейса (с лева обьект типа BetDao, а справа его реализация в BetDaoImpl)

        while (boolVar) {

            try {
                System.out.println("введите Курс : ");
                valible1 = sc.nextInt();
                objBet.setValible(valible1);
                System.out.println("введите риск : ");
                risk1 = sc.nextDouble();
                objBet.setRisk(risk1);
                System.out.println("Вы ввели курс = " + valible1 + ", и риск = " + risk1);

                Bet bet = new Bet(valible1, risk1);
                objBDI.add(bet);

            } catch (InputMismatchException e) {
                System.out.println((char) 27 + "[1;31m" + "Вы ввели некоректные данные, проверте еще раз: Курс - только целое число, риск - пишется через \",\" - если число вещественное!" + "\u001B[0m");
                System.out.println("Введите снова предыдущие данные, но внимательней проверте, поехали!");
            } catch (NoSuchElementException r) {

            }

            System.out.println("Продолжить ввод данных? введите любой символ - для прекращения введите \"q\"");
            String vichVvod = sc.next();
            if (vichVvod.equalsIgnoreCase("q")) {
                boolVar = false;
            }
        }

        System.out.println(objBDI.get());
        System.out.println("Конец программы");
        sc.close();
    }

}






