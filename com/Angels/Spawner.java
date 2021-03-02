package com.Angels;

import com.Game.BattlesStatistics;
import com.Heroes.AHero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;
/**
 @see AAngel
 */
public class Spawner extends AAngel {
    private final float wizardHP = 120f;
    private final float pyromancerHP = 150f;
    private final float rogueHP = 180f;
    private final float knightHP = 200f;

    Spawner() {
        super("Spawner");
    }

    /**
     * @see AAngel {@link #notifyObservers(Object)}
     */
    @Override
    public void notifyObservers(final Object arg) {
        if (arg instanceof AHero && ((AHero) arg).getHp() > 0) {
            super.getObserver().update(this, super.getName() + " helped "
                    + ((AHero) arg).getFullName() + " " + ((AHero) arg).getId() + "\n");

            ((AHero) arg).getObserver().update(this, "Player "
                    + ((AHero) arg).getFullName() + " " + ((AHero) arg).getId() + " was brought"
                    + " to life by an angel\n");
        }
    }
    /**
     *
     * @see AAngel {@link #execute(Wizard)}
     */
    @Override
    public void execute(final Wizard victim) {
        if (victim.getHp() > 0) {
            return;
        }
        victim.setHp(wizardHP);
        BattlesStatistics.getInstance().setStatus(victim.getId(), true);
        notifyObservers(victim);
    }
    /**
     *
     * @param victim is the subject of an angel's action
     */
    @Override
    public void execute(final Pyromancer victim) {
        if (victim.getHp() > 0) {
            return;
        }
        victim.setHp(pyromancerHP);
        BattlesStatistics.getInstance().setStatus(victim.getId(), true);
        notifyObservers(victim);
    }
    /**
     *
     * @see AAngel {@link #execute(Rogue)}
     */
    @Override
    public void execute(final Rogue victim) {
        if (victim.getHp() > 0) {
            return;
        }
        victim.setHp(rogueHP);
        BattlesStatistics.getInstance().setStatus(victim.getId(), true);
        notifyObservers(victim);
    }
    /**
     *
     * @see AAngel {@link #execute(Knight)}
     */
    @Override
    public void execute(final Knight victim) {
        if (victim.getHp() > 0) {
            return;
        }
        victim.setHp(knightHP);
        BattlesStatistics.getInstance().setStatus(victim.getId(), true);
        notifyObservers(victim);
    }

}
