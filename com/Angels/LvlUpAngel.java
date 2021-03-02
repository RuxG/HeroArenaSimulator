package com.Angels;

import com.Heroes.AHero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;
/**
 @see AAngel
 */
public class LvlUpAngel extends AAngel {

    private final float wizardDmgA = 0.25f;
    private final float pyromancerDmgA = 0.2f;
    private final float rogueDmgA = 0.15f;
    private final float knightDmgA = 0.1f;
    LvlUpAngel() {
        super("LevelUpAngel");
    }

    /**
     * @see AAngel {@link #notifyObservers(Object)}
     */
    @Override
    public void notifyObservers(final Object arg) {
        if (arg instanceof AHero && ((AHero) arg).getHp() > 0) {
            super.getObserver().update(this, super.getName() + " helped "
                    + ((AHero) arg).getFullName() + " " + ((AHero) arg).getId() + "\n");

            ((AHero) arg).getObserver().update(((AHero) arg), ((AHero) arg).getFullName() + " "
                    + ((AHero) arg).getId() + " reached level " + ((AHero) arg).getLvl() + "\n");
        }
    }

    /**
     * This method levels up the victim.
     * @param victim is the hero which will level up
     */
    void lvlUp(final AHero victim) {
        int expLvlUp = com.Constants.LVL_UP_EXP + victim.getLvl() * com.Constants.LVL_STEP;
        victim.setExp(expLvlUp);
        victim.setLvl(victim.getLvl() + 1);
        victim.setMaxHP(victim.getBaseHP() + victim.getUpHP() * victim.getLvl());
        victim.setHp(victim.getMaxHP());
    }

    /**
     *
     * @see AAngel {@link #execute(Wizard)}
     */
    @Override
    public void execute(final Wizard victim) {
        if (victim.getHp() > 0) {
            lvlUp(victim);
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
            lvlUp(victim);
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
            lvlUp(victim);
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
            lvlUp(victim);
            victim.setBonusDmgA(knightDmgA + victim.getBonusDmgA());
            notifyObservers(victim);
        }
    }

}
