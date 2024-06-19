package heroes;

import dungeons.RoomInterface;
import playerPosition.Position;

public class Player extends Unit implements RoomInterface {

    private int heals;
    private String bag;
    private Position position;

    public Player(int heals, String bag, Position position) {
        this.heals = heals;
        this.bag = bag;
        this.position = position;
    }

    public int getHeals() {
        return heals;
    }

    public String getBag() {
        return bag;
    }

    public Position getPosition() {
        return position;
    }

    public void setHeals(int heals) {
        this.heals = heals;
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
