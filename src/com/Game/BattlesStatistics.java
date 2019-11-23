package com.Game;

import java.util.Hashtable;

public class BattlesStatistics {
    private static BattlesStatistics instance = null;
    Hashtable<Integer, HeroInfo> statistics;

    private BattlesStatistics() {
        statistics = new Hashtable<>();
    }

    public static BattlesStatistics getInstance() {
        if (instance == null) {
            instance = new BattlesStatistics();
        }
        return instance;
    }

    public void addBattle(int id, boolean won) {
        if (won == true) {
            statistics.get(id).battlesWon++;
        } else {
            statistics.get(id).battlesLost++;
        }
        statistics.get(id).totalBattles++;
    }

    public void setStatus(int id, boolean alive) {
        statistics.get(id).setStatus(alive);
    }

    public Hashtable<Integer, HeroInfo> getStatistics() {
        return statistics;
    }

    public static class HeroInfo {
        int battlesWon;
        int battlesLost;
        int totalBattles;
        boolean status = true;

        public int getBattlesLost() {
            return battlesLost;
        }

        public int getBattlesWon() {
            return battlesWon;
        }

        public int getTotalBattles() {
            return totalBattles;
        }

        public void addBattles() {
            totalBattles++;
        }

        public boolean getStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

    }

    public static class AttackInfo {
        Float bruteDmg = 0f;
        Float totalDmg = 0f;

        public Float getBruteDmg() {
            return bruteDmg;
        }

        public void setBruteDmg(Float bruteDmg) {
            this.bruteDmg = bruteDmg;
        }

        public Float getTotalDmg() {
            return totalDmg;
        }

        public void setTotalDmg(Float totalDmg) {
            this.totalDmg = totalDmg;
        }
    }

}
