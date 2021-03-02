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
public class TheDoomer extends AAngel {
    TheDoomer() {
        super("TheDoomer");
    }

    /**
     * @see AAngel {@link #notifyObservers(Object)}
     */
    @Override
    public void notifyObservers(final Object arg) {
        if (arg instanceof AHero) {
            super.getObserver().update(this, super.getName() + " hit "
                    + ((AHero) arg).getFullName() + " " + ((AHero) arg).getId() + "\n");
            ((AHero) arg).notifyObservers(this);

        }
    }

    /**
     *
     * @param victim is the hero which the angel will kill
     */
    public void kill(final AHero victim) {
        if (victim.getHp() > 0) {
            victim.setHp(0);
            BattlesStatistics.getInstance().setStatus(victim.getId(), false);
        }
    }
    /**
     *
     * @see AAngel {@link #execute(Wizard)}
     */
    @Override
    public void execute(final Wizard victim) {
        if (victim.getHp() > 0) {

            kill(victim);
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

            kill(victim);
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

            kill(victim);
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

            kill(victim);
            notifyObservers(victim);
        }
    }

}
