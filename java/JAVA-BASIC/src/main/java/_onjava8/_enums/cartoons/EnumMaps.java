package _onjava8._enums.cartoons;

import _onjava8._enums.menu.AlarmPoints;

import java.util.EnumMap;
import java.util.Map;

interface Command { void action(); }

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN,
                () -> System.out.println("Kitchen fire!"));
        em.put(AlarmPoints.BATHROOM,
                () -> System.out.println("Bathroom alter!"));
        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            System.out.println(e.getKey() + " : ");
            e.getValue().action();
        }
        try {
            em.get(AlarmPoints.UTILITY).action();
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
    }
}
