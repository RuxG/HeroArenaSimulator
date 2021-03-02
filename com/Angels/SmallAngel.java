package com.Angels;

import com.Heroes.AHero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;

/**
 * @see AAngel
 */
public class SmallAngel extends AAngel {
    private final float wizardHP = 25f;
    private final float pyromancerHP = 15f;
    private final float rogueHP = 20f;
    private final float knightHP = 10f;

    private final float wizardDmgA = 0.1f;
    private final float pyromancerDmgA = 0.15f;
    private final float rogueDmgA = 0.05f;
    private final float knightDmgA = 0.1f;

    SmallAngel() {
        super("SmallAngel");
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
     * @see AAngel {@link #execute(Wizard)}
     */
    @Override
    public void execute(final Wizard victim) {
        if (victim.getHp() > 0) {
            victim.setHp(victim.getHp() + wizardHP);
            victim.setBonusDmgA(wizardDmgA + victim.getBonusDmgA());
            notifyObservers(victim);
        }
    }

    /**
     * @param victim is the subject of an angel's action
     */
    @Override
    public void execute(final Pyromancer victim) {
        if (victim.getHp() > 0) {
            victim.setHp(victim.getHp() + pyromancerHP);
            victim.setBonusDmgA(pyromancerDmgA + victim.getBonusDmgA());
            notifyObservers(victim);
        }
    }

    /**
     * @see AAngel {@link #execute(Rogue)}
     */
    @Override
    public void execute(final Rogue victim) {
        if (victim.getHp() > 0) {
            victim.setHp(victim.getHp() + rogueHP);
            victim.setBonusDmgA(rogueDmgA + victim.getBonusDmgA());
            notifyObservers(victim);
        }
    }

    /**
     * @see AAngel {@link #execute(Knight)}
     */
    @Override
    public void execute(final Knight victim) {
        if (victim.getHp() > 0) {
            victim.setHp(victim.getHp() + knightHP);
            victim.setBonusDmgA(knightDmgA + victim.getBonusDmgA());
            notifyObservers(victim);
        }
    }

}
