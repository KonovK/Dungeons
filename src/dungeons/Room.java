package dungeons;

import heroes.Empty;
import heroes.EmptyRoom;
import heroes.Monster;
import heroes.Player;
import random.RandomDigit;
import treasure.Treasure;

public class Room {

    private RoomInterface roomInterface;

    public Room() {
        int randomizer = RandomDigit.randomizer(1, 3);
        if (randomizer == 1) {
            this.roomInterface = new Treasure();
        } else if (randomizer == 2) {
            this.roomInterface = new EmptyRoom();
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
        if (roomInterface instanceof EmptyRoom) {
            return "\uD83D\uDaB4";
        }
        if (roomInterface instanceof Player) {
            return "\uD83E\uDDDD";

        } else if (roomInterface instanceof Empty) {
            return "e";
        } else {
            return "\uD83D\uDC7E";
        }
    }
}
