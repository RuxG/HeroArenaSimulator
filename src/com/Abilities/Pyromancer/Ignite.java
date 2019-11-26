package com.Abilities.Pyromancer;

import com.Abilities.IAbility;
import com.Abilities.OvertimeEffect;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Heroes.*;

public class Ignite implements IAbility {

    private float raceA = 1f;
    private float landA = 1f;

    public BattlesStatistics.AttackInfo computeDamage(Hero caster, Hero victim) {
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

        effect = new OvertimeEffect(effectRounds, Math.round((Constants.IGNITE_EFFECT_BASE_DMG + caster.getLvl() *
                Constants.IGNITE_EFFECT_UP_DMG) * raceA * landA), false, victim);
        victim.setEffect(effect);

        return info;
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Wizard victim) {

        raceA = Constants.IGNITE_WIZARD_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Rogue victim) {

        raceA = Constants.IGNITE_ROGUE_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Pyromancer victim) {
        raceA = Constants.IGNITE_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Knight victim) {
        raceA = Constants.IGNITE_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
