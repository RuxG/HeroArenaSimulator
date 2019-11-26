package com.Abilities.Pyromancer;

import com.Abilities.IAbility;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Heroes.*;

public class Fireblast implements IAbility {

    private float raceA = 1f;
    private float landA = 1f;

    public BattlesStatistics.AttackInfo computeDamage(Hero caster, Hero victim) {
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

    public BattlesStatistics.AttackInfo execute(Hero caster, Wizard victim) {
        raceA = Constants.FIREBLAST_WIZARD_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Rogue victim) {
        raceA = Constants.FIREBLAST_ROGUE_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Pyromancer victim) {
        raceA = Constants.FIREBLAST_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Knight victim) {
        raceA = Constants.FIREBLAST_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
