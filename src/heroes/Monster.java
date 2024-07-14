package heroes;

import dungeons.RoomInterface;
import random.RandomDigit;

public class Monster implements RoomInterface {

    private int def;
    private int attack;
    private int health;

    public Monster() {
        this.def = RandomDigit.randomizer(1, 5);
        this.attack = RandomDigit.randomizer(5, 10);
        this.health = RandomDigit.randomizer(30, 70);
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void info(){
        System.out.println("Здоровье монстра " + health + ", атака " + attack + ", защита " + def);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC7E";
    }
}
