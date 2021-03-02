package com.Angels;

import com.Heroes.AHero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;
/**
 @see AAngel
 */
public class GoodBoy extends AAngel {
    private final float wizardHP = 50;
    private final float pyromancerHP = 30f;
    private final float rogueHP = 40f;
    private final float knightHP = 20f;

    private final float wizardDmgA = 0.3f;
    private final float pyromancerDmgA = 0.5f;
    private final float rogueDmgA = 0.4f;
    private final float knightDmgA = 0.4f;
    GoodBoy() {
        super("GoodBoy");
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
            victim.setBonusDmgA(wizardDmgA + victim.getBonusDmgA());
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
            victim.setHp(victim.getHp() + rogueHP);
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
            victim.setHp(victim.getHp() + knightHP);
            victim.setBonusDmgA(knightDmgA + victim.getBonusDmgA());
            notifyObservers(victim);
        }
    }

}
