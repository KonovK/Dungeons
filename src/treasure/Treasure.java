package treasure;

import dungeons.RoomInterface;
import heroes.Player;
import random.RandomDigit;

public class Treasure implements RoomInterface {

    private int heath;
    private int attack;
    private int def;

    public Treasure() {
        int randomizer = RandomDigit.randomizer(1, 3);
        if (randomizer == 1) {
            this.heath = RandomDigit.randomizer(1, 10);
        } else if (randomizer == 2) {
            this.attack = RandomDigit.randomizer(1, 10);
        } else {
            this.def = RandomDigit.randomizer(1, 10);
        }
    }

    public int getHeath() {
        return heath;
    }

    public void setHeath(int heath) {
        this.heath = heath;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    @Override
    public String toString() {
        return "\uD83D\uDCB0";
    }
}

