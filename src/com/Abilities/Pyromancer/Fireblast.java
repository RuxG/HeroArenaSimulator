package com.Abilities.Pyromancer;

import com.Abilities.IAbility;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Heroes.Hero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;

public class Fireblast implements IAbility {

    private float raceA = 1f;
    private float landA = 1f;

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo computeDamage(final Hero caster, final Hero victim) {
        float dmg = 0f;
        landA = 1f;
        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();

        if (caster.getPosition().getKey() == 'V') {
            landA = Constants.PYROMANCER_LAND_BONUS;
        }
        dmg = Constants.FIREBLAST_BASE_DMG + Constants.FIREBLAST_UP_DMG * caster.getLvl();

        dmg *= landA;

        info.setBruteDmg((float) Math.round(dmg));

        dmg *= raceA;
        dmg = Math.round(dmg);
        info.setTotalDmg(dmg);

        return info;
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Wizard victim) {
        raceA = Constants.FIREBLAST_WIZARD_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Rogue victim) {
        raceA = Constants.FIREBLAST_ROGUE_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Pyromancer victim) {
        raceA = Constants.FIREBLAST_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Knight victim) {
        raceA = Constants.FIREBLAST_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
