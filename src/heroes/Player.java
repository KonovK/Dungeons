package heroes;

import dungeons.RoomInterface;
import playerPosition.Position;
import random.RandomDigit;
import treasure.Treasure;

public class Player extends Unit implements RoomInterface {

    private int health;
    private String bag;
    private Position position;
    private int attack;
    private int def;

    public Player(int health, String bag, Position position, int attack, int def) {
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
        }
        if (roomInterface instanceof Empty empty){
            System.out.println("Вы тут были!");
        }
        if (roomInterface instanceof Monster monster){
            System.out.println("Вы наткнулись на монстра!");
            this.health -= monster.getAttack();
            this.health += monster.getDef();
        }
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
        System.out.println("Здоровье " + health + ", атака " + attack + ", защита " + def);
    }

    public int getHealth() {
        return health;
    }

    public String getBag() {
        return bag;
    }

    public Position getPosition() {
        return position;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setBag(String bag) {
        this.bag = bag;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public void attack() {

    }
}
