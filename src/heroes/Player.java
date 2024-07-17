package heroes;

import dungeons.RoomInterface;
import enums.Artifact;
import playerPosition.Position;
import random.RandomDigit;
import treasure.Treasure;

public class Player extends Unit implements RoomInterface {

    private int health;
    private Backpack bag;
    private Position position;
    private int attack;
    private int def;

    public Player(int health, Backpack bag, Position position, int attack, int def) {
        this.health = health;
        this.bag = bag;
        this.position = position;
        this.attack = attack;
        this.def = def;
    }

    public void interaction(RoomInterface roomInterface){
        if (roomInterface instanceof Treasure treasure){
            this.health += treasure.getHeath();
            this.attack += treasure.getAttack();
            this.def += treasure.getDef();
            if (treasure.getItem() != null) {
                bag.addArtifact((Artifact) treasure.getItem());
                System.out.println("Вы нашли артефакт!");
                interactionArtifacts();
            }
            System.out.println("Вы нашли сокровища!");
        }
        if (roomInterface instanceof Empty empty){
            System.out.println("Вы тут были!");
        }
        if (roomInterface instanceof Monster monster){
            System.out.println("Вы наткнулись на монстра!");
            monster.info();
            interactionMonster(monster);
        }
        if (roomInterface instanceof EmptyRoom emptyRoom) {
            System.out.println("Вы вошли в пустую комнату!");
        }
    }

    public void interactionArtifacts() {
        if (getBag().getArtifacts().contains(Artifact.SWORD)) {
            int randomizerSword = RandomDigit.randomizer(1, 2);
            if (randomizerSword == 1) {
                System.out.println("Вы нашли серебрянный меч!");
                System.out.println("Атака увеличена на 5!");
                this.attack += 5;
            }
            else {
                System.out.println("Вы нашли золотой меч!");
                System.out.println("Атака увеличена на 10!");
                this.attack += 10;
            }
        }
        if (getBag().getArtifacts().contains(Artifact.HELM)) {
            int randomizerHelm = RandomDigit.randomizer(1, 2);
            if (randomizerHelm == 1) {
                System.out.println("Вы нашли серебрянный шлем!");
                System.out.println("Защита увеличена на 5!");
                this.def += 5;
            }
            else {
                System.out.println("Вы нашли золотой шлем!");
                System.out.println("Защита увеличена на 10!");
                this.def += 10;
            }
        }
        if (getBag().getArtifacts().contains(Artifact.ARMOR)) {
            int randomizerArmor = RandomDigit.randomizer(1, 2);
            if (randomizerArmor == 1) {
                System.out.println("Вы нашли серебрянные доспехи!");
                System.out.println("Защита увеличена на 5!");
                this.def += 5;
            }
            else {
                System.out.println("Вы нашли золотые доспехи!");
                System.out.println("Защита увеличена на 10!");
                this.def += 10;
            }
        }
    }

    private void interactionMonster(Monster monster) {
        while (this.health > 0 && monster.getHealth() > 0) {
            playerAttack(monster);
            monsterAttack(monster);
        }
        if (this.health > 0) {
            System.out.println("Игрок победил!");
        } else if (monster.getHealth() > 0) {
            System.out.println("Монстер победил!");
        }
    }

    private void monsterAttack(Monster monster) {
        int damage = monster.getAttack() - this.def;
        if (damage <= 2) {
            damage = 2;
        }
        this.health -= damage;
    }

    private void playerAttack(Monster monster) {
        int damage = this.attack - monster.getDef();
        if (damage <= 2) {
            damage = 2;
        }
        monster.setHealth(monster.getHealth() - damage);
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
    public void info(){
        System.out.println("Здоровье игрока " + health + ", атака " + attack + ", защита " + def);
    }

    public int getHealth() {
        return health;
    }

    public Backpack getBag() {
        return bag;
    }

    public Position getPosition() {
        return position;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setBag(Backpack bag) {
        this.bag = bag;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public void attack() {

    }
}
