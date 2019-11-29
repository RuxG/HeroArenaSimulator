package com.Abilities.Pyromancer;

import com.Abilities.IAbility;
import com.Abilities.OvertimeEffect;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Heroes.Hero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;

public class Ignite implements IAbility {

    private float raceA = 1f;
    private float landA = 1f;

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo computeDamage(final Hero caster, final Hero victim) {
        float dmg = 0f;
        landA = 1f;
        OvertimeEffect effect;
        int effectRounds = Constants.IGNITE_EFFECT_DUR;

        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();

        if (caster.getPosition().getKey() == 'V') {
            landA = Constants.PYROMANCER_LAND_BONUS;
        }

        dmg = Constants.IGNITE_BASE_DMG + Constants.IGNITE_UP_DMG * caster.getLvl();
        dmg *= landA;
        info.setBruteDmg((float) Math.round(dmg));

        dmg *= raceA;
        dmg = Math.round(dmg);
        info.setTotalDmg(dmg);

        effect = new OvertimeEffect(effectRounds,
                Math.round((Constants.IGNITE_EFFECT_BASE_DMG + caster.getLvl()
                        * Constants.IGNITE_EFFECT_UP_DMG) * raceA * landA), false, victim);
        victim.setEffect(effect);

        return info;
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Wizard victim) {

        raceA = Constants.IGNITE_WIZARD_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Rogue victim) {

        raceA = Constants.IGNITE_ROGUE_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Pyromancer victim) {
        raceA = Constants.IGNITE_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Knight victim) {
        raceA = Constants.IGNITE_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
