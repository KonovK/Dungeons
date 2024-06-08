import dungeons.Dungeon;
import game.Game;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(10, 10);
        System.out.println(Arrays.toString(game.creat()));
        game.info();
    }
}