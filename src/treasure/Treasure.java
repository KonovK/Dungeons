package treasure;

import dungeons.RoomInterface;
import enums.Artifact;
import heroes.Item;
import heroes.Player;
import random.RandomDigit;

public class Treasure implements RoomInterface {

    private int heath;
    private int attack;
    private int def;
    private Item item;

    public Treasure() {
        int randomizer = RandomDigit.randomizer(1, 3);
        if (randomizer == 1) {
            this.heath = RandomDigit.randomizer(1, 10);
        } else if (randomizer == 2) {
            this.attack = RandomDigit.randomizer(1, 10);
        } else {
            this.def = RandomDigit.randomizer(1, 10);
        }
        generateArtifact();
    }
    private void generateArtifact() {
        int itemRandomizer = RandomDigit.randomizer(1, 10);
        if (itemRandomizer == 1) {
            Artifact[] artifacts = Artifact.values();
            int length = artifacts.length;
            int randomArt = RandomDigit.randomizer(0, length - 1);
            this.item = artifacts[randomArt];
        }
    }

    public Item getItem() {
        return item;
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

