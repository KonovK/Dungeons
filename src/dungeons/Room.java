package dungeons;

import heroes.Player;

public class Room {

    private RoomInterface roomInterface;

    public Room(){
        this.roomInterface = new Player(100,"test", "test");
    }
}
