package dungeons;

import heroes.Player;
import playerPosition.Position;
import random.RandomDigit;

import java.util.Random;

public class Dungeon {

    private Room[][] matrix;
    private static Position position;

    public Dungeon(int str, int column) {
        this.matrix = new Room[str][column];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = new Room();
            }
        }
    }

    public void info() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public int[] createPlayerPosition() {
        int playerPosition = RandomDigit.randomizer(1, matrix.length - 1);
        position = new Position(0, playerPosition);
        this.matrix[playerPosition][0] = new Room(new Player(100, "test", new Position(0, playerPosition)));
        return new int[]{playerPosition, 0};
    }
    public static void forward(){
        position.setY(position.getY()+1);
        System.out.println("Игрок переместился вперёд.");
    }
    public static void back(){
        position.setY(position.getY()-1);
        System.out.println("Игрок переместился назад.");
    }
    public static void left(){
        position.setY(position.getX()+1);
        System.out.println("Игрок переместился влево.");
    }
    public static void right(){
        position.setY(position.getX()-1);
        System.out.println("Игрок переместился вправо.");
    }

}
