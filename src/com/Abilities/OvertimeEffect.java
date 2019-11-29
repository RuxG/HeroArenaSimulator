package com.Abilities;

import com.Heroes.Hero;

/**
 * This class represents an overtime effect:
 * - has a *victim*
 * - applies a *damage*
 * - stuns / does not stun the *victim*
 * - activates for a *number of rounds*
 */
public class OvertimeEffect {
    private Hero victim;
    private int noRounds;
    private float dmg;
    private boolean immobility;

    public OvertimeEffect(final int noRounds, final float dmg, final boolean imobility,
                          final Hero victim) {
        this.noRounds = noRounds;
        this.dmg = dmg;
        this.immobility = imobility;
        this.victim = victim;
    }

    public void execute() {
        noRounds--;
        if (noRounds >= 0) {
            victim.setHp(victim.getHp() - dmg);
        } else {
            dmg = 0;
            immobility = false;
        }
    }

    public final int getNoRounds() {
        return noRounds;
    }

    public final void setNoRounds(final int noRounds) {
        this.noRounds = noRounds;
    }

    public final float getDmg() {
        return dmg;
    }

    public final void setDmg(final float dmg) {
        this.dmg = dmg;
    }

    public final boolean isImmobility() {
        return immobility;
    }

    public final void setImmobility(final boolean immobility) {
        this.immobility = immobility;
    }
}
