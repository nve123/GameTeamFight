package ru.nepretimov.teamfight.util;

import ru.nepretimov.teamfight.unit.MachineGunner;
import ru.nepretimov.teamfight.unit.Magika;
import ru.nepretimov.teamfight.unit.Unit;
import ru.nepretimov.teamfight.unit.Warrior;

import java.util.Random;

public class
UnitUtil {
    public static int random(int min, int max) {
        Random r = new Random();
        return r.nextInt(min, max);
    }

    public static Unit generateUnit() {
        int unitType = random(1, 4);
        Unit resUnit = null;

        switch (unitType) {
            case 1:
                resUnit = generateMagika();
                break;
            case 2:
                resUnit = generateMachineGunner();
                break;
            case 3:
                resUnit = generateWarrior();
                break;
        }
        return resUnit;
    }

    public static Magika generateMagika() {
        return new Magika("Egor" + random(1, 1000), random(50, 100), random(20, 100));
    }

    public static Warrior generateWarrior() {
        return new Warrior("Vadim" + random(1, 1000), random(50, 200), random(90, 1000));
    }

    public static MachineGunner generateMachineGunner() {
        return new MachineGunner("Heavy" + random(1, 1000), random(20, 50), random(100, 1000));
    }
}
