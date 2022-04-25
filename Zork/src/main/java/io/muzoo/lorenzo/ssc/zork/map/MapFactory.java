package io.muzoo.lorenzo.ssc.zork.map;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class MapFactory {

    private static final java.util.Map<MapType, Map> availableMap = new HashMap<>();

    static {
        for (MapType mapType : MapType.values()) {
            try {
                Map map = mapType.getMapClass().getDeclaredConstructor().newInstance();
                availableMap.put(mapType, map);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map get(MapType mapType) {
        return availableMap.get(mapType);
    }

    public static java.util.Map<MapType, Map> getAvailableMap() {
        return availableMap;
    }

    public Map createMap(MapType mapName) {
        for (MapType map : availableMap.keySet()) {
            if (mapName.getMapName().equals(map.getMapName())) {
                try {
                    return availableMap.get(map).getClass().getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
