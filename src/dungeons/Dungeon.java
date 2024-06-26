package dungeons;

import enums.DirectionMovement;
import heroes.Empty;
import heroes.Player;
import playerPosition.Position;
import random.RandomDigit;

import java.util.Random;

public class Dungeon {

    private Player player;
    private Room[][] matrix;
    private Position position;

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
        this.player = new Player(100, "test", new Position(0, playerPosition));
        this.matrix[playerPosition][0] = new Room(player);
        return new int[]{playerPosition, 0};
    }


    public void forward() {
        move("Игрок переместился вперёд.", -1, DirectionMovement.VERTICAL);
    }

    public void back() {
        move("Игрок переместился назад.", 1, DirectionMovement.VERTICAL);
    }

    public void left() {
        move("Игрок переместился влево.", -1, DirectionMovement.HORIZONTAL);
    }

    public void right() {
        move("Игрок переместился вправо.", 1, DirectionMovement.HORIZONTAL);
    }

    private void move(String desc, int offset, DirectionMovement dir) {
        if (dir == DirectionMovement.VERTICAL) {
            if ((position.getY() + offset) < 0 || (position.getY() + offset) >= matrix.length){
                if ((position.getY() + offset) == matrix[0].length) {
                    System.out.println("Вы достигли нижней грани.");
                    return;
                }
                else {
                    System.out.println("Вы достигли верхней грани.");
                    return;
                }
            }
            RoomInterface room = matrix[position.getY() + offset][position.getX()].getRoomInterface();
            interaction(room);
            matrix[position.getY()][position.getX()] = new Room(new Empty());
            position.setY(position.getY() + offset);
        } else if (dir == DirectionMovement.HORIZONTAL) {
            if ((position.getX() + offset) < 0 || (position.getX() + offset) >= matrix[0].length){
                if ((position.getX() + offset) == matrix.length) {
                    System.out.println("Вы достигли правой грани.");
                }
                else {
                    System.out.println("Вы достигли левой грани.");
                }
                return;
            }
            RoomInterface room = matrix[position.getY() + offset][position.getX()].getRoomInterface();
            interaction(room);
            matrix[position.getY()][position.getX()] = new Room(new Empty());
            position.setX(position.getX() + offset);
        }
        matrix[position.getY()][position.getX()].setRoomInterface(player);
        System.out.println(desc);

    }

    private void interaction(RoomInterface roomInterface) {
        player.interaction(roomInterface);
    }

}
