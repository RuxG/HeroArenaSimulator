package com.Angels;

import com.Heroes.AHero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;

/**
 @see AAngel
 */
public class XpAngel extends AAngel {
    XpAngel() {
        super("XPAngel");
    }
    private final float wizardHP = 60f;
    private final float pyromancerHP = 50f;
    private final float rogueHP = 40f;
    private final float knightHP = 45f;

    /**
     * @see AAngel {@link #notifyObservers(Object)}
     */
    @Override
    public void notifyObservers(final Object arg) {
        if (arg instanceof AHero && ((AHero) arg).getHp() > 0) {

            super.getObserver().update(this, super.getName() + " helped "
                    + ((AHero) arg).getFullName() + " " + ((AHero) arg).getId() + "\n");
        }
    }
    /**
     *
     * @see AAngel {@link #execute(Wizard)}
     */
    @Override
    public void execute(final Wizard victim) {
        if (victim.getHp() > 0) {

            victim.setExp(victim.getExp() + wizardHP);
            notifyObservers(victim);
            victim.checkLvlUp();
        }
    }
    /**
     *
     * @param victim is the subject of an angel's action
     */
    @Override
    public void execute(final Pyromancer victim) {
        if (victim.getHp() > 0) {
            victim.setExp(victim.getExp() + pyromancerHP);
            notifyObservers(victim);
            victim.checkLvlUp();
        }
    }
    /**
     *
     * @see AAngel {@link #execute(Rogue)}
     */
    @Override
    public void execute(final Rogue victim) {
        if (victim.getHp() > 0) {
            victim.setExp(victim.getExp() + rogueHP);
            notifyObservers(victim);
            victim.checkLvlUp();
        }
    }
    /**
     *
     * @see AAngel {@link #execute(Knight)}
     */
    @Override
    public void execute(final Knight victim) {
        if (victim.getHp() > 0) {
            victim.setExp(victim.getExp() + knightHP);
            notifyObservers(victim);
            victim.checkLvlUp();
        }
    }
}
