package ru.nepretimov.teamfight.unit;


import ru.nepretimov.teamfight.util.UnitUtil;

public class Team {
    private Unit[] units;
    private boolean isWinner;
    private String name;

    public Team(int countTeamMember, String name) {
        this.units = new Unit[countTeamMember];
        this.name = name;
        for (int i = 0; i < units.length; i++) {
            units[i] = UnitUtil.generateUnit();
        }
        this.isWinner = false;
    }

    public boolean allUnitsIsDie() {
        int counterDeath = 0;
        for (int i = 0; i < units.length; i++) {
            if (!units[i].isAlive) {
                counterDeath++;
            }
        }
        return counterDeath == units.length;
    }

    public Unit[] getUnits() {
        return units;
    }

    public boolean getIsWinner() {
        return isWinner;
    }

    public String getName() {
        return name;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
