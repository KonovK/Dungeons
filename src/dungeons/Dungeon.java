package dungeons;

import heroes.Player;
import random.RandomDigit;

import java.util.Random;

public class Dungeon {

    private Room[][] matrix;

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
        this.matrix[playerPosition][0] = new Room(new Player(100, "test", "test"));
        return new int[]{playerPosition, 0};
    }
}
