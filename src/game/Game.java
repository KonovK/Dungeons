package game;

import dungeons.Dungeon;
import dungeons.RoomInterface;
import random.RandomDigit;

import java.util.Scanner;

public class Game {

    private Dungeon dungeon;

    public Game(int str, int column) {
        this.dungeon = new Dungeon(str, column);
    }

    public void start() {
        System.out.println("Добро пожаловать в игру Приключения в подземелье!" +
                " Вы - искатель приключений, который попал в таинственное подземелье." +
                " Ваша цель - найти выход, сражаясь с монстрами и находя сокровищаа.");
        System.out.println("Вы находитесь в стартовой комнате.");
        motion();
    }

    static Scanner scanner = new Scanner(System.in);

    private void motion() {
        while (true) {
            System.out.println("Команды: вперед, назад, влево, вправо, состояние, помощь.");
            String s = scanner.nextLine();
            System.out.println("Вы ввели " + s);
            if (s.equals("вперед")) {
                dungeon.forward();
            } else if (s.equals("назад")) {
                dungeon.back();
            } else if (s.equals("влево")) {
                dungeon.left();
            } else if (s.equals("вправо")) {
                dungeon.right();
            }
            info();
        }
    }

    public void info() {
        dungeon.info();
    }

    public int[] creat() {
        return dungeon.createPlayerPosition();
    }
}
