import dungeons.Dungeon;
import game.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon(10,10);
        System.out.println(dungeon);
        Game.start();
    }
}