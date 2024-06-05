package game;

import random.RandomDigit;

import java.util.Scanner;

public class Game {

    public static void start(){
        System.out.println("Добро пожаловать в игру Приключения в подземелье!" +
                " Вы - искатель приключений, который попал в таинственное подземелье." +
                " Ваша цель - найти выход, сражаясь с монстрами и находя сокровищаа.");
        System.out.println("Вы находитесь в стартовой комнате.");
        motion();
    }
    static Scanner scanner = new Scanner(System.in);
    public static void motion(){
        System.out.println("Команды: вперед, назад, влево, вправо, состояние, помощь.");
        String s = scanner.nextLine();
        System.out.println("Вы ввели " + s);
        random();
    }
    public static void random(){
        int num = RandomDigit.randomizer(1, 3);
        if (num == 2){
            System.out.println("Вы нашли сокровища!");
        }
        if (num == 3){
            System.out.println("Вы наткнулись на монстра!");
        }
        else {
            System.out.println("Комната пустая.");
            motion();
        }
    }
}
