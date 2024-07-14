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
        player.info();
    }

    public int[] createPlayerPosition() {
        int playerPosition = RandomDigit.randomizer(1, matrix.length - 1);
        position = new Position(0, playerPosition);
        this.player = new Player(100, "test", new Position(0, playerPosition), 5, 5);
        this.matrix[playerPosition][0] = new Room(player);
        return new int[]{playerPosition, 0};
    }


    public void forward() {
        move(-1, DirectionMovement.VERTICAL);
    }

    public void back() {
        move(1, DirectionMovement.VERTICAL);
    }

    public void left() {
        move(-1, DirectionMovement.HORIZONTAL);
    }

    public void right() {
        move(1, DirectionMovement.HORIZONTAL);
    }

    private void move(int offset, DirectionMovement dir) {
        moveDependDirection(offset, dir);
    }

    private void moveDependDirection(int offset, DirectionMovement dir) {
        int length = 0;
        int nextPosition = 0;
        if (dir == DirectionMovement.VERTICAL) {
            length = matrix.length;
            nextPosition = position.getY() + offset;
        } else if (dir == DirectionMovement.HORIZONTAL) {
            length = matrix[0].length;
            nextPosition = position.getX() + offset;
        }
        if (nextPosition < 0 || nextPosition >= length) {
                System.out.println("Вы достигли края.");
                return;
        }

        RoomInterface room = getNextRoom(nextPosition, dir);
        interaction(room);
        matrix[position.getY()][position.getX()] = new Room(new Empty());
        goNextRoom(nextPosition, dir);
        matrix[position.getY()][position.getX()].setRoomInterface(player);
    }

    private RoomInterface getNextRoom(int nextPosition, DirectionMovement dir) {
        switch (dir) {
            case VERTICAL -> {
                return matrix[nextPosition][position.getX()].getRoomInterface();
            }
            case HORIZONTAL -> {
                return matrix[position.getY()][nextPosition].getRoomInterface();
            }
        }
        return null;
    }

    private void goNextRoom(int nextPosition, DirectionMovement dir) {
        switch (dir) {
            case VERTICAL -> {
                position.setY(nextPosition);
            }
            case HORIZONTAL -> {
                position.setX(nextPosition);
            }
        }
    }


    private void interaction(RoomInterface roomInterface) {
        player.interaction(roomInterface);
    }

}
