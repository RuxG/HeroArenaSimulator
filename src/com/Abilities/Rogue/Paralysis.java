package com.Abilities.Rogue;

import com.Abilities.IAbility;
import com.Abilities.OvertimeEffect;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Heroes.*;


public class Paralysis implements IAbility {
    private float raceA = 1f;
    private float landA = 1f;

    public BattlesStatistics.AttackInfo computeDamage(Hero caster, Hero victim) {
        float dmg = 0f;
        landA = 1f;
        OvertimeEffect effect;
        int effectRounds = Constants.PARALYSIS_EFFECT_ROUND;

        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();

        if (caster.getPosition().getKey() == 'W') {
            effectRounds *= Constants.PARALYSIS_EFFECT_ROUND_AMPLIFIER;
            landA = Constants.ROGUE_LAND_BONUS;
        }
        effect = new OvertimeEffect(effectRounds, Math.round((Constants.PARALYSIS_BASE_DMG + caster.getLvl() *
                Constants.PARALYSIS_UP_DMG) * landA * raceA), true, victim);
        dmg = (Constants.PARALYSIS_BASE_DMG + caster.getLvl() * Constants.PARALYSIS_UP_DMG);

        dmg *= landA;
        info.setBruteDmg((float) Math.round(dmg));

        dmg *= raceA;
        dmg = Math.round(dmg);
        info.setTotalDmg(dmg);

        victim.setEffect(effect);
        return info;
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Wizard victim) {
        raceA = Constants.PARALYSIS_WIZARD_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Rogue victim) {
        raceA = Constants.PARALYSIS_ROGUE_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Pyromancer victim) {
        raceA = Constants.PARALYSIS_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Knight victim) {
        raceA = Constants.PARALYSIS_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}