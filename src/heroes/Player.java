package heroes;

import dungeons.RoomInterface;
import playerPosition.Position;
import random.RandomDigit;
import treasure.Treasure;

public class Player extends Unit implements RoomInterface {

    private int health = 100;
    private String bag;
    private Position position;

    public Player(int health, String bag, Position position) {
        this.health = health;
        this.bag = bag;
        this.position = position;
    }

    public void interaction(RoomInterface roomInterface){
        if (roomInterface instanceof Treasure treasure){
            increasedLife();
        }
        if (roomInterface instanceof Empty empty){
            System.out.println("Вы тут были!");
        }
        if (roomInterface instanceof Monster monster){
            System.out.println("Вы наткнулись на монстра!");
        }
    }
    public  void increasedLife(){
        System.out.println("Вы нашли сокровища!");
        int randomizerHelth = RandomDigit.randomizer(1, 30);
        System.out.println("Вы вылечины на " + randomizerHelth + " HP.");
        this.health += randomizerHelth;
        System.out.println("Ваше здоровье " + health + " HP.");
    }

    public void info(){
        System.out.println(health);
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
