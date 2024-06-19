package game;

import dungeons.Dungeon;
import dungeons.RoomInterface;
import random.RandomDigit;

import java.util.Scanner;

public class Game {

    private Dungeon dungeon;

    public Game(int str, int column){
        this.dungeon = new Dungeon(str,column);
    }

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
        if (s == "вперед"){
            Dungeon.forward();
        } else if (s == "назад") {
            Dungeon.back();
        } else if (s == "влево") {
            Dungeon.left();
        } else if (s == "вправо") {
            Dungeon.right();
        }
    }
    public void info() {
        dungeon.info();
    }
    public int[] creat(){
        return dungeon.createPlayerPosition();
    }
}
