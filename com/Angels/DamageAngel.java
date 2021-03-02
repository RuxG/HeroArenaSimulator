package com.Angels;

import com.Heroes.AHero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;

/**
 @see AAngel
 */
public class DamageAngel extends AAngel {
    private final float wizardDmgA = 0.4f;
    private final float pyromancerDmgA = 0.2f;
    private final float rogueDmgA = 0.3f;
    private final float knightDmgA = 0.15f;

    DamageAngel() {
        super("DamageAngel");
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
            victim.setBonusDmgA(wizardDmgA + victim.getBonusDmgA());
            notifyObservers(victim);
        }
    }

    /**
     *
     * @see AAngel {@link #execute(Pyromancer)}
     */
    @Override
    public void execute(final Pyromancer victim) {
        if (victim.getHp() > 0) {
            victim.setBonusDmgA(pyromancerDmgA + victim.getBonusDmgA());
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
            victim.setBonusDmgA(rogueDmgA + victim.getBonusDmgA());
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
            victim.setBonusDmgA(knightDmgA + victim.getBonusDmgA());
            notifyObservers(victim);
        }
    }

}
