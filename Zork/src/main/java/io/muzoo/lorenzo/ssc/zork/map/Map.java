package io.muzoo.lorenzo.ssc.zork.map;

public abstract class Map {
    private String name;
    private String desc;
    private String objective;
    private Room startingRoom;
    public abstract boolean taskComplete();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public Room getStartingRoom() {
        return startingRoom;
    }

    public void setStartingRoom(Room startingRoom) {
        this.startingRoom = startingRoom;
    }

    public abstract void showMap();

}
