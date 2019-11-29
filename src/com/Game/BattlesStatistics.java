package com.Game;

import java.util.Hashtable;

/**
 * This class retains information about overall statistics of the battles.
 */
public final class BattlesStatistics {
    private static BattlesStatistics instance;
    private Hashtable<Integer, HeroInfo> statistics;

    private BattlesStatistics() {
        statistics = new Hashtable<>();
    }

    public static BattlesStatistics getInstance() {
        if (instance == null) {
            instance = new BattlesStatistics();
        }
        return instance;
    }

    public void addBattle(final int id, final boolean won) {
        if (won) {
            statistics.get(id).battlesWon++;
        } else {
            statistics.get(id).battlesLost++;
        }
        statistics.get(id).totalBattles++;
    }

    public void setStatus(final int id, final boolean alive) {
        statistics.get(id).setStatus(alive);
    }

    public Hashtable<Integer, HeroInfo> getStatistics() {
        return statistics;
    }


    /**
     * This class retains information about a hero's battles history:
     * total number of battles, total winnings, defeats, as
     * well as defines one's status as alive / dead.
     */
    public static final class HeroInfo {
        private int battlesWon;
        private int battlesLost;
        private int totalBattles;
        private boolean status = true;

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

        public void setStatus(final boolean status) {
            this.status = status;
        }

    }

    /**
     * This class retains information about an attack outcome: damage with
     * and without modifiers.
     */
    public static final class AttackInfo {
        private Float bruteDmg = 0f;
        private Float totalDmg = 0f;

        public Float getBruteDmg() {
            return bruteDmg;
        }

        public void setBruteDmg(final Float bruteDmg) {
            this.bruteDmg = bruteDmg;
        }

        public Float getTotalDmg() {
            return totalDmg;
        }

        public void setTotalDmg(final Float totalDmg) {
            this.totalDmg = totalDmg;
        }
    }

}
