package dungeons;

import heroes.Monster;
import heroes.Player;
import random.RandomDigit;
import treasure.Treasure;

public class Room {

    private RoomInterface roomInterface;

    public Room() {
        int randomizer = RandomDigit.randomizer(1, 2);
        if (randomizer == 1) {
            this.roomInterface = new Treasure();
        } else {
            this.roomInterface = new Monster();
        }
    }

    public Room(RoomInterface roomInterface) {
        this.roomInterface = roomInterface;
    }

    public RoomInterface getRoomInterface() {
        return roomInterface;
    }

    public void setRoomInterface(RoomInterface roomInterface) {
        this.roomInterface = roomInterface;
    }

    @Override
    public String toString() {
        if (roomInterface instanceof Treasure) {
            return "\uD83D\uDCB0";
        }
        if (roomInterface instanceof Player) {
            return "\uD83E\uDDDD";

        } else {
            return "\uD83D\uDC7E";
        }
    }
}
