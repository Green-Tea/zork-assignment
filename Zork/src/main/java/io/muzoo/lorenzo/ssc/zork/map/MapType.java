package io.muzoo.lorenzo.ssc.zork.map;

public enum MapType {

    FIRST_FLOOR(FirstFloor.class, "first floor"),
    SECOND_FLOOR(SecondFloor.class, "second floor"),
    ;

    private Class<? extends Map> mapClass;
    private String mapName;

    MapType(Class<? extends Map> mapClass, String mapName) {
        this.mapClass = mapClass;
        this.mapName = mapName;
    }

    public Class<? extends  Map> getMapClass() {
        return mapClass;
    }

    public String getMapName() {
        return mapName;
    }
}
