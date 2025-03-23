package ru.nepretimov.teamfight.service;

import ru.example.game.unit.Team;
import ru.example.game.unit.Unit;

public class Game {
    private final Team t1;
    private final Team t2;

    public Game() {
        t1 = new Team(4, "team1");
        t2 = new Team(4, "team2");
    }

    public String fight() {
        Unit[] t1Units = t1.getUnits();
        Unit[] t2Units = t2.getUnits();
        int curNumberT1 = 0;
        int curNumberT2 = 0;
        while (!t1.allUnitsIsDie() && !t2.allUnitsIsDie()) {
            while (t1Units[curNumberT1].isAlive() && t2Units[curNumberT2].isAlive()) {
                t1Units[curNumberT1].attack(t2Units[curNumberT2]);
                System.out.println(t1Units[curNumberT1].getName() + " атаковал юнита вражеской команды " + t2.getName() + t2Units[curNumberT2].getName() + " на " + t1Units[curNumberT1].getDmg() + " dmg");
                System.out.println();
                t2Units[curNumberT2].attack(t1Units[curNumberT1]);
                System.out.println(t2Units[curNumberT2].getName() + " атаковал юнита вражеской команды " + t1.getName() + t1Units[curNumberT1].getName() + " на " + t1Units[curNumberT2].getDmg() + " dmg");
                System.out.println();
            }
            if (!t1Units[curNumberT1].isAlive() && t1Units.length - 1 > curNumberT1) {
                curNumberT1++;
            } else if (!t2Units[curNumberT2].isAlive() && t2Units.length - 1 > curNumberT2) {
                curNumberT2++;
            }
        }
        if (t1.allUnitsIsDie() && t2.allUnitsIsDie()) {
            return "ты как это сделал !?";
        } else if (t1.allUnitsIsDie()) {
            t2.setWinner(true);
            return t2.getName();
        } else {
            t1.setWinner(true);
            return t1.getName();
        }
    }
}
