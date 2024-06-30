package heroes;

import dungeons.RoomInterface;
import random.RandomDigit;

public class Monster implements RoomInterface {

    private int def;
    private int attack;

    public Monster() {
        int randomizer = RandomDigit.randomizer(1, 2);
        if (randomizer == 1){
            this.def = RandomDigit.randomizer(1, 10);
        } else if (randomizer == 2) {
            this.attack = RandomDigit.randomizer(1, 10);
        }

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

    @Override
    public String toString() {
        return "\uD83D\uDC7E";
    }
}
