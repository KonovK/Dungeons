package heroes;

import dungeons.RoomInterface;

public class Player extends Unit implements RoomInterface {

    private int heals;
    private String bag;
    private String position;

    public Player(int heals, String bag, String position) {
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

    public String getPosition() {
        return position;
    }

    public void setHeals(int heals) {
        this.heals = heals;
    }

    public void setBag(String bag) {
        this.bag = bag;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void attack() {

    }
}
