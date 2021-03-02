package com.Angels;

import com.Heroes.AHero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;
/**
 @see AAngel
 */
public class LifeGiver extends AAngel {
    private final float wizardHP = 120f;
    private final float pyromancerHP = 80f;
    private final float rogueHP = 90f;
    private final float knightHP = 100f;


    LifeGiver() {
        super("LifeGiver");
    }

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
            victim.setHp(victim.getHp() + wizardHP);
            if (victim.getHp() > victim.getMaxHP()) {
                victim.setHp(victim.getMaxHP());
            }
            notifyObservers(victim);
        }
    }
    /**
     *
     * @param victim is the subject of an angel's action
     */
    @Override
    public void execute(final Pyromancer victim) {
        if (victim.getHp() > 0) {
            victim.setHp(victim.getHp() + pyromancerHP);
            if (victim.getHp() > victim.getMaxHP()) {
                victim.setHp(victim.getMaxHP());
            }
            notifyObservers(victim);
        }
    }
    /**
     *
     * @see AAngel {@link #execute(Rogue)}
     */
    @Override
    public void execute(final Rogue victim) {
        if (victim.getHp() > 0) {
            victim.setHp(victim.getHp() + rogueHP);
            if (victim.getHp() > victim.getMaxHP()) {
                victim.setHp(victim.getMaxHP());
            }
            notifyObservers(victim);
        }
    }
    /**
     *
     * @see AAngel {@link #execute(Knight)}
     */
    @Override
    public void execute(final Knight victim) {
        if (victim.getHp() > 0) {
            victim.setHp(victim.getHp() + knightHP);
            if (victim.getHp() > victim.getMaxHP()) {
                victim.setHp(victim.getMaxHP());
            }
            notifyObservers(victim);
        }
    }

}
