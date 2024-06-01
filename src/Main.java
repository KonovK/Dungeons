import dungeons.Dungeon;
import game.Game;

public class Main {
    public static void main(String[] args) {
        Game.start();
        Dungeon dungeon = new Dungeon();
        System.out.println(dungeon);
    }
}