package project.controller;
import project.dao.BetDao;
import project.dao.impl.BetDaoImpl;
import project.db.Storage;
import project.models.Bet;
import java.util.Scanner;

public class Handler {
    public static void hand1() {
        boolean keyout = true;
        Scanner sc = new Scanner(System.in);
        BetDao objBDI = new BetDaoImpl();       // objBDI переменная типа интерфейса (с лева обьект типа BetDao, а справа его реализация в BetDaoImpl)

        while (keyout) {
            System.out.println("\u001B[1;32m" + "1.ввести данные 2.показать все данные 3.показать по номеру (№п/п) 4.удалить по номеру (№п/п) 5.(или другой) выход" + "\u001B[0m");
            switch (sc.next()) {
                case "1": {
                    while (true) {
                        Bet objBet = new Bet();
                        System.out.println("введите курс : ");
                        if (sc.hasNextInt()) {
                            objBet.setValible(sc.nextInt());
                        } else {
                            System.out.println("Не коректные данные, пожайлуста повторите");
                            sc.nextLine();
                            continue;
                        }

                        System.out.println("введите риск : ");
                        if (sc.hasNextDouble()) {
                            objBet.setRisk(sc.nextDouble());
                        } else {
                            System.out.println("Не коректные данные, пожайлуста повторите");
                            sc.nextLine();
                            sc.nextLine();
                            continue;
                        }
                        Storage.bets.add(objBet);          // Добавляем новый элемент в конец списка
                        System.out.println("\u001B[1;32m" + "Данные записаны. Ваш Курс : " + objBet.getValible() + ", Ваш Риск : " + objBet.getRisk() + "\u001B[0m");

                        System.out.println();
                        System.out.println("Вы хотите продолжить внести другие данные?: " + "\u001B[1;32m" + "Да - любой символ / Нет - \" 0 \":" + "\u001B[0m");
                        if (sc.next().equals("0")) {
                            break;
                        } else {
                            sc.nextLine();
                        }
                    }
                    break;
                }
                case "2": {
                    if (Storage.bets.size() == 0) {
                        System.out.println("Список данных пуст");
                    } else {
                        for (int i = 0; i < Storage.bets.size(); i++) {
                            System.out.println("№п/п: " + i + ", " + objBDI.getBet(i));
                        }
                    }
                    break;
                }
                case "3": {
                    while (true) {
                        try {
                            System.out.println("Введите номер записи для показа № п/п :");

                            if (sc.hasNextInt()) {
                                int i = sc.nextInt();
                                System.out.println("№п/п: " + i + ", " + objBDI.getBet(i));
                                break;
                            } else {
                                System.out.println("Номер введен неправильно, пожайлуста повторите");
                                sc.nextLine();
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("\u001B[1;31m" + "Такого номера №п/п: нет" + "\u001B[0m");
                        } finally {
                            if (Storage.bets.size() == 0) {
                                System.out.println("Список данных пуст");
                                break;
                            }
                        }
                    }
                    break;
                }

                case "4": {
                    while (true) {
                        try {
                            System.out.println("Введите номер записи для удаления № п/п :");
                            if (sc.hasNextInt()) {
                                int i = sc.nextInt();
                                System.out.println("\u001B[1;31m" + "Была удалена запись №п/п: " + i + ", " + objBDI.getBet(i) + " со сдвигом вверх" + "\u001B[0m");
                                Storage.bets.remove(i);
                                break;
                            } else {
                                System.out.println("Номер введен неправильно, пожайлуста повторите");
                                sc.nextLine();
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("\u001B[1;31m" + "Такого номера №п/п: нет" + "\u001B[0m");
                        } finally {
                            if (Storage.bets.size() == 0) {
                                System.out.println("Список данных пуст");
                                break;
                            }
                        }
                    }
                    break;
                }

                default: {
                    System.out.println("Конец программы");
                    keyout = false;
                    break;
                }
            }
        }
        sc.close();
    }
}






