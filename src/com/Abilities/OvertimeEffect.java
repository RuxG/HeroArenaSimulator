package com.Abilities;

import com.Heroes.Hero;

public class OvertimeEffect {
    private Hero victim;
    private int noRounds;
    private float dmg;
    private boolean imobility;

    public OvertimeEffect(int noRounds, float dmg, boolean imobility, Hero victim) {
        this.noRounds = noRounds;
        this.dmg = dmg;
        this.imobility = imobility;
        this.victim = victim;
    }

    public void execute() {
        noRounds--;
        if (noRounds >= 0) {
            victim.setHp(victim.getHp() - dmg);
        } else {
            dmg = 0;
            imobility = false;
        }
    }

    public int getNoRounds() {
        return noRounds;
    }

    public void setNoRounds(int noRounds) {
        this.noRounds = noRounds;
    }

    public float getDmg() {
        return dmg;
    }

    public void setDmg(float dmg) {
        this.dmg = dmg;
    }

    public boolean isImobility() {
        return imobility;
    }

    public void setImobility(boolean imobility) {
        this.imobility = imobility;
    }
}
